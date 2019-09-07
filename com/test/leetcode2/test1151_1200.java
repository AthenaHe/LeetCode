package com.test.leetcode2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1151_1200 {
	/*
	 * 1154. 一年中的第几天
	 */
	public int dayOfYear(String date) {
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);
		boolean leap = false;
		int res=0;
		//先判断年份是否是闰年
		int[] daysArray = {31,28,31,30,31,30,31,31,30,31,30,31};
	if ((year%4==0&&year%100!=0)||year%400==0) {
		leap=true;	
		daysArray[1]+=1;
	}
	for (int i = 0; i < month-1; i++) {
		res+=daysArray[i];
	}
		res+=day;	
		return res;   
	}
/*
 * 1160.拼写单词
 */
public static int countCharacters(String[] words, String chars) {
	if(words.length==0||chars.length()==0)return 0;
    HashMap<Character,Integer> map=new HashMap<>();
    int sum=0;
    //将chars的各个字符加入到map集合中，并将出现次数计数。
    for (int i = 0; i < chars.length(); i++) {
    	map.put(chars.charAt(i),map.getOrDefault(chars.charAt(i),0)+1);
	}
    //扫描字符串数组words中中的每个字符串
    for (String word:words) {
    	// 克隆一个一摸一样的map字母表集合
    	 HashMap<Character, Integer> tmpmap = (HashMap<Character, Integer>) map.clone();
    	//扫描单词word中的每个字母
    	 int count=0;
    	for (int i = 0; i < word.length(); i++) {
    		//如果字母表中有这个字母
    		if (tmpmap.containsKey(word.charAt(i))) {
    			//如果这个字母在字母表中的次数大于0
    			if (tmpmap.get(word.charAt(i))>0) {
    			//那就把字母表中的该字母次数暂时减一
    			tmpmap.put(word.charAt(i), tmpmap.get(word.charAt(i))-1);
    			count++;
    			}	
    		}
    		//如果计数次数正好等于单词长度，说明单词的字母都在字母表中，那就加到总计数中
    		if (count==word.length()) {
				sum+=count;
			}
		}	
	}
    return sum;
    }
/*
 * 1175. 质数排列
 */
public static int numPrimeArrangements(int n) {
	int primecount=0,notprimecount = 0;
	Long sum=1L;
	//先找出n个数中所有质数的个数
	for (int num = 1; num <=n; num++) {
		primecount+=isPrime(num);	
	}		
	notprimecount=n-primecount;
	//所有的质数可以全排列，所有的偶数可以全排列
	for (int i = 1; i <= primecount; i++) {
		sum=sum*i%(1000000000+7);
	}
	for (int i = 1; i <= notprimecount; i++) {
		sum=sum*i%(1000000000+7);
	}
	
	return sum.intValue();
	

	
}
//判断一个数是否是质数
public static  int  isPrime(int num) {
	if (num<2) {
		return 0;
	}
	for (int i = 2; i <=Math.sqrt(num); i++) {
		if (num%i==0) {
			return 0;
		}
	}
		return 1;
}
/*
 * 1176. 健身计划评估
 */
public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
	int score = 0;
    int length = calories.length - k + 1;
    for(int i=0; i<length; i++){
        int sum = 0;
        for(int j=i; j<(k+i); j++){
            sum += calories[j];
        }
        if(sum < lower){
            score--;
        }else if(sum > upper){
            score++;
        }
    }
    return score;
}
	public static void main(String[] args) {
		String[] queries = {"bbh","cc"};
		String[] words = {"a","aa","aaa","aaaa"};
		System.out.println(numPrimeArrangements(100));

	}

}
