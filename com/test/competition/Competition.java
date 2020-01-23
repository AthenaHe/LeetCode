package com.test.competition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Competition {

/**
 * leetcode周赛 2019.09.08 
 */
	
/*
 * 5181. 公交站间的距离 ok
 */
public static int distanceBetweenBusStops(int[] distance, int start, int destination) {	
	if (start>destination) {
	int tmp = start;
	start = destination;
	destination =tmp;
	}
	int res1 = 0,res2 = 0;
	if (start<destination) {
		//顺时针
		for (int i = start; i < destination; i++) {
			res1+=distance[i];
		}
		//逆时针
		for (int i = destination; i < start+distance.length; i++) {
			res2+=distance[i%distance.length];
		}
	}	
	return Math.min(res1, res2);       
    }
/*
 * 5182. 删除一次得到子数组最大和
 */
public int maximumSum(int[] arr) {
	int[] arr1 = new int[arr.length];
	int sum = 0;
	for (int i = 0; i < arr1.length; i++) {
		arr1[i] = arr[i];
		sum+=arr[i];
	}
	Arrays.sort(arr1);
	if (sum<arr1[arr1.length-1]) {
		
	}
	
	if (sum-arr1[arr1.length-1]<arr1[arr1.length-1]) {
		return arr1[arr1.length-1];
	}	
	return 0;
    
}
/*
 * 5183. 一周中的第几天
 */
public static String dayOfTheWeek(int day, int month, int year) {
	Map<Integer, String> map = new HashMap<Integer, String>();
	map.put(0, "Sunday");map.put(1, "Monday");map.put(2, "Tuesday");map.put(3, "Wednesday");
	map.put(4, "Thursday");map.put(5, "Friday");map.put(6, "Saturday");
	int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	if ((year%4==0&&year%100!=0)||year%400==0) {
		days[1]+=1;
	}
	int sumdays=0;
	for (int i = 0; i < month-1; i++) {
		sumdays+=days[i];
	}
	sumdays+=day;
//判断1月1号是周几	
	int yuandan =(6+(year-2000)+(year-1997)/4+(year-2001)/400-(year-2001)/100)%7;
	System.out.println(yuandan);
	return map.get((sumdays+yuandan-1)%7);	
}	
/*
 * 5184. 使数组严格递增 
 */
public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
	Arrays.sort(arr2);
	int count=-1;
	int j =0;
	for (int i = 1; i < arr1.length-1; i++) {
		if (arr1[i]>=arr1[i+1]) {
			 while (j<arr2.length) {
				if (arr2[j]<arr1[i+1]&&arr2[j]>arr1[i-1]) {
					arr1[i] = arr2[j];
					count++;
					
				}else if (arr2[j]>=arr1[i+1]) {
				arr1[i] = arr2[j];
				arr1[i+1] = arr2[j++];
				count +=2;
				break;				
			}
		j++;
		}
		}
	}
	return count>=0?count+1:count;
    
}
/**
 * leetcode周赛 第 171 场周赛 2020.01.12
 */
/*
 * 5307. 将整数转换为两个无零整数的和
 */
public int[] getNoZeroIntegers(int n) {
	int res[] =new int[2];
	for (int i = 1; i <n ; i++) {
		int j=n-i;
		if (!String.valueOf(i).contains("0")&&!String.valueOf(j).contains("0")) {
			res[0]=i;
			res[1]=j;
		}
	}
	return res;  
}

	public static void main(String[] args) {
		int[] distance = {1,2,3,4};
		int start = 0;
		int destination = 1;
		//System.out.println(distanceBetweenBusStops(distance,start,destination));
		int day=15;
		int month=8;
		int year=1993;
		//System.out.println(dayOfTheWeek(day,month,year));
		int[] arr1= {1,5,3,6,7};
		int[] arr2 = {1,6,3,3};
		System.out.println(makeArrayIncreasing(arr1,arr2));
	}

}
