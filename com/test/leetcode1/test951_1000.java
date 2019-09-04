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
	 * 976.三角形的最大周长 
	 */
	public int largestPerimeter(int[] A) {
		if (A.length<3) {
			return 0;
		}
		Arrays.sort(A);	
		int len1,len2,len3;
		for (int i = A.length-1; i >=2; i--) {
			len1=A[i-2];
			len2=A[i-1];
			len3=A[i];
			if (len3<len1+len2) {
				return len1+len2+len3;
			}
		}
		return 0;    
	}
	/*
	 * 977.有序数组的平方
	 */
	public int[] sortedSquares(int[] A) {
	    int[] res = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
			res[i] = A[i]*A[i];
		}
	    Arrays.sort(res);    
	    return res;
	}
	/*
	 * 985. 查询后的偶数和
	 */
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] res = new int[queries.length];
		int sum=0;
		//先计算刚开始时所有的偶数之和
		for (int i = 0; i <A.length; i++) {
			if (A[i]%2==0) {
				sum+=A[i];
			}		
		}	
		for (int i = 0; i < queries.length; i++) {
			int val = queries[i][0];
			int index = queries[i][1];	
			//如果查询数为偶数，就先减掉
			if (A[index]%2==0) {
				sum-=A[index];
			}
			A[index]+=val;
			//如果处理后的偶数还是偶数，就再加上
			if (A[index]%2==0) {
				sum+=A[index];
			}
			res[i]=sum;
		}	
		return res;    
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
