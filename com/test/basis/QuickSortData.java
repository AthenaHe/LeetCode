package com.test.basis;

import java.util.Arrays;
/*
 * 实现快速排序
 * 时间复杂度  平均（nlogn） 最好（nlogn） 平均（nlogn）最坏（n2） 
 * 空间复杂度 （nlogn）
 * 不稳定
 */
public class QuickSortData {

	public static void main(String[] args) {
		int[] data = {3,4,2,6,9,10,2,1};
		System.out.println("排序之前的数据："+Arrays.toString(data));
		quicksort(data);
		System.out.println("排序之后的数据："+Arrays.toString(data));

	}
	
	public static void quicksort(int[] data) {
		if (data.length!=0) {
			subSort(data,0,data.length-1);
		}		
	}
	
	public static void subSort(int[] data,int start,int end) {
		if (start<end) {
			int base=data[start]; //将排序的第一个数作为基准
			int i=start+1,j=end;
			while(i<j) {
				while(i<end&&data[i]<=base) i++;
				while(j>start&&data[j]>=base) j--;
				if (i<j) {
					//将data[i]与data[j]交换
					int tmp=data[i];
					data[i]=data[j];
					data[j]=tmp;
				}
			}
			//将data[start]与data[j]交换
			int tmp=data[start];
			data[start]=data[j];
			data[j]=tmp;
			
			subSort(data, start, j-1);
			subSort(data, j+1, end);
		}
	}

}
