package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class test951_1000 {
//树结点定义
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/*
 * 953.验证外星语词典
 */
public static boolean isAlienSorted(String[] words, String order) {
	Map<Character, Character> map = new HashMap<Character, Character>();
	//建立外星词典和地球词典的对应关系
	for (int i = 0; i < order.length(); i++) {
		map.put(order.charAt(i), (char) (97+i));
	}
	String[] newwords=new String[words.length];
	Arrays.fill(newwords, "");
	//进行翻译成地球文
	for (int i = 0; i < words.length; i++) {
		String[] word = words[i].split("");
		for (int j = 0; j < words[i].length(); j++) {
			word[j] = words[i].substring(j, j+1).replace(words[i].charAt(j), map.get(words[i].charAt(j)));			
			newwords[i]+=word[j];			
		}		
	}
	
	String[] sortwords = newwords.clone();
	//System.out.println(newwords[0]+","+newwords[1]+","+newwords[2]);	
	Arrays.sort(sortwords);	
	//System.out.println(sortwords[0]+","+sortwords[1]+","+sortwords[2]);
	for (int i = 0; i < sortwords.length; i++) {
		System.out.println(">>>>>>"+sortwords[i]+","+newwords[i]);
		if (!sortwords[i].equals(newwords[i])) {
			return false;
		}
	}
	return true;

 }
	/*
	 * 961. 重复 N 次的元素
	 */
	public int repeatedNTimes(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			if (A[i]==A[i+1]) {
				return A[i];
			}
		}
		return 0;    
	}
	/*
	 * 965. 单值二叉树
	 */
	public boolean isUnivalTree(TreeNode root) {
		if (root==null) {
			return true;
		}
		if (root.left!=null&&root.left.val!=root.val) {
			return false;
		}
		if (root.right!=null&&root.right.val!=root.val) {
				return false;
		}
		return isUnivalTree(root.left)&&isUnivalTree(root.right);
	}
/*
 * 969. 煎饼排序	
 */
public static List<Integer> pancakeSort(int[] A) {
	List<Integer> list = new ArrayList<>();
	int size=A.length-1;
	while(size>0) {
		if (findnum(A, size)<size) {
			list.add(findnum(A, size)+1);
			list.add(size+1);
		}
	reverse(A, findnum(A, size));
	reverse(A, size--);
	}
	return list;
}
//翻转索引为k之前的数
public static void reverse(int[] A,int k) {
	for (int i = 0; i < k; i++) {
		int tmp = A[i];
		A[i] = A[k-1-i];
		A[k-1-i]=tmp;
	}
}
//找到索引内的最大值的位置
public static int findnum(int[] A,int size) {
	int max = 0,k=0;
	for (int i = 0; i < size; i++) {
		if (max<A[i]) {
			max = A[i];
			k=i;
		}
	}
	return k;
}
	
/*
 * 970. 强整数
 */
public List<Integer> powerfulIntegers(int x, int y, int bound) {
	List<Integer> res = new ArrayList<>();   
    for(int i = 1; i < bound; i=i*x) {
        for(int j = 1; i+j <= bound ; j=j*y) {
        	if (!res.contains(i+j)) {
        		res.add(i+j);
        		if (y==1) break;
        }
        	if (x==1) break;
        }
    }
    return res;        
  }	
/*
 * 973. 最接近原点的 K 个点
 */
public int[][] kClosest(int[][] points, int K) {
	int[] len = new int[points.length];
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < len.length; i++) {
		len[i]= points[i][0]*points[i][0]+points[i][1]*points[i][1];
		map.put(i, len[i]);
	}
	List<Integer> list = new ArrayList<>();
	for (int key:map.keySet()) {
		list.add(map.get(key));
	}
	Collections.sort(list);
	int[][] res = new int[K][2];
	for (int i = 0; i <K; i++) {
		for (Entry<Integer, Integer> item:map.entrySet()) {
			if (item.getValue()==list.get(i)) {
				res[i][0]=points[item.getKey()][0];
				res[i][1]=points[item.getKey()][1];
				map.remove(item.getKey());
				break;
			}
		}
	}	
	return res;   
}
	/*
	 * 976.三角形的最大周长  
	 */
	public int largestPerimeter(int[] A) {
		if (A.length<3) {
			return 0;
		}
		Arrays.sort(A);	
		int len1,len2,len3;
		for (int i = A.length-1; i >=2; i--) {
			len1=A[i-2];
			len2=A[i-1];
			len3=A[i];
			if (len3<len1+len2) {
				return len1+len2+len3;
			}
		}
		return 0;    
	}
	/*
	 * 977.有序数组的平方
	 */
	public int[] sortedSquares(int[] A) {
	    int[] res = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
			res[i] = A[i]*A[i];
		}
	    Arrays.sort(res);    
	    return res;
	}
	/*
	 * 985. 查询后的偶数和
	 */
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] res = new int[queries.length];
		int sum=0;
		//先计算刚开始时所有的偶数之和
		for (int i = 0; i <A.length; i++) {
			if (A[i]%2==0) {
				sum+=A[i];
			}		
		}	
		for (int i = 0; i < queries.length; i++) {
			int val = queries[i][0];
			int index = queries[i][1];	
			//如果查询数为偶数，就先减掉
			if (A[index]%2==0) {
				sum-=A[index];
			}
			A[index]+=val;
			//如果处理后的偶数还是偶数，就再加上
			if (A[index]%2==0) {
				sum+=A[index];
			}
			res[i]=sum;
		}	
		return res;    
	}	
