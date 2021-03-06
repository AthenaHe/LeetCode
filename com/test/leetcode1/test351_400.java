package com.test.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class test351_400 {
/*
 * 365. 水壶问题
 * 分析：求x，y最大公约数，判断能否被z整除
 */
public boolean canMeasureWater(int x, int y, int z) {
	if (x+y<z) return false;
	if (x==z||y==z||x+y==z) return true;
	return z%gcd(x, y)==0;
}
//求x，y最大公约数
int gcd(int x,int y) {
	return y==0?x:gcd(x, x%y);
}

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
 * 392. 判断子序列
 */
public boolean isSubsequence(String s, String t) {
	int index=-1;
	for (char c: s.toCharArray()) {
		//从上次检索到的下一个位置进行检索
		index=t.indexOf(c, index+1);
		//检索不到会返回-1，说明t中没有这个字符，就不是子序列了。
		if (index==-1) return false;
	}
	return true;   
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
