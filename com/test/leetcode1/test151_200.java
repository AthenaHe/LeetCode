package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
/*
 * 172.阶乘后的零
 */
public int trailingZeroes(int n) {
   //题目简化为查找阶乘中5的个数(分解后) 
	
	//不断除以 5, 是因为每间隔 5 个数有一个数可以被 5 整除, 
	//然后在这些可被 5 整除的数中, 每间隔 5 个数又有一个可以被 25 整除, 故要再除一次,
	//... 直到结果为 0, 表示没有能继续被 5 整除的数了.
	int count = 0;
	while(n/5!=0) {
		count+=n/5;
		n/=5;
	}
	return count;
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
/*
 * 190.颠倒二进制位
 */
public static int reverseBits(int n) {	
	
    return Integer.reverse(n);
}
/*
 * 191. 位1的个数
 */
public static int hammingWeight(int n) {
	String str =Integer.toBinaryString(n);
	int count=0;
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)=='1') 
			count++;
	}
	//Integer.bitCount(n);	
	return count;    
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

public static void main(String[] args) {
	int[] A= {5,9,8};
	int K=987;
	//addToArrayForm(A,K);
	
}
}
