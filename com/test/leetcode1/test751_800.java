package com.test.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class test751_800 {
public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
/*
 * 762. 二进制表示中质数个计算置位
 */
public static int countPrimeSetBits(int L, int R) {
	int sum=0;
	for (int i = L; i <=R; i++) {
		String ii=Integer.toBinaryString(i);
		int num=0;
		for (int j = 0; j < ii.length(); j++) {
			if (ii.charAt(j)=='1') {
				num++;
			}
		}
		//System.out.println(isPrime(num));
		if (isPrime(num)) {
			//System.out.println("num:"+num);
			sum++;
		}
	}	
	return sum;
        
    }
//判断数字是否为质数
public static boolean isPrime(int num) {
	if (num==1) {
		return false;
	}
	for(int i=2;i<=num/2;i++){
		if(num%i==0){
			return false;
		}
	}
	return true;	
}
/*
 * 766. 托普利茨矩阵
 */
public static boolean isToeplitzMatrix(int[][] matrix) {
	int row = matrix.length;
	int col = matrix[0].length;
	if (row==1) {
		return true;
	}
	for (int i = 1; i < row; i++) {
		for (int j = 1; j < col; j++) {
		if (matrix[i][j]!=matrix[i-1][j-1]) {
			return false;
		}	
		}
	}
	return true;  
}

/*
 * 771. 宝石与石头
 */
public static int numJewelsInStones(String J, String S) {
	List<Character> list = new ArrayList<>();
	int count=0;
	for (int i = 0; i < J.length(); i++) {
		list.add(J.charAt(i));
	}
	for (Character ch:list) {
		System.out.println(ch);
	}
	for (int i = 0; i < S.length(); i++) {
		if (list.contains(S.charAt(i))) {
			count++;
		}
	}
	return count;   
}
/*
 * 788. 旋转数字
 *每位都在(2, 5, 6, 9, 0, 1, 8)内，至少一位在(2, 5, 6, 9)内
*/
public int rotatedDigits(int N) {
	int count = 0;
    for (int i = 2; i <= N; i++) {
        String s = String.valueOf(i);
        s = s.replaceAll("[+0,+1,+8]", "");
        if (!"".equals(s)) {
            s = s.replaceAll("[+2,+5,+6,+9]", "");
            if ("".equals(s)) {
                count += 1;
            }
        }
    }
    return count;  
}

/*
 * 796. 旋转字符串
 */
public boolean rotateString(String A, String B) {
	if (A.length()==0&&B.length()==0) {
		return true;
	}
	for (int i = 0; i < A.length(); i++) {
		A=A.substring(1, A.length())+A.substring(0,1);
		if (A.equals(B)) {
			return true;
		}
	}	
	return false;   
}


	public static void main(String[] args) {
		String J = "aA";
		String S= "aAAbbbbb";
		System.out.println(numJewelsInStones(J,S));

	}

}
