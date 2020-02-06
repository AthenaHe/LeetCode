package com.test.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.test.leetcode1.test001_050.TreeNode;

public class test1201_now {
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//树结点定义
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
/*
 * 1221. 分割平衡字符串
 */
public int balancedStringSplit(String s) {
	int balance=0,count=0;
	//思路：遇到R加1，遇到L减1，当计数为0说明有一个平衡字符串
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i)=='L') {
			count++;
		}
		if (s.charAt(i)=='R') {
			count--;
		}
		if (count==0) {
			balance++;
		}
	}
	return balance;   
}


/*
 * 1297. 子串的最大出现次数
 */
public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
	Map<String, Integer> counter = new HashMap<>();
    int res = 0;
    //单层循环只考虑minSize。原因是maxSize中肯定包含minSize子串，那么只需要考虑minSize长度的子串最大出现次数即可
    for (int i = 0; i < s.length() - minSize + 1; i++) {
    	//子串
        String substr = s.substring(i, i + minSize);
       //如果子串长度大于maxLetters，说明不符合条件，如果子串长度小于等于maxLetters，说明符合条件，继续判断出现最大次数。
        if (checkNum(substr, maxLetters)) {
            int newVal = counter.getOrDefault(substr, 0) + 1;
            counter.put(substr, newVal);
            res = Math.max(res, newVal);
        }
    }

    return res;
}
public boolean checkNum(String substr, int maxLetters) {

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < substr.length(); i++)
        set.add(substr.charAt(i));

    return set.size() <= maxLetters;
}

/*
 * 1232. 缀点成线
 */
	public static boolean checkStraightLine(int[][] coordinates) {
		int x1, x2, y1, y2;
		boolean flag = true;
		x1 = coordinates[0][0];
		x2 = coordinates[1][0];
		y1 = coordinates[0][1];
		y2 = coordinates[1][1];
		if (x2 == x1) {// 斜率为0
			flag = false;
		}
		int pointcount = coordinates.length;// 点的个数
		if (flag) { // 如果存在斜率；
			int k = (y2 - y1) / (x2 - x1);// 斜率
			for (int i = 2; i < coordinates.length; i++) {
				if (coordinates[i][0] - x1==0) {
					return false;
				}
				if (k*1.0 != (coordinates[i][1] - y1)*1.0 / (coordinates[i][0] - x1)) {
					return false;
				}
			}
		} else {
			for (int i = 2; i < coordinates.length; i++) {
				if ((coordinates[i][0] - x1) != 0) {
					return false;
				}
			}
		}
		return true;
	}
/*
 * 1237. 找出给定方程的正整数解	
 */
interface CustomFunction {
	public int f(int x, int y);
};
public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
	List<List<Integer>> lists=new ArrayList<>();	
	for (int i = 0; i <= z; i++) {
		for (int j = 0; j <=z; j++) {
			List<Integer> list = new ArrayList<>();
			if (customfunction.f(i, j)==z) {
				list.add(i);
				list.add(j);
				lists.add(list);
			}
			
		}
	}
	return lists;
}
/*
 * 1247. 交换字符使得字符串相同
 */
public int minimumSwap(String s1, String s2) {
	int count1=0,count2=0;
	for (int i = 0; i < s1.length(); i++) {
		if ((s1.substring(i, i+1)+s2.substring(i,i+1)).equals("xy")) {			
			count1++;
		}
		if ((s1.substring(i, i+1)+s2.substring(i,i+1)).equals("yx")) {
			count2++;
		}
	}
	if ((count1+count2)%2!=0) {
		return -1;
	}
	return count1/2+count2/2+((count1%2!=0?0:2));    
}
/*
 * 1252. 奇数值单元格的数目
 */
public int oddCells(int n, int m, int[][] indices) {
	int[] row=new int[n];
	int[] col=new int[m];
	int res=0;
for (int i = 0; i < indices.length; i++) {
    row[indices[i][0]]++;//这一行都加1
	col[indices[i][1]]++;//这一列都加1	
}
for (int i = 0; i < n; i++) {
	for (int j = 0; j < m; j++) {
		if ((row[i]+col[j])%2!=0) {
			res++;
		}
	}
}
	return res;       
}

/*
 * 1260. 二维网格迁移
 * 将二维数组转换为一维数组，再将所有元素迁移k步，最后再转换二维数组
 * 题目意思相当于每一次操作是循环右移一维数组
 */
public List<List<Integer>> shiftGrid(int[][] grid, int k) {
	List<List<Integer>> lists = new ArrayList<>();
	if (grid.length==1) {
		List<Integer> list = new ArrayList<>();
		list.add(grid[0][0]);
		lists.add(list);
		return lists;
	}
		//移动9次是一次循环，数组恢复原样
		for (int co = 0; co < k % 9; co++) {
			List<Integer> tmpList = new ArrayList<>();
			for (int i = grid.length - 1; i >= 0; i--) {
				for (int j = grid[i].length - 1; j >= 0; j--) {
					// 保存最后一列的元素
					if (j == grid[i].length - 1) {
						tmpList.add(grid[i][j]);
					}
					// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]
					if (j-1>=0) {
						grid[i][j] = grid[i][j - 1];
					}
					
				}
			}
			//位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
			//位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
			for (int i = 0; i < grid.length; i++) {
				if (i == 0) {
					grid[i][0] = tmpList.get(0);
				} else {
					grid[i][0] = tmpList.get(grid.length - i);
				}
			}
		}		
		// 将新数组放入list集合中并返回
		for (int i = 0; i < grid.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < grid[i].length; j++) {
				list.add(grid[i][j]);
			}
			lists.add(list);
		}
		return lists;
}

