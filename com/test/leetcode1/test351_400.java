package com.test.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class test351_400 {
	/**
	 * 367. 有效的完全平方数
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		for (int i = 1; i <(num+1)/2; i++) {
			if (i*i==num) {
				return true;
			}
		}	
		return false;
	    
	}
/*
 * 371. 两整数之和
 */
public int getSum(int a, int b) {
	while (b!=0) {
		int sum = a^b;
		int carry = (a&b)<<1;
		a=sum;
		b=carry;		
		}
	return a;        
  }	
	/**
	 * 374. 猜数字大小
	 * @param n
	 * @return
	 */
public	int guess(int num) {
		return 0;
	}
public int guessNumber(int n) {
	int l=1,r=n;
	int mid;
	while (l<=r) {
		 mid=l+(r-l)/2;
		if (guess(mid)==1) {
			l=mid+1;
		}else if (guess(mid)==-1) {
			r=mid-1;
		}else if (guess(mid)==0) {
			return mid;
		}		
	}
	return 0;        
    }
/**
 * 383. 赎金信
 * @param ransomNote
 * @param magazine
 * @return
 */
public boolean canConstruct(String ransomNote, String magazine) {
	List<Character> list = new ArrayList<Character>();
	for (int i = 0; i < magazine.length(); i++) {
		list.add(magazine.charAt(i));
	}
	for (int i = 0; i < ransomNote.length(); i++) {
		if (!list.contains(ransomNote.charAt(i))) {
			return false;
		}
		list.remove(Character.valueOf(ransomNote.charAt(i)));
	}
	
	return true;
    
}

/**
 * 387. 字符串中的第一个唯一字符
 * @param s
 * @return
 */
public int firstUniqChar(String s) {
	        int[] freq = new int[26];
	        char[] chars = s.toCharArray();
	        for (char ch : chars) {
	            freq[ch - 'a']++;
	        }
	        for (int i = 0; i < chars.length; i++) {
	            if (freq[chars[i] - 'a'] == 1) {
	                return i;
	            }
	        }
	        return -1;
	    }


/**
 * 389. 找不同
 * @param s
 * @param t
 * @return
 */
public char findTheDifference(String s, String t) {
	List<Character> list=new ArrayList<>();
	for (int i = 0; i < s.length(); i++) {
		list.add(s.charAt(i));
	}
	for (int i = 0; i < t.length(); i++) {
		if (!list.contains(t.charAt(i))) {
			return t.charAt(i);
		}
		list.remove(Character.valueOf(t.charAt(i)));
	}	
	return 0;   
}

/**
 * 400. 第N个数字 暴力破解导致超时了
 * @param n
 * @return
 */
public static int findNthDigit(int n) {
	 int i=1,j=1; 
	 String ii;
	 int y = 0;
	 while (j<=n) {
	 ii=String.valueOf(i);
	 //System.out.println("ii:"+ii+" length:"+ii.length());
	 
		for (int k = 0; k < ii.length()&&j<=n; k++) {
			j++;
			y=ii.charAt(k)-'0';
			//System.out.println("y:"+y);
		}
		i++;		
	}
	 System.out.println("i"+i+" j:"+j);
	
	return y;
    
}



	public static void main(String[] args) {
		System.out.println(findNthDigit(1000000000));

	}

}
