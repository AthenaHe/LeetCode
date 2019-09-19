package com.test.leetcode1;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;
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
	
		String[] ops={"15","2","C","D","+"};
		System.out.println(hasAlternatingBits(10));

	}

}
