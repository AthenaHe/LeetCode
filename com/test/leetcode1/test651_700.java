package com.test.leetcode1;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class test651_700 {
	public class TreeNode {
	int val;
	TreeNode left; 
	TreeNode right;
	TreeNode(int x) { val = x; }
		 }
/*
 * 653. 两数之和 IV - 输入 BST	
 */
public boolean findTarget(TreeNode root, int k) {
	List<Integer> list = new ArrayList<>();
	traversal(root, list);
	int l=0,r=list.size()-1;
	while (l<r) {
		if ((list.get(l)+list.get(r))==k) {
			return true;
		}else if ((list.get(l)+list.get(r))>k) {
			r--;
		}else if ((list.get(l)+list.get(r))<k) {
			l++;
		}		
	}	
	return false;       
    }

//二叉搜索树中序遍历，左根右，放进list。升序排列
public void traversal(TreeNode node,List<Integer> list) {
	if (node!=null) {
		traversal(node.left, list);
		list.add(node.val);
		traversal(node.right, list);
	}
}
	/*
	 * 657. 机器人能否返回原点
	 */
	public boolean judgeCircle(String moves) {
		int[] point = new int[2];
		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i)=='R') {
			point[0]+=1;	
			}
			if (moves.charAt(i)=='L') {
				point[0]-=1;	
			}
			if (moves.charAt(i)=='U') {
				point[1]+=1;	
				}
			if (moves.charAt(i)=='D') {
					point[1]-=1;	
			}
		}
		if (point[0]==0&&point[1]==0) {
			return true;
		}
		return false;   
	}

	/*
	 * 661. 图片平滑器
	 */
	public static int[][] imageSmoother(int[][] M) {
		int[][] res = new int[M.length][M[0].length];
		System.out.println("行:"+M.length+",列:"+M[0].length);
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				int sum=M[i][j];
				int count=1;
				if ((i-1)>=0&&(j-1)>=0) {
				sum+=M[i-1][j-1];	
				count++;
				}
				if ((i-1)>=0&&j>=0) {
				sum+=M[i-1][j];	
				count++;
				}
				if ((i-1)>=0&&j+1<M[i].length) {
					sum+=M[i-1][j+1];	
					count++;
				}
				if (i>=0&&j-1>=0) {
					sum+=M[i][j-1];	
					count++;
				}
				if (i>=0&&j+1<M[i].length) {
					sum+=M[i][j+1];	
					count++;
				}
				
				if ((i+1)<M.length&&(j-1)>=0) {
					sum+=M[i+1][j-1];	
					count++;
					}
					if ((i+1)<M.length&&j>=0) {
					sum+=M[i+1][j];	
					count++;
					}
					if ((i+1)<M.length&&j+1<M[i].length) {
						sum+=M[i+1][j+1];	
						count++;
					}
				res[i][j]=sum/count;
			}
		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j]+",");
			}
			System.out.println();
		}
		return res;
	    
	}

	/*
	 * 665. 非递减数列
	 */
	public boolean checkPossibility(int[] nums) {
		int count=0;
		if (nums.length<3) {
			return true;
		}
		
		if (nums[0]>nums[1]) {
			count++;		
		}
		
		for (int i = 1; i < nums.length-1; i++) {
			if (nums[i]>nums[i+1]) {
				count++;
				if (count>=2) {
					return false;				
				}
			if (nums[i-1]>nums[i+1]) {			
				nums[i+1]=nums[i];
			}else {
				nums[i] = nums[i+1];
			}			
			}
		}	
		return count<=1?true:false;    
	}
/*
 * 669. 修剪二叉搜索树	
 * 递归难以理解
 */
public TreeNode trimBST(TreeNode root, int L, int R) {
	if (root==null) {
		return null;
	}
	root.left = trimBST(root.left, L, R);
	if (root.val<L) {
		return trimBST(root.right, L, R);
	}else if (root.val>R) {
		return trimBST(root.left, L, R);
	}
	root.right = trimBST(root.right, L, R);	
	return root;  
 }
/*
 * 671. 二叉树中第二小的节点
 */
public int findSecondMinimumValue(TreeNode root) {
	return mymin(root,root.val);
}
public int mymin(TreeNode root,int val) {
	if (root==null) {
		return -1;
	}
	//如果该节点的值大于根节点的值
	if (root.val>val) {
		return root.val;
	}
	//查看左子树上比根节点大的值
	int l=mymin(root.left, val);
	//查看右子树上比根节点大的值
	int r=mymin(root.right, val);
	//如果左右子节点的值比根节点都大，那就找左右子节点中较小的值
	if (l>val&&r>val) {
		return Math.min(l, r);
	}
	//如果左右子节点的值最多只有一个比根节点大，那就找左右子节点中较大的值，因为另一个值一定等于根节点值
	return Math.max(l, r);
}

/*
 * 674. 最长连续递增序列
 */
public int findLengthOfLCIS(int[] nums) {
	if (nums.length<2) {
		return nums.length;
	}
	int count=1;
	int max = 0;
	for (int i = 0; i < nums.length-1; i++) {
		if (nums[i]<nums[i+1]) {
			count++;
			max = Math.max(max, count);
		}else {						
			count=1;
		}
	}
	return max;        
    }
/*
 * 680.验证回文字符串 Ⅱ
 */
