package com.test.leetcode1;

import java.util.Arrays;

import com.test.leetcode1.test001_050.TreeNode;

public class test951_1000 {
//树结点定义
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
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

}
