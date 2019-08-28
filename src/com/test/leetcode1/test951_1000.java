package com.test.leetcode1;

public class test951_1000 {

	/**
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
