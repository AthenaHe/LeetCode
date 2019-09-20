package com.test.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

/*
 * 1122. 数组的相对排序
 */
public int[] relativeSortArray(int[] arr1, int[] arr2) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < arr1.length; i++) {
		map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
	}
	int[] res=new int[arr1.length];
	int j=0;
	for (int i = 0; i < arr2.length; i++) {
		for (int k = 0; k < map.get(arr2[i]); k++) {
			res[j++]=arr2[i];
		}
		map.remove(arr2[i]);
	}
	List<Integer> mapkey=new ArrayList<>();
	for(int key:map.keySet()) {
		mapkey.add(key);		
	}
	//对key值排序
	Collections.sort(mapkey);
	
	for (int i = 0; i < mapkey.size(); i++) {
		for (int k = 0; k < map.get(mapkey.get(i)); k++) {
			res[j++]=mapkey.get(i);
		}		
	}
	return res;       
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