/*
 * 989. 数组形式的整数加法
 */
public static List<Integer> addToArrayForm(int[] A, int K) {
	List<Integer> list = new ArrayList<>();
	String kString = String.valueOf(K);
	int i=A.length-1,j=kString.length()-1;
	int bit2=0,bit1=0;
	while (i>=0||j>=0) {
	if (i>=0&&j>=0) {
		bit1=(bit2+A[i]+(kString.charAt(j)-'0'))%10;
		list.add(bit1);
		bit2=(bit2+A[i]+(kString.charAt(j)-'0'))/10;
	}else if (i>=0) {
		bit1=(bit2+A[i])%10;
		list.add(bit1);
		bit2=(bit2+A[i])/10;
	}else if (j>=0) {
		bit1=(bit2+(kString.charAt(j)-'0'))%10;
		list.add(bit1);
		bit2=(bit2+(kString.charAt(j)-'0'))/10;
	}		
		i--;
		j--;		
	}
	if (bit2!=0) {
		list.add(bit2);
	}
	Collections.reverse(list);
	for (int k:list) {
		System.out.print(k+",");
	}
	return list;	    
}
/*
 * 993. 二叉树的堂兄弟节点
 */
Map<Integer, Integer> depth;
Map<Integer, TreeNode> parent;

public boolean isCousins(TreeNode root, int x, int y) {
    depth = new HashMap();
    parent = new HashMap();
    dfs(root, null);
    return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
}

public void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
        depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
        parent.put(node.val, par);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}

/*
 * 994. 腐烂的橘子
 */
 public int orangesRotting(int[][] grid) {
        int key = 1;
        int i;//i表示腐烂的时间，从2开始是为了和不腐烂橘子区分，方便判断
    for (i = 2; key == 1; i++) {
        key = 0;
        for (int j = 0; j < grid.length; j++) {
            for(int k = 0; k < grid[j].length; k++)
            {//如果腐烂的橘子正好等于腐烂的时间
                if(grid[j][k] == i)
                {
                    //就将它四周有非腐烂的橘子设置成腐烂的橘子，将其变为下次腐烂时间方便遍历
                    if(j + 1 < grid.length && grid[j + 1][k] == 1)
                    {
                        grid[j + 1][k] = i + 1;
                        key = 1;
                    }

                    if(k + 1 < grid[0].length && grid[j][k + 1] == 1)
                    {
                        grid[j][k + 1] = i + 1;
                        key = 1;
                    }

                    if(k - 1 >= 0 && grid[j][k - 1] == 1)
                    {
                        grid[j][k -1] = i + 1;
                        key = 1;
                    }

                    if(j - 1 >= 0 && grid[j - 1][k] == 1)
                    {
                        grid[j - 1][k] = i + 1;
                        key = 1;
                    }
                }
            }
        }
    }
    for (int j = 0; j < grid.length; j++) {
        for (int k = 0; k < grid[0].length; k++) {
            //如果有新鲜橘子，就返回-1
            if(grid[j][k] == 1)
            {
                return  -1;
            }
        }
    }
    //由于一开始i是从2开始的,所以最终要还原回去
    return i - 3;
}


	/*
	 * 997. 找到小镇的法官  
	 * @param N
	 * @param trust
	 * @return
	 */
	public static int findJudge(int N, int[][] trust) {
		int[][] k = new int[N][2];
		for (int i = 0; i < trust.length; i++) {
			k[trust[i][0] - 1][0]++;
			k[trust[i][1] - 1][1]++;
			
		}
		for (int j = 0; j < k.length; j++) {
			if (k[j][1] == N - 1&&k[j][0]==0) {
				return j + 1;
			}
		}
		return -1;
	}
/*
 * 999. 车的可用捕获量
 */
public int numRookCaptures(char[][] board) {
	int pigi=0,pigj=0,count=0;
	//先定位车的位置
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
		if (board[i][j]=='R') {
			pigi=i;
			pigj=j;
			break;
			}	
		}	
	}
	//向左移动
	for (int i=pigi-1;i>=0;i--) {
		//遇到白象,跳出循环
		if (board[i][pigj]=='B') {
			break;
		}
		//遇到黑卒，计数加1，跳出循环
		if (board[i][pigj]=='p') {
			count++;
			break;
		}
	}
	//向右移动
		for (int i=pigi+1;i<8;i++) {
			//遇到白象,跳出循环
			if (board[i][pigj]=='B') {
				break;
			}
			//遇到黑卒，计数加1，跳出循环
			if (board[i][pigj]=='p') {
				count++;
				break;
			}
		}
		//向下移动
		for (int j=pigj+1;j<8;j++) {
			//遇到白象,跳出循环
			if (board[pigi][j]=='B') {
				break;
			}
			//遇到黑卒，计数加1，跳出循环
			if (board[pigi][j]=='p') {
				count++;
				break;
			}
		}
		//向下移动
		for (int j=pigj-1;j>=0;j--) {
			//遇到白象,跳出循环
			if (board[pigi][j]=='B') {
				break;
			}
			//遇到黑卒，计数加1，跳出循环
			if (board[pigi][j]=='p') {
				count++;
				break;
			}
		}		
	return count;        
    }
public static void main(String[] args) {
	int[] A= {3,2,4,1};
	pancakeSort(A);
}
}
