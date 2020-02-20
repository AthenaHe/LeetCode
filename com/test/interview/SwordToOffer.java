package com.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class SwordToOffer {
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
 * 面试题18. 删除链表的节点
 */
public ListNode deleteNode(ListNode head, int val) {	
	if(head==null) {
		return null;
	}
	if(head.val == val) { //如果是删除第一个结点
		head = head.next;
		return head;
	}
	ListNode p = head;
	while (p.next!=null) {
		if (p.next.val==val) {
			p.next = p.next.next;
		}else {
			p = p.next;
		}		
	}
	return head;   
}
//面试题22. 链表中倒数第k个节点 LCOF
public ListNode getKthFromEnd(ListNode head, int k) {
	ListNode p = head;
	ListNode q = head;
	while(k>0) {
		q=q.next;
		k--;
	}
	while (q!=null) {
		p = p.next;
		q=q.next;		
	}
	return p;    
}
/*
 * 面试题24. 反转链表 LCOF
 */
public ListNode reverseList(ListNode head) {
	while(head==null||head.next==null) {
		return head;
	}
	Stack<ListNode> stack = new Stack<>();
	
	ListNode p = head;
	while(p!=null) {
		stack.push(p);
		p=p.next;
	}
	ListNode node = stack.pop();
	ListNode q = node;
	while(!stack.isEmpty()) {
		ListNode tmpnode = stack.pop();
		q.next = tmpnode;
		q = q.next;
	}
	q.next = null;
	return node;
    
}
/*
 * 面试题27. 二叉树的镜像
 */
public TreeNode mirrorTree(TreeNode root) {
   if (root==null) return null;
   TreeNode leftnode = mirrorTree(root.right);
   TreeNode rightnode = mirrorTree(root.left);
   root.left = leftnode;
   root.right = rightnode;
   return root;
}

/*
 * 面试题28. 对称的二叉树
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

/*
 * 面试题32 - I. 从上到下打印二叉树
 */
public int[] levelOrder1(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root==null)  return new int[0];
    queue.offer(root);
    while(!queue.isEmpty()) {
    	TreeNode node = queue.poll();
    	list.add(node.val);
    	if(node.left!=null) queue.offer(node.left);
    	if (node.right!=null) queue.offer(node.right);	
    }
    int[] res =new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
		res[i] = list.get(i);
	}
    return res;
}
/*
 * 面试题32 - III. 从上到下打印二叉树 III
 */
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> lists = new ArrayList<>();
	if (root==null) return lists;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	int depth=0;
	while(!queue.isEmpty()) {
		int count = queue.size();		
		depth++;
		List<Integer> list = new LinkedList<>();
		while(count>0) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if(node.left!=null) queue.offer(node.left);
			if(node.right!=null) queue.offer(node.right);
			count--;
		}
		if (depth%2==0) {
			Collections.reverse(list);
		}
		lists.add(list);
	}
	return lists;
    
}
//面试题32 - II. 从上到下打印二叉树 II
public List<List<Integer>> levelOrder2(TreeNode root) {
	List<List<Integer>> lists = new LinkedList<>();
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while(!queue.isEmpty()) {
		int count = queue.size();
		TreeNode node = queue.poll();
		List<Integer> list = new LinkedList<>();
		while(count>0) {
			list.add(node.val);
			if(node.left!=null) queue.offer(node.left);
			if(node.right!=null) queue.offer(node.right);
			count--;
		}
		lists.add(list);
	}
	return lists;  
}

/*
 * 面试题49. 丑数
 */
public int nthUglyNumber(int n) {
	int[] ugly=new int[n];
	int i=1,p2=0,p3=0,p5=0;
	ugly[0]=1;
	while (i<n) {
		ugly[i]=Math.min(Math.min(2*ugly[p2], 3*ugly[p3]), 5*ugly[p5]);
		if (ugly[i]>=2*ugly[p2]) p2++;
		if (ugly[i]>=3*ugly[p3]) p3++;
		if (ugly[i]>=5*ugly[p5]) p5++;
		i++;
	}
	return ugly[n-1];      
    }
/*
 * 面试题52. 两个链表的第一个公共节点  LCOF
 */
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//    //求两个链表的长度lenA,lenB
//	ListNode p = headA,q = headB;
//	int lenA=0,lenB=0;
//	while(p!=null) {
//		lenA++;
//		p=p.next;		
//	}
//	while (q!=null) {
//		lenB++;
//		q=q.next;		
//	}	
//	int len = lenA-lenB;
//	p = null;q=null;
//	 p = headA;q = headB;
//	//长的链表结点的指针先走|lenA-lenB|步
//	 while(len>0) {
//		p = p.next;
//		len--;
//	 }
//	while (len<0) {
//		q=q.next;
//		len++;
//	}
//	//两个指针所指结点进行比较，不相同就走到下一个，反之，返回该结点
//	while (p!=null&&q!=null) {
//		if (p==q) {
//			return p;
//		}
//		p = p.next;
//		q = q.next;
//	}
//	return null;
	
