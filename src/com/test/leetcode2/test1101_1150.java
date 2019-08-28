package com.test.leetcode2;

public class test1101_1150 {

	/**
	 * 1103. 分糖果 II
	 * @param candies
	 * @param num_people
	 * @return
	 */
	public static int[] distributeCandies(int candies, int num_people) {
		int[] nums = new int[num_people];
		int j=1;
		while (candies>0) {
			for (int i = 0; i < nums.length&&candies>0; i++) {
				
				if (candies>j) {
					nums[i]+=j;
				}else {
					nums[i]+=candies;
				}
				//System.out.println(nums[i]);
				candies = candies-j;
				j++;
			}		
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		return nums;   
	}
	/**
	 * 1137. 第 N 个泰波那契数
	 * @param n
	 * @return
	 */
	public int tribonacci(int n) {
		if (n==0) {
			return 0;
		}
		if (n==1||n==2) {
			return 1;
		}

		return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
	    
	}

}
