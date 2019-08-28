package com.test.leetcode1;

import java.util.ArrayList;
import java.util.List;

import com.test.leetcode1.test051_100.ListNode;
import com.test.leetcode1.test051_100.TreeNode;

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
		 /**
		  * 118.杨辉三角 list.get(i-2)没懂
		  * @param args
		  */

		 public static List<List<Integer>> generate(int numRows) {
		 	List<List<Integer>> list = new ArrayList<>(numRows);	
		 	for (int i = 1; i <= numRows; i++) {	
		 		List<Integer> nums = new ArrayList<>(i);
		 		for (int j = 0; j < i; j++) {
		 			if (j==0||j==i-1) {
		 				nums.add(1);
		 			}else {
		 				nums.add((list.get(i-2).get(j-1)+list.get(i-2).get(j)));
		 			}
		 		}
		 		list.add(nums);	
		 	}
		 	return list;
		     
		 }
		 /**
		  * 119.杨辉三角||  XXXXX
		  * @param args
		  */

		 public List<Integer> getRow(int rowIndex) {
		 	List<List<Integer>> list = new ArrayList<>(rowIndex);	
		 	for (int i = 1; i <= rowIndex; i++) {	
		 		List<Integer> nums = new ArrayList<>(i);
		 		for (int j = 0; j < i; j++) {
		 			if (j==0||j==i-1) {
		 				nums.add(1);
		 			}else {
		 				nums.add((list.get(i-2).get(j-1)+list.get(i-2).get(j)));
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
		 

}
