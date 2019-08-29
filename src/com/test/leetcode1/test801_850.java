package com.test.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	int[] res = new int[2];
	if (S.length()==0) {
	    return res;
	}
	res[1] = 0;
	res[0]=1;
	for (int i = 0; i < S.length(); i++) {
	    if (res[1]<=100) {
	    	res[1]+=widths[S.charAt(i)-'a'];
	    }
	    if (res[1]>100) {			
	    	res[1]=widths[S.charAt(i)-'a'];
	        res[0]+=1;
	    }
	}		
	return res;   
}

/*
 * 811. 子域名访问计数
 */
public List<String> subdomainVisits(String[] cpdomains) {
	List<String> list = new ArrayList<>();
	Map<String, Integer> map = new HashMap<String, Integer>();
	// 遍历每一组字符串
	for (int i = 0; i < cpdomains.length; i++) {
		// 将访问次数和域名分开存放
		String[] tmp = cpdomains[i].split(" ");
		// 访问次数
		int number = Integer.parseInt(tmp[0]);
		// 域名进行.分割(要转义)
		String[] domain = tmp[1].split("\\.");
		String tmp1 = "";
		// 从后往前遍历，最后一个域名不用加.,其余的要加.
		for (int j = domain.length - 1; j >= 0; j--) {
			if (j == domain.length - 1) {
				tmp1 += domain[j];
			} else {
				tmp1 = domain[j] + "." + tmp1;
			}
			// 如果map集合中没有该域名，就新增域名并加number，有该域名就在此基础上再加number
			map.put(tmp1, map.getOrDefault(tmp1, 0) + number);
		}
	}
	// 遍历map集合，map的key：域名，value：访问次数
	for (String res : map.keySet()) {
		list.add(map.get(res) + " " + res);
	}
	return list;
}

/*
 * 824. 山羊拉丁文
 */
public String toGoatLatin(String S) {
	if (S.length()==0) {
		return null;
	}
	String res="";
	String[] words = S.split(" ");
	List<String> list = new ArrayList<>();
	list.add("a");list.add("e");list.add("i");list.add("o");list.add("u");
	list.add("A");list.add("E");list.add("I");list.add("O");list.add("U");
	for (int i=0;i<words.length;i++ ) {
		if (list.contains(words[i].substring(0, 1))) {
			words[i]=words[i].substring(1,words[i].length())+words[i].substring(0, 1);
		}
		words[i]+="ma";
		for (int j = 1; j <= i+1; j++) {
			words[i]+="a";
		}
	res+=words[i]+" ";
	}
	return res.trim();
    
}
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));

	}

}
