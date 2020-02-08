package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class test201_250 {
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
/*
 * 202. 快乐数	  
 */
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		set.add(n);
		while (n!=1) { 
	    String numString=String.valueOf(n);
	    n=0;
	    for (int i = 0; i < numString.length(); i++) {
	        n+=Math.pow(Integer.parseInt(numString.substring(i, i+1)),2);
	    }
	    if (set.contains(n)) {
	        return false;
	    }else {
	        set.add(n);
	    }						
	}
	return true;      
    }
	  /**
	   * 	203. 移除链表元素
	   * @param head 指向首结点
	   * @param val
	   * @return
	   */
	  public ListNode removeElements(ListNode head, int val) {
	  	 ListNode header = new ListNode(-1);
	       header.next = head;    
//	       //虚拟头结点
//	       ListNode dummy = new ListNode(0);
//	       dummy.next = head;
	       //当前需要移动的元素的前驱
	       ListNode pre = head;     
	       while(pre != null && pre.next != null) {
	           //当前要插入到头部的元素
	           ListNode curr = pre.next;
	           //将当前元素的前驱指针指向后继
	           pre.next = pre.next.next;
	           //当前元素的next指针指向头部
	           curr.next = header.next;
	           //修正虚拟头部指针指向
	           header.next = curr;
	       }
	    
	       return header.next;
	   }

	  /**
	   * 204. 计数质数
	   * @param n
	   * @return
	   */
	  public  static int countPrimes(int n) {
	  	
//	  	int count=0;
//	  	int no=0;
//	  	if (n==0||n==1) {
//	  		return 0;
//	  	}
	  //	
//	  	for (int i = 1; i < n; i++) {
//	  		for (int j = 2; j < i; j++) {
//	  			if (i%j==0) {
//	  				no+=1;
//	  				System.out.println(i);
//	  				break;
//	  			}
//	  		}
//	  	}
//	  	count = n-no-2;	
//	  	return count;
	  	
	  	boolean [] notPrim = new boolean[n];
	      int count = 0;
	      for (int i = 2; i < n; i++){
	          if (notPrim[i] == false) {
	              count++;
	              for (int j = 2; j*i < n; j++) {
	                  notPrim[j*i] = true;
	              }
	          }
	      }
	      return count;
	  }
