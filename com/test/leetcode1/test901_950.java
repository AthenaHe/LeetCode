package com.test.leetcode1;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
