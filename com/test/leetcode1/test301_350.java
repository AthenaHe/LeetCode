package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class test301_350 {
/*
 * 303. 区域和检索 - 数组不可变
 */
	private int[] sums;
	public test301_350(int[] nums) { //public NumArray(int[] nums) 
        sums=new int[nums.length];
        if (nums.length==0) {
			return;
		}
        sums[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
			sums[i]=sums[i-1]+nums[i];
		}
    }
    
    public int sumRange(int i, int j) {
    	if (i==0) {
			return sums[j];
		}else {
			return sums[j]-sums[i-1];
		}       
    }
	
	/**
	 * 326. 3的幂
	 * @param args
	 */


	public boolean isPowerOfThree(int n) {
		if (n==1) {
			return true;
		}
		if (n<=0) {
			return false;
		}
		
		while (n%3==0) {
			n=n/3;		
		}			
		
		return n>1?false:true;    
	}
	/**
	 * 342. 4的幂
	 * @param num
	 * @return
	 */
	public boolean isPowerOfFour(int num) {
		if (num<1) {
			return false;
		}	
		while (num%4==0) {
			num=num/4;
			
		}
		return num==1;
	    
	}
	/**
	 * 344. 反转字符串
	 * @param s
	 */
	public void reverseString(char[] s) {
	    char tmp;
	    for (int i = 0; i < s.length/2; i++) {
			tmp=s[i];
			s[i]=s[s.length-1-i];
			s[s.length-1-i] = tmp;
		}
	}
	/**
	 * 345. 反转字符串中的元音字母
	 * @param s
	 * @return
	 */
	public String reverseVowels(String s) {
		char[] letters = s.toCharArray();
	    //使用快排的方法
	    List<Character> list = new ArrayList<>();
	    char[] letter=new char[] {'a','e','i','o','u','A','E','I','O','U'};
	    for(int i=0;i<s.length();i++)
	        list.add(letter[i]);
	    if (s.length() > 1) {
	        int i = 0;
	        int j = s.length() - 1;
	        char temp;

	        while (i < j) {
	            while (j > i && !list.contains(letters[i]))
	                i++;
	            while (j > i && !list.contains(letters[j]))
	                j--;
	            if (i < j) {
	                temp = letters[j];
	                letters[j] = letters[i];
	                letters[i] = temp;
	                i++;
	                j--;
	            }
	        }
	        s = String.valueOf(letters);
	    }
	    return s;
			
		}
/*
 * 347. 前 K 个高频元素
 */
public List<Integer> topKFrequent(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
		map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
	}
	List<Integer> list = new ArrayList<>();
	for(int key:map.keySet()) {
		list.add(map.get(key));
	}
	Collections.sort(list);
	List<Integer> res = new ArrayList<>();
	for(int i=list.size()-1;i>=list.size()-k;i--) {
	for(Entry<Integer, Integer> item:map.entrySet()) {
		if (list.get(i)==item.getValue()) {
			res.add(item.getKey());
			map.remove(item.getKey());
			break;
		}
	}
}
	return res;
  }
	/**
	 * 349. 两个数组的交集
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (list.contains(nums2[i])) {
				set.add(nums2[i]);
			}
		}
		int[] res = new int[set.size()];
		Iterator  iterator = set.iterator();
		int k=0;
		while (iterator.hasNext()) {
			res[k++]=(int)iterator.next();
			
		}	
		return res;    
	}
	/**
	 * 350. 两个数组的交集 II
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (list.contains(nums2[i])) {
				list2.add(nums2[i]);
				list.remove(Integer.valueOf(nums2[i]));			
			}
		}
		int[] res = new int[list.size()];
		Iterator  iterator = list.iterator();
		int k=0;
		while (iterator.hasNext()) {
			res[k++]=(int)iterator.next();
			
		}	
		return res;        
	}

}
