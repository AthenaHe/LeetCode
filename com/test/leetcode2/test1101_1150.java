package com.test.leetcode2;

import java.util.ArrayList;
import java.util.Calendar;
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
 * 1185. 一周中的第几天
 */
public String dayOfTheWeek(int day, int month, int year) {
	String[] week = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	Calendar calendar = Calendar.getInstance();
	calendar.set(calendar.YEAR, year);
	calendar.set(calendar.MONTH, month-1);
	calendar.set(calendar.DAY_OF_MONTH, day);
	return week[calendar.get(Calendar.DAY_OF_WEEK)-1];      
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

/*
 * 1128. 等价多米诺骨牌对的数量	
 */
public int numEquivDominoPairs(int[][] dominoes) {
	//1 <= dominoes[i][j] <= 9
	int[][] pair = new int[10][10];	
	int count=0;
	for (int i = 0; i < dominoes.length; i++) {
		//将每个相同的dominos[i][j]放到新数组中进行计数
		pair[dominoes[i][0]][dominoes[i][1]]++;
	}
	//根据对称性，将对角线以上的进行遍历相加
	for (int i = 1; i <10; i++) {
		for (int j = i; j <10; j++) {
			if (i!=j) pair[i][j]+=pair[j][i];
			count+=(pair[i][j]*(pair[i][j]-1))/2;
		}
	}
	return count;
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