/*
 * 1266. 访问所有点的最小时间
 */
public int minTimeToVisitAllPoints(int[][] points) {
	int[] nowpoints= {points[0][0],points[0][1]};
	int step=0;
	for (int i = 1; i < points.length; i++) {		
	step+=Math.max(Math.abs(nowpoints[0]-points[i][0]), Math.abs(nowpoints[1]-points[i][1]));
	//System.out.println(Math.abs(nowpoints[0]-points[i][0])+","+Math.abs(nowpoints[1]-points[i][1]));
	nowpoints[0]=points[i][0];
	nowpoints[1]=points[i][1];
		}		
	return step;  
}
/*
 * 1268. 搜索推荐系统
 */
public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	List<List<String>> lists = new ArrayList<>();
	Arrays.sort(products);
	for (int i = 1; i <= searchWord.length(); i++) {
		List<String> list = new ArrayList<>();
		for (int j = 0; j < products.length; j++) {
			if (products[j].length()<searchWord.substring(0, i).length()) {
				continue;
			}
			if (products[j].substring(0,i).equals(searchWord.substring(0, i))) {
				list.add(products[j]);
				if (list.size()>3) {
					break;
				}
			}
		}
			lists.add(list);	
	}
	return lists;    
}
/*
 * 1275. 找出井字棋的获胜者
 */
	 /**
     * 思路：
     * 1、只关注最后一个玩家即可
     * 如果最后一个玩家的同一行或同一列或对角线上有三个或三个以上相同元素则最后一个玩家获胜
     * 至于最后一个玩家到底是A还是B可以通过判断索引是奇数还是偶数还确定到底是哪个玩家
     * 2、最后一个玩家没有获胜的情况
     * 此时检查一下方格是否已经被填满了，如果填满了说明是平局
     * 如果没有填满说明游戏还未结束
     *
     * @param moves
     * @return
     */
    public String tictactoe(int[][] moves) {
        // 同一行
        int rowCounter = 0;
        // 同一列
        int colCounter = 0;
        // 主对角线
        int mainCounter = 0;
        // 副对角线
        int subCounter = 0;
        int key = (moves.length - 1) % 2;
        int[] last = moves[moves.length - 1];
        int he = last[0] + last[1];
        int cha = last[0] - last[1];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == key) {
                int[] move = moves[i];
                if (move[0] == last[0]) {
                    rowCounter++;
                }
                if (move[1] == last[1]) {
                    colCounter++;
                }
                if (move[0] + move[1] == he) {
                    subCounter++;
                }
                if (move[0] - move[1] == cha) {
                    mainCounter++;
                }
            }
        }
        if (rowCounter >= 3 || colCounter >= 3 || mainCounter >= 3 || subCounter >= 3) {
            return key == 0 ? "A" : "B";
        }
        // 格子未填满并且未分出胜负的情况
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }
/*
 * 1281. 整数的各位积和之差
 */
public int subtractProductAndSum(int n) {
	String num = String.valueOf(n);
	int ji = 1,sum=0;
	for (int i = 0; i < num.length(); i++) {
		ji*=Integer.parseInt(num.substring(i, i+1));
		sum+=Integer.parseInt(num.substring(i, i+1));
	}	
	return ji-sum;
        
} 
/*
 * 1282. 用户分组
 */
public List<List<Integer>> groupThePeople(int[] groupSizes) {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer>[] list = new ArrayList[groupSizes.length+1];
    for (int i = 0; i < groupSizes.length; i++) {
		if (list[groupSizes[i]]==null) {
			list[groupSizes[i]] = new ArrayList<>();
		}
		list[groupSizes[i]].add(i);
		if (list[groupSizes[i]].size()==groupSizes[i]) {
			res.add(new ArrayList(list[groupSizes[i]]));
			list[groupSizes[i]].clear();
		}
	}
   return res;
}
/*
 * 1287. 有序数组中出现次数超过25%的元素
 */
public int findSpecialInteger(int[] arr) {
	int count=1,tmp=arr[0];
	for (int i = 1; i < arr.length; i++) {
		if (arr[i]==tmp) {
			count++;
			if (count>arr.length%4) {
				return arr[i];
			}
		}else {
			count=1;
			tmp=arr[i];
		}
	}
	return 0;   
}

/*
 * 1290. 二进制链表转整数
 */
public int getDecimalValue(ListNode head) {
	ListNode node=head;
	int num=node.val;
	while ((node=node.next)!=null) {
		num=node.val+num*2;
	}
	return num;   
}

/*
 * 1295. 统计位数为偶数的数字
 */
