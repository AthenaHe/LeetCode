package com.test.leetcode1;

import java.util.Arrays;
import java.util.HashMap;

public class test501_550 {
	 //树结点定义
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	/*
	 * 504. 七进制数
	 */
	public static  String convertToBase7(int num) {
		int res = 0;
		String result = new String();
		boolean flag= false;
		if (num==0) {
			return "0";
		}
		
		if (num<0) {
			num=-num;
			flag=true;
		}
		//System.out.println(num);
		while (num!=0) {
			res=num%7;
			num=num/7;
			result=res+result;
		}
		if (flag) {
			result="-"+result;
		}	
		return result;
	}
	
	/*
	 * 507. 完美数
	 */
	public boolean checkPerfectNumber(int num) {
		int sum=0;
		if (num==1) {
			return false;
		}
		for (int i = 2; i <=Math.sqrt(num); i++) {
			if (num%i==0&&i*i!=num) {				
				sum+=i+num/i;
			}
			if (i*i==num) {
				sum+=i;
			}
		}	
		if ((sum+1)==num) {
			return true;
		}
		return false;	    
	}
	
	
/*
 *509. 斐波那契数 
 */
public int fib(int N) {
	int result;
	if (N==0||N==1) {
		return N;
	}
	result=fib(N-1)+fib(N-2);
	return result;
        
    }
/*
 * 520. 检测大写字母
 */
public  static boolean detectCapitalUse(String word) {
	if (word.length()<2) {
		return true;
	}
	if (word.toUpperCase().equals(word)||word.toLowerCase().equals(word)) {
		return true; 
	}
	if (word.substring(0, 1).toUpperCase().equals(word.substring(0, 1))&&word.substring(1).toLowerCase().equals(word.substring(1))) {
		return true;
	}
	return false;    
}

/*
 * 521. 最长特殊序列 Ⅰ
 */
public int findLUSlength(String a, String b) {
   if (a.length()!=b.length()) {
	return a.length()>b.length()?a.length():b.length();
}
	if (!a.equals(b)) {
		return a.length();
	}
   return -1;
}

/*
 * 532. 数组中的K-diff数对
 */
public static int findPairs(int[] nums, int k) {
	//思路：利用map集合的没有重复元素和存放的是两个有关联的k和value
	//的值得特性只要符合条件就添加，map集合添加时会把相同的给替换掉
	if(k < 0) {
	return 0;
	}
	//先给数组排序保证是用大的减去小的
	Arrays.sort(nums);
	//然后创建map集合
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	//遍历数组中的元素
	for (int i = 0; i < nums.length; i++) {
	for (int j = i+1; j < nums.length; j++) {
	//只要符合条件的就往map集合中添加
	if (nums[j]-nums[i]==k) {
	map.put(nums[j], nums[i]);
	}
	}
	}
	System.out.println(map.size());
	//最后输出map集合的大小就是符合条件的个数
	return map.size();
	}
/*
 * 541. 反转字符串 II
 */
public static String reversek(String ss) {
	String result="";
	for (int i = ss.length(); i >0; i--) {
		result+=ss.substring(i-1, i);		
	}
	//System.out.println(result);
	return result;	
}
public static String reverseStr(String s, int k) {
	if (k<1) {
		return s;
	}
	String result="";
	int l=s.length()%(2*k);
	//System.out.println("l:"+l);

	int l1 = s.length()/(2*k);
	//System.out.println("l1:"+l1);
	for (int i = 0; i < l1; i++) {
		//reversek(s.substring(i*2*k, i*2*k+k));
		result+=reversek(s.substring(i*2*k, i*2*k+k))+s.substring(i*2*k+k, (i+1)*2*k);
	}
	if (l>k) {
		reversek(s.substring(l1*2*k, l1*2*k+k));
		result+=reversek(s.substring(l1*2*k, l1*2*k+k))+s.substring(l1*2*k+k);
	}else {
		result+=reversek(s.substring(l1*2*k));
	}
	//System.out.println("result:"+result);
	return result;    
}


	public static void main(String[] args) {		
		String ss = "sfsfsdgvcedfw";
		String ssr ="fssfdsgvecdfw";
		reverseStr(ss, 2) ;

	}

}
