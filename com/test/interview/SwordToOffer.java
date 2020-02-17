package com.test.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SwordToOffer {
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
		// TODO Auto-generated method stub

	}

}
