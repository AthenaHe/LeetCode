package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class test551_600 {
public class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	/*
	 * 551. 学生出勤记录 I
	 */
	public boolean checkRecord(String s) {
		String LL="LL";
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='A') {
				count++;
			}
		}	
		System.out.println(s.contains(LL));
		if (count<2&&!s.contains(LL)) {
			return true;
		}
		return false;	    
	}

	/*
	 * 557. 反转字符串中的单词 III
	 */
	public static String reversek(String ss) {
		String r="";
		for (int i = ss.length(); i >0; i--) {
			r+=ss.substring(i-1, i);		
		}
		//System.out.println(result);
		return r;	
	}
public String reverseWords(String s) {
	String[] words = s.split(" ");
	s="";
	for (int i = 0; i < words.length; i++) {
		s+=reversek(words[i])+" ";
	}
	return s.substring(0, s.length()-1);        
    }

/*
 * 559. N叉树的最大深度
 */
public int maxDepth(Node root) {
	if (root==null) {
		return 0;
	}
	int depth=0;
	for (int i = 0; i < root.children.size(); i++) {
		depth = Math.max(maxDepth(root.children.get(i)), depth);
	}
	return depth+1;
    
}
/*
 * 561. 数组拆分 I
 */
public static int arrayPairSum(int[] nums) {
	Arrays.sort(nums);
	int minsum = 0;
	for (int i = 0; i < nums.length; i=i+2) {
		minsum +=nums[i];
	}	
	return minsum;
    
}
/*
 * 563. 二叉树的坡度
 */
public int findTilt(TreeNode root) {
	  if(root == null) return 0;
      return Math.abs(getSum(root.left)-getSum(root.right))+findTilt(root.left)+findTilt(root.right);
  }
	
	public int getSum(TreeNode root) {
		if(root == null) return 0;
		return root.val+getSum(root.left)+getSum(root.right);
	}
/*
 * 566. 重塑矩阵
 */
public int[][] matrixReshape(int[][] nums, int r, int c) {
	int row = nums.length;//行数
	int col = nums[0].length;//列数
	int[][] newnums = new int[r][c];
	List<Integer> list = new ArrayList<>();
	for (int i = 0; i < nums.length; i++) {
		for (int j = 0; j < nums[i].length; j++) {
			list.add(nums[i][j]);
		}
	}
	if (row*col==r*c) {
		int k=0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newnums[i][j]=list.get(k);
				k++;
			}
		}
	return newnums;
	}
	return nums;       
    }
/*
 * 575.分糖果
 */
public static int distributeCandies(int[] candies) {
   Map<Integer, Integer> map = new HashMap<Integer, Integer>();
   for (int i = 0; i < candies.length; i++) {
	map.put(candies[i], map.getOrDefault(candies[i],0)+1);
}   
   if (candies.length/2>map.size()) {
	return map.size();
}
   return candies.length/2;
}
/*
 * 581. 最短无序连续子数组
 */
public static int findUnsortedSubarray(int[] nums) {
int[] newnums = new int[nums.length];
for (int i = 0; i < nums.length; i++) {
	newnums[i]=nums[i];
}
	Arrays.sort(newnums);
	int count=newnums.length;
	System.out.println(count);
	for (int i = 0; i < newnums.length; i++) {
		if (nums[i]==newnums[i]) {
			count--;
		}else {
			break;
		}	
	}
	System.out.println(count);
	for (int i = nums.length-1; i >= 0; i--) {
		if (nums[i]==newnums[i]) {
			count--;
		}else {
			break;
		}
	}
	
	return count;
}
/*
 * 589. N叉树的前序遍历
 */
public List<Integer> preorder(Node root) {
List<Integer> list = new ArrayList<>();
	Stack<Node> stack = new Stack<>();
	if (root==null) {
		return list;
	}
	stack.push(root);
	while (!stack.isEmpty()) {
		Node node = stack.pop();
		list.add(node.val);
		for (int i = node.children.size()-1; i >=0; i--) {
			stack.add(node.children.get(i));
		}
		
	}	
	return list;	
}	
 /*
  * 590. N叉树的后序遍历
  */
public List<Integer> postorder(Node root) {
    List<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    if (root==null) {
		return list;
	}
    stack.push(root);
    while (!stack.isEmpty()) {
    	Node node = stack.pop();
		list.add(node.val);
		for (int i = 0; i < node.children.size(); i++) {
			stack.push((node.children.get(i)));
		}	
	}
    Collections.reverse(list);
//	List<Integer> list = new ArrayList<>();
//	if (root==null) {
//		return list;
//	}
//	for (int i =0; i <root.children.size(); i++) {
//		list.addAll(postorder(root.children.get(i)));
//	}
//	list.add(root.val);
	
    return list;
}
/*
 * 594. 最长和谐子序列
 */
public static int findLHS(int[] nums) {
	 Arrays.sort(nums);
	
     int j = 0,res = 0;
     int i=0;
     while (i<nums.length) {
    	// System.out.println(nums[i]+","+nums[j]);
     while (nums[i]-nums[j]>1) {
		j++;		
	}
     if (nums[i]-nums[j]==1) {
		res = Math.max(res, i-j+1);
	}
     i++;
     }
     return res;   
}
/*  SQL
 * 595.大的国家    	   
 */

/*SQL
 * 596.超过5名学生的课 
 */

/*
 * 598. 范围求和 II
 */
public static int  maxCount(int m, int n, int[][] ops) {
	//每次操作都是左上角区域从（0, 0）到（a, b）的矩形，必定重叠，所以找最小的a乘最小的b就行
	int num1 = m, num2 = n;
    for(int i = 0; i < ops.length; i++){
        num1 = Math.min(num1, ops[i][0]);
        num2 = Math.min(num2, ops[i][1]);
    }
    return num1 * num2;   
}


	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1};
		
		

	}

}