public boolean validPalindrome(String s) {
	int i=0,j=s.length()-1;
	while(i<j) {
		if (s.charAt(i)!=s.charAt(j)) {
			return isValid(s,i+1,j)||isValid(s,i,j+1);
		}
		i++;
		j--;
	}
	return true;   
}
//验证子串是否是回文串
public boolean isValid(String s,int i,int j) {
	while (i<j) {
		if (s.charAt(i)!=s.charAt(j)) {
			return false;
		}
		i++;j--;		
	}
	return true;
}
/*
 * 682. 棒球比赛
 */
public int calPoints(String[] ops) {
	List<Integer> list = new ArrayList<>();
	for (int i = 0; i < ops.length; i++) {
	switch (ops[i]) {
	case "+":
		list.add(list.get(list.size()-1)+list.get(list.size()-2));
		break;
	case "D":
		list.add(list.get(list.size()-1)*2);
		break;
	case "C":
		list.remove(list.size()-1);
		break;
	default:
		list.add(Integer.parseInt(ops[i]));
		break;
	}
	}
	int sum=0;
	for (int i = 0; i < list.size(); i++) {
		sum+=list.get(i);
	}
	return sum;   
}
/*
 * 686. 重复叠加字符串匹配 difficult
 */
public int repeatedStringMatch(String A, String B) {
    int i=0;
    String newA = "";
    for (int j = 0; j < A.length(); j++) {
		newA+=A.charAt(j);
	}
    //当A的长度比B大
    if (newA.length()>B.length()) {
		if (newA.contains(B)) {
			return 1;
		}else if ((newA+newA).contains(B)) {
			return 2;
		}	
	}else { 
	//当A的长度比B小
	while(i<=B.length()/A.length()+2) {
		newA+=A;
		i++;
		if (newA.contains(B)) {
			return i;
		}
	}	
}
	return -1;
  }

/*
 * 687. 最长同值路径 难
 */
private int maxL = 0;
public int longestUnivaluePath(TreeNode root) {
/**
    解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
    1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
    2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
    需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
    **/
    if(root == null) return 0;
    getMaxL(root, root.val);
    return maxL;
}

private int getMaxL(TreeNode r, int val) {
    if(r == null) return 0;
    int left = getMaxL(r.left, r.val);
    int right = getMaxL(r.right, r.val);
    maxL = Math.max(maxL, left+right); // 路径长度为节点数减1所以此处不加1
    if(r.val == val) // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
        return Math.max(left, right) + 1;
    return 0;        
}
/*
 * 690. 员工的重要性
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public int getImportance(List<Employee> employees, int id) {
	int imp = 0;
	for (Employee employee:employees) {
		if (employee.id==id) {
			imp+=employee.importance;		
			for (Integer suborEmployee :employee.subordinates) {
				getImportance(employees, suborEmployee);
				
			}
		}
		
	}

	return imp;
    
}

/*
 * 693. 交替位二进制数
 */
public static boolean hasAlternatingBits(int n) {
	int r1,r2=0;
	r1=n%2;
	while(n!=0) {		
		r2=r1;
		n=n/2;
		r1=n%2;
		if (r1==r2) {
			return false;
		}		
	}
	return true;   
}

/*
 * 696. 计数二进制子串
 */
public int countBinarySubstrings(String s) {
	int count1=1;
	int count2=0;
	boolean flag = true;
	for (int i = 0; i < s.length(); i++) {
		for (int j = i+1; j < s.length(); j++) {
			if (s.charAt(i)==s.charAt(j)&&flag) {
				count1++;
			}if (s.charAt(i)!=s.charAt(j)) {
				flag=false;
				count2++;
			}
		}
	}
	return 0;
    
}

/*
 * 696. 计数二进制子串
 */
public int countBinarySubstrings1(String s) {
	int last=0, cur=1, res=0; 
    for(int i=1; i<s.length(); i++){
        if(s.charAt(i) == s.charAt(i-1)) 
        	cur ++;
        else{
        	last = cur; cur = 1;
        	}
        if(last >= cur) 
        	res++;
    }
    return res;   
}
/*
 *697. 数组的度 
 */
public static int findShortestSubArray(int[] nums) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	//统计数组中每个元素出现的次数
	for (int i = 0; i < nums.length; i++) {
		map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
	}
	int max = 0;
	List<Integer> list = new ArrayList<>();
	//找到最大的度
	for(int key:map.keySet()) {
		System.out.println("key:"+key+",value:"+map.get(key));
		max = Math.max(max, map.get(key));
	}
	System.out.println(max);
	//找到最大的度对应的元素
	for (int key:map.keySet()) {
	if (map.get(key)==max) {
		list.add(key);
	}
}
	int len=Integer.MAX_VALUE;
	//找到最大度元素中最短的子数组长度
	for (int li:list) {
		System.out.println("li:"+li);
		
		int i=0,j=nums.length-1;
		while(i<=j) {
		if (nums[i]!=li) {
			i++;
		}
		if (nums[j]!=li) {
			j--;
		}
		if (nums[i]==li&&nums[j]==li) {
			System.out.println("i:"+i+",j:"+j);
			len = Math.min(len, j-i+1);
			break;
	}	
		}		
	}	
	System.out.println("len:"+len);
	return len;    
}
/*
 * 700. 二叉搜索树中的搜索
 */
public TreeNode searchBST(TreeNode root, int val) {
	if (root==null) {
		return null;
	}
	if (root.val<val) 
		searchBST(root.right, val);
	if (root.val>val) 
		searchBST(root.left, val);
	if (root.val==val) {
		return root;
	}
	return null;
    
}
	public static void main(String[] args) {
		int[] nums = {1,3,2,2,3,1};
		findShortestSubArray(nums);
	}

}