public int findNumbers(int[] nums) {
	int count=0;
	for (int i = 0; i < nums.length; i++) {
		if ((nums[i]+"").length()%2==0) {
			count++;
		}
	}
	return count; 
}

/*
 * 1302. 层数最深叶子节点的和
 */
public int deepestLeavesSum(TreeNode root) {
	if (root==null) return 0;
	int sum = 0;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
	sum=0;
	int size = queue.size();
	for (int i = 0; i < size; i++) {
		TreeNode node=queue.poll();
		sum+=node.val;
		if (node.left!=null) queue.offer(node.left);
		if (node.right!=null) queue.offer(node.right);
	}		
}
	return sum;
}
/*
 *1313. 解压缩编码列表 
 */
public int[] decompressRLElist(int[] nums) {
	int len=0;
	for (int i = 0; i < nums.length; i=i+2) {
		len+=nums[i];
	}
	int [] res=new int[len];
	int k=0;
	for (int i = 0; i < nums.length; i=i+2) {
		for (int j = 0; j < nums[i]; j++) {
			res[k++]=nums[i+1];
		}
	}
	return res;   
}
/*
 * 1323. 6 和 9 组成的最大数字
 */
public int maximum69Number (int num) {
	String str=String.valueOf(num);
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)=='6') {
			str=str.replaceFirst(str.substring(i, i+1), "9");
			break;
		}
	}
	return Integer.parseInt(str);    
}
/*
 * 1324. 竖直打印单词
 */
public static List<String> printVertically(String s) {
	List<String> list = new ArrayList<>();
	String[] ss = s.split(" ");
	int len=0;
	for (int i = 0; i < ss.length; i++) {
		len=Math.max(len, ss[i].length());
	}	
	for (int j = 0; j < len; j++) {
		String res = "";
		for (int i = 0; i < ss.length; i++) {
			if (j<ss[i].length()) {
				res+=ss[i].charAt(j);
			}else {
				res+=" ";
			}
			
		}
		for (int k = res.length()-1; k >=0; k++) {
			if (res.charAt(k)==' ') {
				continue;
			}else {
				res=res.substring(0,k+1);
				break;
			}
		}		
		list.add(res);
	}
	for (String str:list) {
		
	}
	
	
	return list;   
}
/*
 * 5134. 将每个元素替换为右侧最大元素
 */
public static int[] replaceElements(int[] arr) {
	List<Integer> list = new ArrayList<>();
	int max=Integer.MIN_VALUE;
	for (int i=arr.length-1; i>=0; i--) {
		if(i==arr.length-1) {
			list.add(-1);	
		}else {
			max = Math.max(max, arr[i+1]);
			list.add(max);
		}		
	}
	for (int i = 0; i < arr.length; i++) {
		arr[i] = list.get(arr.length-1-i);
	}
	return arr;
    
}
/*
 * 5295. 和为零的N个唯一整数
 */
public int[] sumZero(int n) {
	int[] res = new int[n];
	for (int i = 0; i < n/2; i++) {
		res[i] = i+1;
		res[n-1-i] = -(i+1);
	}
	return res;
    
}
/*
 * 5303. 解码字母到整数映射
 */
public String freqAlphabets(String s) {
	Map<String, Character> map = new HashMap<>();
	String res = "";
	for (int i = 1; i <= 26; i++) {
		if(i<10) {
		map.put(i+"", (char) ('a'+i-1));
		}else {
		map.put(i+"#", (char) ('a'+i-1));	
		}
	}
	for (String key:map.keySet()) {
		System.out.println("key:"+key+" value:"+map.get(key));
	}
	for (int i = s.length()-1; i >=0; i--) {
		if (s.charAt(i)=='#') {
			i=i-2;
			if (map.containsKey(s.substring(i, i+3))) {
				res=map.get(s.substring(i, i+3))+res;
			}
		}else {
			res = map.get(s.substring(i, i+1))+res;
		}
	}
	return res;    
}
/*
 * LCP 1. 猜数字
 */
public int game(int[] guess, int[] answer) {
	int count=0;
	for (int i = 0; i < guess.length; i++) {
		if (guess[i]==answer[i]) {
			count++;
		}
	}
	return count;    
}
/*
 * LCP 2.分式化简
 */
	public static int[] fraction(int[] cont) {
		int[] result= new int[2];
		int tmp=0;
		result[0]=cont[cont.length-1];
		result[1] = 1;
		for (int i = cont.length-1; i >0 ; i--) {
		tmp=result[1];
		result[1]=result[0];
		result[0]=cont[i-1]*result[0]+tmp;
		}
		tmp=gcd(result[0], result[1]);
		result[1]/=tmp;
		result[0]/=tmp;
		System.out.println(result[0]+","+result[1]);
		return result;   
	}
	//求最大公约数
	public static int  gcd(int a,int b) {
		while (a%b!=0) {
			int tmp=a%b;
			a=b;
			b=tmp;		
		}
		return b;	
	}
	public static void main(final String[] args) {
		String s="HOW ARE YOU";
		List<String> list = new ArrayList<>();
		list=printVertically(s);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
