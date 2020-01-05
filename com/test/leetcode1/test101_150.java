package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
 *  108. 将有序数组转换为二叉搜索树
 */
 public TreeNode sortedArrayToBST(int[] nums) {
     if(nums == null || nums.length == 0){
                return null;
           }
           return DFS(nums, 0, nums.length - 1);
    }
public TreeNode DFS(int[] nums, int left, int right){
   if(left > right){
       return null;
   }
   int mid = left + (right - left) / 2;
   TreeNode node = new TreeNode(nums[mid]);
   node.left = DFS(nums, left, mid - 1);
   node.right = DFS(nums, mid + 1, right); 
   return node;   
}
 /*
  * 110. 平衡二叉树
  */
 boolean flag=true;
 public boolean isBalanced(TreeNode root) {
	 postSearch(root);
     return flag;
 }
 public int postSearch(TreeNode root){
     if(root==null||!flag) return 0;
     int left=postSearch(root.left);
     int right=postSearch(root.right);
     if(Math.abs(left-right)>1) flag=false;
     return Math.max(left,right)+1;
}
 
 /*
  * 111. 二叉树的最小深度
  */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
 /*
  * 112. 路径总和
  */
 public boolean hasPathSum(TreeNode root, int sum) {
	 if (root==null) {
		return false;
	}
	 sum-=root.val;
	 //如果是叶子结点
	 if (root.left==null&&root.right==null) {
		 if (sum==0) {
			return true;
		}		
	}
	return hasPathSum(root.left, sum)||hasPathSum(root.right, sum);
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
/*
 *122. 买卖股票的最佳时机 II 
 */
 public static int maxProfit1(int[] prices) {
	 if (prices.length<2) {
			return 0;
	}	 
	 int buy=prices[0],sell=prices[prices.length-1];
	 int profit=0;
	if (prices[0]>prices[1]) {
		buy=0;
	}else{
        buy=prices[0];
    }
	 //数组就像一条折线，每次在最低点买入，最高点卖出
	 int i=1;
	 while(i<prices.length-1) {		 
		if (prices[i-1]>prices[i]&&prices[i]<=prices[i+1]) {
			buy=prices[i];
            System.out.println("buy:"+buy);
		}else if (prices[i-1]<=prices[i]&&prices[i]>prices[i+1]) {
			sell = prices[i];
             System.out.println("sell:"+sell);
			profit+=(sell-buy);
            System.out.println("profit:"+profit);
            buy=0;
		}
        i++;
	}
	 System.out.println("lastbuy:"+buy);
 	if (prices[prices.length-1]<prices[prices.length-2]) {
 		sell=0;
 	}else{
        sell=prices[prices.length-1];
     }
 	System.out.println("lastsell:"+sell);
	 	profit+=(sell-buy);
		return profit>0?profit:0;   
}   
		 
 /**
  * 125. 验证回文串
  * @param s
  * @return
  */
 public static boolean isPalindrome(String s) {	
	String aString = "";
 	if (s==null||s.length()==0) {
 		return true;
 	}	
 	s=s.toLowerCase();
 	for (int i = 0; i < s.length(); i++) {
 		if ((s.charAt(i)<='z'&&s.charAt(i)>='a')||s.charAt(i)<='9'&&s.charAt(i)>='0') {
 			aString+=s.charAt(i);
		}		
	} 	
 	String bString = new StringBuffer(aString).reverse().toString();
	return aString.equals(bString);	    
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
 
 public static void main(String[] args) {
	int[] prices = {2,9,2,3,8,1,5,8,4,3,6,4,4};
	maxProfit1(prices);
 }
 
}
