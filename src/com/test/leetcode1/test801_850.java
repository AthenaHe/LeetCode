package com.test.leetcode1;

import java.util.HashSet;
import java.util.Set;

public class test801_850 {
/*
 * 804. 唯一摩尔斯密码词
 */
public static  int uniqueMorseRepresentations(String[] words) {
	String[] mors = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	Set<String> set = new HashSet<String>();
	for (String word:words) {
		String tmp="";
		for (int i = 0; i < word.length(); i++) {
			tmp+=mors[word.charAt(i)-'a'];
		}
		set.add(tmp);
	}
	return set.size();   
}

/*
 * 806. 写字符串需要的行数
 */
public int[] numberOfLines(int[] widths, String S) {
	
	return widths;
    
}
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));

	}

}
