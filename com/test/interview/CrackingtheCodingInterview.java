package com.test.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//程序员面试金典No.6
public class CrackingtheCodingInterview {
/*
 * 面试题 01.01. 判定字符是否唯一
 */
public boolean isUnique(String astr) {
	Set<Character> set = new HashSet<>();
	for (int i = 0; i < astr.length(); i++) {
		set.add(astr.charAt(i));
	}
	return set.size()==astr.length();       
}
/*
 * 面试题 01.02. 判定是否互为字符重排
 * =异构字符串
 */
public boolean CheckPermutation(String s1, String s2) {
	Map<Character, Integer> map1 = new HashMap<>();
	for (int i = 0; i < s1.length(); i++) {
		map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
	}
	Map<Character, Integer> map2 = new HashMap<>();
	for (int i = 0; i < s2.length(); i++) {
		map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
	}
	return map1.equals(map2);  
}
/*
 * 面试题 01.03. URL化
 */
public String replaceSpaces(String S, int length) {
    StringBuilder str = new StringBuilder();
	for (int i = 0; i < length; i++) {
		if (S.substring(i, i+1).equals(" ")) {
			str.append("%20");
		}else {
			str.append(S.substring(i, i+1));
		}		
	}
	return str.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