/*
 * 205. 同构字符串	
 */
  public boolean isIsomorphic(String s, String t) {
	if (s.length()!=t.length()) {
		return false;
	}
	 HashMap<Character, Character> map = new HashMap<>();
	 for (int i = 0; i < s.length(); i++) {
		if (map.containsKey(s.charAt(i))) {
			if (map.get(s.charAt(i))!=t.charAt(i)) {
				return false;
			}
		}else {
			if (map.containsValue(t.charAt(i))) {
				return false;
			}
			map.put(s.charAt(i), t.charAt(i));
		}
	}
	 return true;
    }
	/**
	 * 206. 反转链表
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		ListNode header = new ListNode(-1);
	    header.next = head; 
	    ListNode listNode = header;
	    while(listNode.next!=null) {
	    	listNode.next=head;
			header.next =listNode;
			listNode = listNode.next;
			
		}
	    
		
		return header.next;
	    
	}
	
	
	/**
	 * 217. 存在重复元素
	 */
	public boolean containsDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]==nums[j]) {
					return true;
				}
			}
		}
		
		return false;
	    
	}

	/**
	 * 219. 存在重复元素 II
	 * @param args
	 */
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
	if (nums.length<k) {
		k=nums.length;
	}
		for (int i = 0; i < nums.length-k; i++) {
			for (int j = i+1; j < i+k+1; j++) {
				if (nums[i]==nums[j]) {
					return true;
				}
			}
		}
		for (int i = nums.length-k; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]==nums[j]) {
					return true;
				}
			}
		}
		
		
		return false;  
	}


	/**
	 * 225. 用队列实现栈
	 * @author hehuan
	 *
	 */
	class MyStack {

		Queue<Integer> queuein;
		Queue<Integer> queueout;
	    /** Initialize your data structure here. */
	    public MyStack() {
	        queuein = new LinkedList<>();
	        queueout = new LinkedList<>();
	        
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queuein.add(x);
	        while (!queueout.isEmpty()) {
				queuein.add(queueout.poll());		
			}
	        Queue tmp = queuein;
			queuein = queueout;
			queueout = tmp;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	    	return queueout.poll();
	        
	    }
	    
	    /** Get the top element. */
	    public int top() {
			return queueout.peek();
	        
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
			return queuein.isEmpty()&&queueout.isEmpty();
	        
	    }
	}
	/**
	 * 226. 翻转二叉树
	 * @param args
	 */
	public TreeNode invertTree(TreeNode root) {
		 if (root == null) return null;
		 //交换左右子数
	     TreeNode tmp = root.right;
	     root.right = invertTree(root.left);
	     root.left = invertTree(tmp);	
		return root;
	    
	}

	/**
	 * 231. 2的幂
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n) {
		if (n==1) {
			return true;
		}
		if (n<=0) {
			return false;
		}
		
		while (n%2==0) {
			n=n/2;		
		}			
		
		return n>1?false:true;
	    
	}

	/**
	 * 232. 用栈实现队列
	 * @author hehuan
	 *
	 */
	class MyQueue {
			Stack<Integer> stack1; 
	        Stack<Integer> stack2; 
	    /** Initialize your data structure here. */
	    public MyQueue() {
	    	stack1 = new Stack<>();
	    	stack2 = new Stack<>();
	        
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {        
	        stack1.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    	if (stack2.isEmpty()) {		
	    	while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());			
			}
	    }    	
			return stack2.pop();
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	if (stack2.isEmpty()) {		
	    	while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());			
			} 
	    }   	
			return stack2.lastElement();
	        
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
			return stack1.isEmpty()&&stack2.isEmpty();
	        
	    }
	}
	
/*
 * 234. 回文链表
 */
 public boolean isPalindrome(ListNode head) {
	 List<Integer> list=new ArrayList<>();
	 if (head==null) {
		return true;
	}
	 while (head!=null) {
		list.add(head.val);
		head=head.next;		
	}	 
	 for (int i = 0,j=list.size()-1; i <=list.size()/2&&j>=list.size()/2; i++,j--) {
		if (list.get(i).equals(list.get(j))) {
		return false;
		}
	}
	return true;      
    }
 /*
  * 235. 二叉搜索树的最近公共祖先
  */
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	 if (p.val==root.val){
         return p;
     } 
     if (q.val==root.val){
         return q;
     }
     if (p.val > root.val && q.val > root.val) {
         return lowestCommonAncestor(root.right,p,q);
     }else if (p.val < root.val && q.val < root.val) {
         return lowestCommonAncestor(root.left,p,q);
     }else{
         return root;
     }   
 }
	/**
	 * 237. 删除链表中的节点
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val; 
		node.next = node.next.next; 
	}
/*
 * 238. 除自身以外数组的乘积
 */
public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] L = new int[length];
    int[] R = new int[length];
    int[] answer = new int[length];
    L[0] = 1;  //第一个数的左边没有数，所以左边积为1
    for (int i = 1; i < length; i++) { //	把数的左边积存在一个数组中
        L[i] = nums[i - 1] * L[i - 1];
    }
    R[length - 1] = 1; //最后一个数的右边没有数，所以右边积为1
    for (int i = length - 2; i >= 0; i--) { //把数的右边积存在一个数组中
        R[i] = nums[i + 1] * R[i + 1];
    }
    for (int i = 0; i < length; i++) { //除自身以外数组的乘积就是该数的左边积*右边积
        answer[i] = L[i] * R[i];
    }
    return answer;
}
	/**
	 * 242. 有效的字母异位词
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		
		char[] sChars = s.toCharArray();
	    char[] tChars = t.toCharArray();
	    Arrays.sort(sChars);
	    Arrays.sort(tChars);
	    return String.valueOf(sChars).equals(String.valueOf(tChars));
	    
	}

	public static void main(String[] args) {

	}

}
