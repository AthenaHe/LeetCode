package com.test.leetcode1;

import java.util.Arrays;

public class test151_200 {
	/**
	 * 167. 两数之和 II - 输入有序数组 xxxx
	 * @param numbers 超时了
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int[] index = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if ((numbers[i]+numbers[j])==target) {
					index[0]=i+1;
					index[1]=j+1;
				}
			}
		}
		
		return index;
	    
	}
	/**
	 * 	169. 求众数->出现次数大于数组元素长度的一半的数
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		if (nums[0] == nums[len / 2]) {
			return nums[0];
		} else if (nums[len-1] == nums[len / 2]) {
			return nums[len - 1];
		} else {
			return nums[len / 2];
		}
	}

	/**
	 * 189. 旋转数组
	 * @param nums
	 * @param k
	 */
public static void rotate(int[] nums, int k) {
	 int tmp;
     for (int i = 0; i<k ; i++) {
    	 tmp = nums[nums.length-1];
    	 for (int j = nums.length-1; j > 0; j--) {
			nums[j]=nums[j-1];
		}
    	 nums[0]=tmp;  	 
	} 
     for (int i = 0; i < nums.length; i++) {
		System.out.print(nums[i]+",");
	}    
    }

	/**
	 * 198. 打家劫舍
	 * @param nums
	 * @return
	 */
public  static int rob(int[] nums) {
	int n = nums.length;
    if (n <= 1) return n == 0 ? 0 : nums[0];
    int[] memo = new int[n];
    memo[0] = nums[0];
    memo[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++)
        memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
    return memo[n - 1];
}

}
