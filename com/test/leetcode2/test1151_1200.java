package com.test.leetcode2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * 1071. 字符串的最大公因子
 */
public String gcdOfStrings(String str1, String str2) {
	if ((str1+str2).equals(str2+str1)) {
		return str1.substring(0, gcdstrlen(str1.length(), str2.length()));
	}
	return "";
}
public int gcdstrlen(int a,int b) {
	return a==0?b:gcdstrlen(b%a, a);
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

/*
 * 1189. “气球” 的最大数量
 */
public int maxNumberOfBalloons(String text) {
	Map<Character, Integer> map = new HashMap<>();
	for (int i = 0; i < text.length(); i++) {
		map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0)+1);
	}
	String word = "balloon";
	int count = Integer.MAX_VALUE;
	for (int i = 0; i < word.length(); i++) {
		if (map.containsKey(word.charAt(i))) {
			int tmp =map.get(word.charAt(i));
			if (word.charAt(i)=='l'||word.charAt(i)=='o') {
				tmp/=2; 
			}
		   count = Math.min(tmp,count);
		}else {
			return 0;
		}	
	}	
	return count;    
}
/*
 * 1200. 最小绝对差
 */
public List<List<Integer>> minimumAbsDifference(int[] arr) {	
	//给数组按升序排序
	Arrays.sort(arr);
	int min = Integer.MAX_VALUE;
	//找到绝对差最小的值
	for (int i = 0; i < arr.length-1; i++) {
		min = Math.min(min, Math.abs(arr[i+1]-arr[i]));
	}
	List<List<Integer>> res = new ArrayList<>();
	//如果元素对绝对差值等于最小值，就加入集合中
	for (int i = 0; i < arr.length-1; i++) {
		List<Integer> list = new ArrayList<>();
		if (Math.abs(arr[i+1]-arr[i])==min) {
			list.add(arr[i]);
			list.add(arr[i+1]);
		}
		if (list.size()!=0) {
			res.add(list);
		}		
	}
	return res;   
}

/*
 * 5205. 独一无二的出现次数
 */
public boolean uniqueOccurrences(int[] arr) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < arr.length; i++) {
		map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
	}
	Set<Integer> keyset=new HashSet<>();
	for(int i:map.keySet()) {
		keyset.add(i);
	}
	Set<Integer> valueset=new HashSet<>();
	for(int j:map.values()) {
		valueset.add(j);
	}
	return keyset.size()==valueset.size();    
}
/*
 * 5213. 玩筹码
 */
public int minCostToMoveChips(int[] chips) {
	int odd = 0, even = 0;
	for (int i = 0; i < chips.length; i++) {
		if (chips[i] % 2 == 0) {
			even++;
		} else if (chips[i] % 2 != 0) {
			odd++;
		}
	}
	return Math.min(even, odd);
}


	public static void main(String[] args) {

	}

}
