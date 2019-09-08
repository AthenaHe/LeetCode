package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test101_150 {
	//链表结构体定义
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
	/**
	 * 101. 对称二叉树
	 * @param args
	 */
		public boolean isSymmetric(TreeNode root) {
			if (root == null) {
				return true;
			}
			return isMirror(root.left, root.right);
		}
		public boolean isMirror(TreeNode tleft, TreeNode tright) {
			if (tleft == null && tright == null) {
				return true;
			}
			if (tleft == null || tright == null||tleft.val != tright.val) {
				return false;
			}
			return isMirror(tleft.left, tright.right)&&isMirror(tleft.right, tright.left);
		}

	/**
	 * 104. 二叉树的最大深度
	 * @param args
	 */
		 public int maxDepth(TreeNode root) {
			 if (root==null) {
				return 0;
			}		
			 return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
		        
		    }
/*
 * 102. 二叉树的层次遍历
 */ 
 public List<List<Integer>> levelOrder(TreeNode root) {
	List< List<Integer>> results = new ArrayList<>();    
    if (root==null) {//如果二叉树为空，就返回空值
		return results;
	}   
     Queue<TreeNode> queue = new LinkedList<>();
     queue.add(root);//将根结点入队     
     while (!queue.isEmpty()) {
	 int count = queue.size();//计数队列中当前层次中的结点个数，方便加入list中进行记录
	 List<Integer> list = new ArrayList<>();
    	while (count>0) {	
		TreeNode node = queue.poll();//队头元素出列
		list.add(node.val);
		if (node.left!=null) {
			queue.add(node.left);			
		}
		if (node.right!=null) {
			queue.add(node.right);			
		}
		count--;
    }
    results.add(list);		
	}
    Collections.reverse(results);
    return results;     
 }
 
/*
 * 	107.二叉树的层次遍历 II  
 * (逆序输出) 
 */
 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	 List< List<Integer>> results = new ArrayList<>();    
	    if (root==null) {//如果二叉树为空，就返回空值
			return results;
		}   
	     Queue<TreeNode> queue = new LinkedList<>();
	     queue.add(root);//将根结点入队     
	     while (!queue.isEmpty()) {
		 int count = queue.size();//计数队列中当前层次中的结点个数，方便加入list中进行记录
		 List<Integer> list = new ArrayList<>();
	    	while (count>0) {	
			TreeNode node = queue.poll();//队头元素出列
			list.add(node.val);
			if (node.left!=null) {
				queue.add(node.left);			
			}
			if (node.right!=null) {
				queue.add(node.right);			
			}
			count--;
	    }
	    results.add(list);		
		}
	    return results;     
}
/*
 * 118. 杨辉三角 
 */
 public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = new ArrayList<>(numRows);	
	for (int i = 0; i < numRows; i++) {	
		List<Integer> nums = new ArrayList<>(i+1);
		for (int j = 0; j <= i; j++) {
			if (j==0||j==i) {
				nums.add(1);
			}else {
				nums.add((list.get(i-1).get(j-1)+list.get(i-1).get(j)));
			}
		}
		list.add(nums);	
	}
	return list;
  }
 
 /**
  * 119.杨辉三角|| 
  * @param args
  */

 public List<Integer> getRow(int rowIndex) {
 	List<List<Integer>> list = new ArrayList<>(rowIndex);	
 	for (int i = 0; i <= rowIndex; i++) {	
 		List<Integer> nums = new ArrayList<>(i+1);
 		for (int j = 0; j < i; j++) {
 			if (j==0||j==i) {
 				nums.add(1);
 			}else {
 				nums.add((list.get(i-1).get(j-1)+list.get(i-1).get(j)));
 			}
 		}
 		list.add(nums);	
 	}
 	return list.get(rowIndex); 
 }	 
		 /**
		  * 121. 买卖股票的最佳时机
		  * @param prices
		  * @return
		  */
		 public static int maxProfit(int[] prices) {
		 	int max=0;
		 	for (int i = 0; i < prices.length; i++) {
		 	for (int j = i+1; j < prices.length; j++) {		
		 		if (prices[i]<prices[j]) {
		 			 max= (prices[j]-prices[i])<max?max:(prices[j]-prices[i]);
		 		}
		 	}
		 	}	
		 	return max;   
		 }

		 /**
		  * 125. 验证回文串
		  * @param s
		  * @return
		  */
		 public static boolean isPalindrome(String s) {	
		 	String str = "";
		 	if (s==null||s.length()==0) {
		 		return true;
		 	}	
		 	s=s.toLowerCase();	
		 	for (int k = 0; k < s.length(); k++) {
		 		if (s.charAt(k)>='0'&&s.charAt(k)<='9'||s.charAt(k)>='a'&&s.charAt(k)<='z') {
		 		str+=s.charAt(k);
		 		}
		 	}
		 	int i=0,j=str.length()-1;
		 	while (i<j) {
		 		if (str.charAt(i)!=str.charAt(j)) {
		 			return false;
		 		}
		 		i++;
		 		j--;
		 		
		 	}	
		 	return true;
		     
		 }
		
	/**
	 * 	 136. 只出现一次的数字	 
	 */ 
		 public int singleNumber(int[] nums) {
			 int res = nums[0];
		        for (int i = 1; i < nums.length; i++) {
					res^=nums[i];
				}
		        return res;  
		    } 
/*
 * 	141. 环形链表 
 */
 public boolean hasCycle(ListNode head) {
	 //利用快慢指针，如果有环，总有一天会相遇
	 ListNode slow = head,fast = head;
	 while (fast!=null&&fast.next!=null) {
		 slow=slow.next;
		 fast=fast.next.next;
		 if (fast==slow) {
			return true;
		}
	}	 
	return false;       
    }
 
 
 
}