//设交集链表长c,链表1除交集的长度为a，链表2除交集的长度为b，有a + c + b = b + c + a,若无交集，则a + b = b + a
	if (headA == null || headB == null)
        return null;
    
    ListNode h1 = headA, h2 = headB;
    while (h1 != h2) {

        h1 = h1 == null ? headB : h1.next;
        h2 = h2 == null ? headA : h2.next;
    }
    return h1;  
}
/*
 * 面试题54. 二叉搜索树的第k大节点
 */
public int kthLargest(TreeNode root, int k) {
	Stack<TreeNode> stack = new Stack<>();
	TreeNode tnode = root;
	while(tnode!=null||!stack.isEmpty()) {
		if (tnode!=null) {
			stack.push(tnode);
			tnode=tnode.right;
		}else {
			tnode=stack.pop();
			k--;
			if (k==0) {
				return tnode.val;
			}
			tnode=tnode.left;
		}
	}
	return -1;  
}
/*
 * 面试题55 - I. 二叉树的深度
 */
public int maxDepth(TreeNode root) {
    if (root==null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
}
/*
 * 面试题55 - II. 平衡二叉树
 */
public boolean isBalanced(TreeNode root) {
	if(root==null) return true;
	if (Math.abs(depth(root.left)-depth(root.right))<=1) {
		 return isBalanced(root.left)&isBalanced(root.right);
	} 
	return false;
}
public int depth(TreeNode node) {
	if (node==null) return 0;
    return Math.max(depth(node.left), depth(node.right))+1;
}


/*
 * 面试题56 - I. 数组中数字出现的次数
 */
public int[] singleNumbers(int[] nums) {
	Arrays.sort(nums);
	int[] res = new int[2];
	int i=0,k=0;
	while (i<nums.length-1&&k<2) {
		if (nums[i]==nums[i+1]) {
			i+=1;
		}else {
			res[k++]=nums[i];
		}
		i++;		
	}
	if (k<2) {
		res[1]=nums[nums.length-1];
	}
	return res;       
    }

/*
 * 面试题56 - II. 数组中数字出现的次数 II
 */
public int singleNumber(int[] nums) {
	Arrays.sort(nums);
	int i=0;
		while(i<nums.length-2) {
		if (nums[i]==nums[i+1]&&nums[i]==nums[i+2]) {
			i+=2;
		}else {
			return nums[i];
		}
			i++;		
	}
	return nums[nums.length-1];       
    }	
/*
 * 面试题64. 求1+2+…+n
 */

public int sumNums(int n) {
	return (1+n)*n/2;        
  }
/*
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 */
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//	Stack<TreeNode> stack1=new Stack<>();
//	Stack<TreeNode> stack2=new Stack<>();
//	TreeNode node1=root;
//	TreeNode node2=root;
//	int depth1=1,depth2=1;
//	while(node1.val!=p.val) {
//		if (node1.val>p.val) {
//			stack1.push(node1);
//			depth1++;
//			node1 = node1.left;
//		}else if (node1.val<p.val) {
//			stack1.push(node1);
//			node1 = node1.right;
//			depth1++;
//		}
//	}
//	stack1.push(node1);
//	while (node2.val!=q.val) {
//		if (node2.val>q.val) {
//			stack2.push(node2);
//			depth2++;
//			node2 = node2.left;
//		}else if (node2.val<q.val) {
//			stack2.push(node2);
//			depth2++;
//			node2 = node2.right;
//		}		
//	}
//	stack2.push(node2);
////	System.out.println(stack1.size()+","+stack2.size());
////	while (!stack1.isEmpty()) {
////		System.out.println(stack1.pop().val);		
////	}
////	while (!stack2.isEmpty()) {
////		System.out.println(stack2.pop().val);		
////	}
//	while(depth1>depth2) {
//		stack1.pop();
//		depth1--;
//	}
//	while (depth1<depth2) {
//		stack2.pop();
//		depth2--;
//	}
//	while (depth1==depth2) {
//		if (stack1.peek()!=stack2.peek()) {
//			stack1.pop();stack2.pop();
//		}else {
//			return stack1.pop();
//		}
//		
//	}
//	return root; 
	if(root.val > p.val && root.val > q.val)
	return lowestCommonAncestor(root.left, p, q);
	if(root.val < p.val && root.val < q.val)
	return lowestCommonAncestor(root.right, p, q);
	return root;
}
/*
 * 面试题68 - II. 二叉树的最近公共祖先
 */
public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null || root==p || root==q)
        return root;
    
    TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
    TreeNode rightNode=lowestCommonAncestor(root.right,p,q);

    if(leftNode==null)
        return rightNode;
    if(rightNode==null)
        return leftNode;

    return root;
}


public static void main(String[] args){
    int i=0;
    i++;
    System.out.println(i);
}



}
