package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


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
	/*
	 * 832. 翻转图像
	 */
	public static int[][] flipAndInvertImage(int[][] A) {
		int tmp = 0;
//先水平翻转
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length / 2; j++) {
				tmp = A[i][j];
				A[i][j] = A[i][A[i].length - j - 1];
				A[i][A[i].length - j - 1] = tmp;
			}
		}
//再自己翻转
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 0) {
					A[i][j] = 1;
				} else {
					A[i][j] = 0;
				}

			}
		}
		for (int i1 = 0; i1 < A.length; i1++) {
			for (int j = 0; j < A[i1].length; j++) {
				System.out.print(A[i1][j] + ",");
			}
			System.out.println();
		}
		return A;
}
/*
 * 836. 矩形重叠 不懂不懂	
 */
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	return !(rec1[2] <= rec2[0] ||   // left
            rec1[3] <= rec2[1] ||   // bottom
            rec1[0] >= rec2[2] ||   // right
            rec1[1] >= rec2[3]);    // top
    }

/*
 * 844. 比较含退格的字符串 
 * 	第一眼就想到了栈
 */
public boolean backspaceCompare(String S, String T) {
	Stack<Character> Sstack = new Stack<>();
	Stack<Character> Tstack = new Stack<>();
	for (int i = 0; i < S.length(); i++) {
		if (S.charAt(i)!='#') {
			Sstack.push(S.charAt(i));
		}else if (S.charAt(i)=='#'&&!S.isEmpty()) {
			Sstack.pop();
		}	
	}
	for (int i = 0; i < T.length(); i++) {
		if (T.charAt(i)!='#') {
			Tstack.push(T.charAt(i));
		}else if (T.charAt(i)=='#'&&!T.isEmpty()) {
			Tstack.pop();
		}	
	}	
	return Sstack.equals(Tstack);    
}

/*
 * 849. 到最近的人的最大距离
 */
public static int maxDistToClosest(int[] seats) {
	int first=0,last=seats.length-1;
	while (seats[first]==0) {
		first++;
	}	
	while (seats[last]==0) {
		last--;
	}	
	int max=Math.max(first, seats.length-1-last);
	int num=0;
	while (first<=last) {
		if (seats[first++]==0) {
			num++;
		}else {
			if ((num+1)/2>max) {
				max=(num+1)/2;
			}
		num=0;
		}		
	}
return max;
}
	public static void main(String[] args) {
	int[] a = {1,0,0,0,1};
System.out.println(maxDistToClosest(a));
	}

}