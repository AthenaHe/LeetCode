package com.test.leetcode1;

public class test251_300 {
	/**
	 * 258. 各位相加
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
//			int tmp;
//			while ((num / 10) != 0) {
//				tmp = num;
//				num = 0;
//				while (tmp != 0) {
//					num += tmp % 10;
//					tmp /= 10;
//				}
//			}
//			return num;
		if (num==0) {
			return 0;
		}
		    return num%9==0?9:num%9;		
		}

	/**
	 * 268. 缺失数字  有点不太懂
	 * @param nums
	 * @return
	 */
	public static  int missingNumber(int[] nums) {
		int res = nums.length;//为什么等于长度
		for (int i = 0; i < nums.length; i++) {
			res^=nums[i]^i;
		}
		return res;
	}
	/**
	 * 283. 移动零
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
//		int tmp;
//	    for (int i = 0; i < nums.length; i++) {
//			for (int j = i+1; j < nums.length ; j++) {
//				if (nums[i]==0&&nums[j]!=0) {
//					tmp = nums[i];
//					nums[i]=nums[j];
//					nums[j]=tmp;
//				}
//			}
//		}
		if (nums.length>1) {		
			int j = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i]!=0) {
					nums[j++]=nums[i];
				}
			}
			for (int i = j; i < nums.length; i++) {
				nums[i]=0;
			}		
		}	
	}

}
