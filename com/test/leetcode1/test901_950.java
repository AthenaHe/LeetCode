package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test901_950 {

/*
 * 905. 按奇偶排序数组
 */
public int[] sortArrayByParity(int[] A) {
	//借用快速排序的思想
	int left=0,right=A.length-1,tmp=0;
	while (left<right) {
		while (left<right&&A[left]%2==0) {
			left++;
		}
		while (left<right&&A[right]%2!=0) {
			right--;
		}	
		if (left<right) {
			tmp = A[left];
			A[left] = A[right];
			A[right] = tmp;	
		}							
	}	
	return A;   
}

/*
 * 908. 最小差值 I so easy
 */
public int smallestRangeI(int[] A, int K) {
	//先从大到小排序
	Arrays.sort(A);
	//如果最大值和最小值之间差距比2k小，说明两数处理后有机会相等
	if ((A[A.length-1]-A[0])<=2*K) {
		return 0;
	}else {
		//如果最大值和最小值之间差距比2k大，那只能尽量处理使两者之间的差距变小
		return (A[A.length-1]-K)-(A[0]+K);
	}    
}

/*
 * 914. 卡牌分组
 */
public static boolean hasGroupsSizeX(int[] deck) {
	Map<Integer, Integer> map =new HashMap<Integer, Integer>();
	//计算每一种数字出现的次数
	for (int i = 0; i < deck.length; i++) {
		map.put(deck[i], map.getOrDefault(deck[i], 0)+1);
	}
	int min=10000;
	//找出最少的出现次数
	for (int count:map.values()) {
		System.out.println(count);
		min = Math.min(min, count);
		
	}
	//如果某个数字只出现了1次，说明只能单个分组，不满足题目要求
	if (min<=1) {
		return false;
	}
	int min1 = min;
	//判断两个数是否互质
	for (int count:map.values()) {
		int c=0;		
		while ((c=count%min1)!=0) {
			count = min1;
			min1=c;			
		}
		if (min1==1) {
			return false;
		}
		min1=min;
	}	
	return true;    
}


/*
 * 917. 仅仅反转字母  
 * 字符串是常量，不可以重新赋值哦
 */
public static String reverseOnlyLetters(String S) {
	char[] arr = S.toCharArray();
	int i=0,j=arr.length-1;
	char tmp;
	while (i<j) {
		while (i<j&&!isLetter(arr[i])) {
			i++;
		}
		while (i<j&&!isLetter(arr[j])) {
			j--;
		}
		tmp = arr[i];
		arr[i]= arr[j];
		arr[j]=tmp;
		i++;
		j--;				
	}		
	return String.copyValueOf(arr);   
}
public static boolean isLetter(char ch) {
	return (ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z');
}
/*
 * 
 */
public int[] sortArrayByParityII(int[] A) {
	int i=0,j=1,tmp;
	while (i<A.length||j<A.length) {
		while (i<A.length&&A[i]%2==0) {
			i+=2;			
		}
		while (j<A.length&&A[j]%2!=0) {
			j+=2;
		}
		if (i<A.length&&j<A.length) {
			tmp=A[i];
			A[i] =A[j];
			A[j] = tmp;
		}		
	}
	return A;    
}

/*
 * 925. 长按键入
 */
public boolean isLongPressedName(String name, String typed) {
    if(name.length()>typed.length()){
        return false;
    }
    int i=0;
    int j=0;
    while(i<name.length()&&j<typed.length()){
        if(name.charAt(i)==typed.charAt(j)){
            i++;
            j++;
        }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
            j++;
        }else{
            return false;
        }
    }
    return i ==name.length();    
}
/*
 * 929. 独特的电子邮件地址
 */
public static int numUniqueEmails(String[] emails) {
	Set<String> set =new HashSet<>();	
	for (int i = 0; i < emails.length; i++) {
		String ss ="";
		if (emails[i].contains("+")) {		
		//如果地址中有+，就只截取+前面的内容并删除.,然后再与@及后面的字符串做拼接，形成一个正常的地址。
		ss=emails[i].substring(0, emails[i].indexOf('+')).replaceAll("\\.", "")+emails[i].substring(emails[i].indexOf('@'), emails[i].length());			
		}else {
		//如果地址中没有+，就只截取@前面的内容并删除.,然后再与@及后面的字符串做拼接，形成一个正常的地址。
		ss=emails[i].substring(0, emails[i].indexOf('@')).replaceAll("\\.", "")+emails[i].substring(emails[i].indexOf('@'), emails[i].length());			
		}
		System.out.println(ss);
		set.add(ss);			
	}	
	return set.size();    
}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,4,3,2,1};
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));

	}

}
