package com.test.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class SwordToOffer {
//树结点定义
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
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
 * 面试题55 - I. 二叉树的深度
 */
public int maxDepth(TreeNode root) {
    if (root==null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
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



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	}

}
