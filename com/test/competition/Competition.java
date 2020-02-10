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
/*
 * 5311. 将数字变成 0 的操作次数
 */
public int numberOfSteps (int num) {
	int step = 0;
	while (num!=0) {
		if (num%2==0) {
			num/=2;
			
		}else {
			num-=1;
		}
		step++;
	}
	return step;  
}
/*
 * 5312. 大小为 K 且平均值大于等于阈值的子数组数目 
 */
public static int numOfSubarrays(int[] arr, int k, int threshold) {
	int count=0;
	for (int i = 0; i < arr.length-k+1; i++) {
		int sum=0;
		for (int j = i; j < i+k; j++) {
			sum+=arr[j];			
		}
		System.out.println(sum+":"+sum/k);
		if ((sum/k)>=threshold) {
			count++;
		}		
	}
	System.out.println(count);
	return count;   
}
/*
 * 5313. 时钟指针的夹角
 */
public static double angleClock(int hour, int minutes) {
	double dumin=minutes*6;
	double duhour=hour*30+minutes*6.0/12;
	double res = Math.abs(duhour-dumin);	
	return res<180?res:360-res;  
}

/*
 * 5332. 检查整数及其两倍数是否存在
 */
public static boolean checkIfExist(int[] arr) {
	Arrays.sort(arr);
	for (int i = arr.length-1; i >=0; i--) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[i]==(2*arr[j])&&i!=j) {
				//System.out.println(arr[i]+":"+arr[j]);
				return true;
			}
		}
	}
	return false;   
}

/*
 * 5333. 制造字母异位词的最小步骤数
 */
public static int minSteps(String s, String t) {
	Map<Character, Integer> map = new HashMap<>();
	Map<Character, Integer> map2 = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);		
	}
	if (map.equals(map2)) {
		return 0;
	}
	int sum=0;
	for (char key:map.keySet()) {
		if (!map2.containsKey(key)) {
			sum+=map.get(key);
		}else {
		sum+=Math.abs(map.get(key)-map2.get(key));
		}
	}
	for (char key:map2.keySet()) {
		if (!map.containsKey(key)) {
			sum+=map2.get(key);
		}	
	}	
	return sum/2;   
}
	public static void main(String[] args) {
		String s= "leetcode";
		String t="practice";
		System.out.println(minSteps(s,t));

}
}
