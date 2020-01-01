package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test701_750 {
/*
 * 704. 二分查找
 */
public static int search(int[] nums, int target) {
	int left = 0,right = nums.length-1;
	int middle;
	while (left<=right) {
	  middle=left+(right-left)/2;
	  if (nums[middle]==target) {
		return middle;
	}
	  if (nums[middle]>target) {
		right=middle-1;
	}
	  if (nums[middle]<target) {
		left=middle+1;
	}		
	}	
	return -1;        
    }
/*
 * 709. 转换成小写字母
 */
public static  String toLowerCase(String str) {
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)>='A'&&str.charAt(i)<='Z') {
			str=str.replace(str.charAt(i), (char) (str.charAt(i)+32));
		}
	}	
	return str;    
}
/*
 * 717. 1比特与2比特字符
 */
public boolean isOneBitCharacter(int[] bits) {
	      int start = 0 ;
	        while(start<bits.length-1){
	            if(bits[start] == 0){
	                start++;
	            }else{
	                start+=2;
	            }
	        }
	        return start == bits.length-1;  
}
/*
 * 720. 词典中最长的单词
 */
public String longestWord(String[] words) {
	//对数组排序，再利用Set对字母存储，小的单词一定包含在后面大的单词里面。后面只需要取前缀相同的
    //对字母排序后，第一个单词一定是共有的，后面只需在此基础上添加
    Arrays.sort(words);
    Set<String> set = new HashSet<>();
    String res = "";
    for (String s : words) {
        //如果单词只有一个字母，那一定是共有的
        if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
            res = s.length() > res.length() ? s : res;
            set.add(s);
        }
    }
    return res;
}


/*
 * 724. 寻找数组的中心索引
 */
public int pivotIndex(int[] nums) {
	int sum=0,newsum=0;
	for (int i = 0; i < nums.length; i++) {
		sum+=nums[i];
	}
	for (int i = 0; i < nums.length; i++) {		
		if ((newsum*2+nums[i])==sum) {
			return i;
		}
		newsum+=nums[i];
	}
	
	return -1;
    
}

/*
 * 728. 自除数
 */
public static List<Integer> selfDividingNumbers(int left, int right) {
	List<Integer> list = new ArrayList<>();
	for (int i = left; i <= right; i++) {
		String iString = String.valueOf(i);
		int j=0;
		while (j<iString.length()) {
			if (iString.charAt(j)=='0'||i%Integer.parseInt(String.valueOf(iString.charAt(j)))!=0) {
				break;
				
			}else {
				j++;
			}			
		}
		if (j==iString.length()) {
			list.add(i);
		}
		}
	return list;   
}

/*
 * 744. 寻找比目标字母大的最小字母
 */
public char nextGreatestLetter(char[] letters, char target) {
	for (int i = 0; i < letters.length-1; i++) {
		if (letters[i]<=target&&letters[i+1]>=target) {
			return letters[i+1];
		}
	}	
	return letters[0];    
}

/*
 * 746. 使用最小花费爬楼梯
 */
public int minCostClimbingStairs(int[] cost) {
	//动态规划的做法
	int len =cost.length;
    int[] dp=new int[len];
    dp[0]=cost[0];
    dp[1]=cost[1];   
    for(int i=2;i<len;i++){
        dp[i]=Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
    }  
    return Math.min(dp[len-1],dp[len-2]);
}
/*
 * 747. 至少是其他数字两倍的最大数
 */
public int dominantIndex(int[] nums) {
	if (nums.length<2) {
		return 0;
	}
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
		map.put(nums[i], i);
	}
	Arrays.sort(nums);
	if (nums[nums.length-1]>=nums[nums.length-2]*2) {
		return map.get(nums[nums.length-1]);
	}
	return -1;   
}

/*
 * 748. 最短完整词
 */
public static String shortestCompletingWord(String licensePlate, String[] words) {
	List<Character> list = new ArrayList<>();
	licensePlate=licensePlate.toLowerCase();//将牌照中的大写字母转换成小写
    //将牌照中的字母放到list集合中
	for (int i = 0; i < licensePlate.length(); i++) {
		if (licensePlate.charAt(i)>='a'&& licensePlate.charAt(i)<='z') {
			list.add(licensePlate.charAt(i));
		}
	}
	int wordlength=Integer.MAX_VALUE;
	String result="";
	for (int i = 0; i < words.length; i++) {
		List<Character> list2=new ArrayList<>(list);
        //牌照中包含word字母，就把牌照中对应字母删除
		for (int j = 0; j < words[i].length(); j++) {
			list2.remove((Character)words[i].charAt(j));
		}
        //最终牌照中的字母全部被删除，说明words中的该单词包含牌照中的所有字母，并记录短长度的单词
		if (list2.size()==0&&words[i].length()<wordlength) {
			result=words[i];
			wordlength=words[i].length();
		}		
	}	
	return result;   
}
	public static void main(String[] args) {	
		String licensePlate = "Ah71752";
		String[] words= {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
		System.out.println(shortestCompletingWord(licensePlate,words));
	}

}
