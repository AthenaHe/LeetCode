package com.test.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//程序员面试金典No.6
public class CrackingtheCodingInterview {

public class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
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
/*
 * 面试题 01.04. 回文排列
 */
public boolean canPermutePalindrome(String s) {
	Map<Character, Integer> map = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);		
	}
	int count = -1;
	for(char key:map.keySet()) {
		if (map.get(key)%2!=0) {
			count++;
		}
	}
	return count<=0;   
}
/*
 * 面试题 01.05. 一次编辑
 */
public static boolean oneEditAway(String first, String second) {
	int len = first.length()-second.length();	
	if (len>1||len<-1) {
		return false;
	}
	int count=1;
	for (int i = 0,j=0; i < first.length()&&j < second.length(); i++,j++) {
		System.out.println(first.charAt(i)+","+second.charAt(j));
		if (first.charAt(i)!=second.charAt(j)) {
			if (len==1) { //second要不要添加一个字符
				j--;
			}else if (len==-1) { //second要不要删除一个字符
				i--;
			}	
			count--;
		}
		if (count<0) {
			System.out.println(count);
			return false;
		}
	}
	return true;   
}
/*
 * 面试题 01.06. 字符串压缩
 */
public String compressString(String S) {
	S=S+" ";
	StringBuilder sb = new StringBuilder();
	int count=0;
	for (int i = 0; i < S.length()-1; i++) {
		count++;
		if (S.charAt(i)!=S.charAt(i+1)) {
			sb.append(S.charAt(i));
			sb.append(count);
			count=0;
		}		
		if (sb.length()>=S.length()-1) {
			return S.substring(0, S.length()-1);
		}		
	}
	return sb.toString();   
}
/*
 * 面试题 01.07. 旋转矩阵
 */
public void rotate(int[][] matrix) {
//左右翻转
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[i].length/2; j++) {
			int tmp=matrix[i][j];
			matrix[i][j]=matrix[i][matrix.length-1-j];
			matrix[i][matrix.length-1-j]=tmp;
		}
	}
	//主对角线翻转
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix.length-i; j++) {
			int tmp=matrix[i][j];
			matrix[i][j]=matrix[matrix.length-1-j][matrix.length-1-i];
			matrix[matrix.length-1-j][matrix.length-1-i]=tmp;
		}
	}	
}
/*
 * 面试题 01.09. 字符串轮转
 */
public boolean isFlipedString(String s1, String s2) {
	if (s1.length()!=s2.length()) {
		return false;
	}
	String ss = s2+s2;
	return ss.contains(s1);
}
/*
 * 面试题 10.01. 合并排序的数组
 */
public void merge(int[] A, int m, int[] B, int n) {
	int k = m-1,i=m-n-1,j=n-1;
	while(i>=0&&j>=0) {
		if (A[i]<B[j]) {
			A[k--]=B[j];
			j--;
		}else {
			A[k--]=A[i];
			i--;
		}
	}
	while(i>=0) {
		A[k--]=A[i];
		i--;
	}
	while(j>=0) {
		A[j--]=B[j];
		j--;
	}
}

/*
 * 面试题 16.07. 最大数值
 */
public int maximum(int a, int b) {
	long cha=(long)a-(long)b;
    int k=(int)(cha>>>63); //无符号右移>>>(不论正负,高位均补0)
    System.out.println(k);
	return a*(k^1)+b*k;     
}
/*
 * 面试题 16.17. 连续数列
 */
public int maxSubArray(int[] nums) {
	int max=Integer.MIN_VALUE;
	int i=0,sum=0;
	while (i<nums.length) {
		if (sum+nums[i]<nums[i]) {
			sum=0;
		}
		sum+=nums[i];
		if (sum>max) {
			max=sum;
		}
		i++;
	}	
	return max;  
}
/*
 * 面试题 17.10. 主要元素
 */
public int majorityElement(int[] nums) {
	Arrays.sort(nums);
	int i=0,j=nums.length-1;
	while(nums[i]!=nums[nums.length/2]) i++;	
	while(nums[j]!=nums[nums.length/2]) j--;
	return j-i-1>nums[nums.length/2]?nums[nums.length/2]:-1;  
}


	public static void main(String[] args) {
		String first = " ";
		String second = "";
		System.out.println(oneEditAway(first,second));

	}

}
