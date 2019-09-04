package com.test.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1001_1050 {
/*
 * 1002. 查找常用字符 little difficult
 */
public List<String> commonChars(String[] A) {
	List<String> list = new ArrayList<>();
	int[] res = new int[26];
	//找交集
    for (char ch : A[0].toCharArray()) {
        res[ch - 'a']++;
    }
	for (int i = 1; i < A.length; i++) {
		int[] tmp=new int[26];
		for (char ch:A[i].toCharArray()) {
			tmp[ch-'a']++;
		}
		for (int j = 0; j < 26; j++) {
			res[j] = Math.min(res[j], tmp[j]);
		}
	}
	for (int i = 0; i < res.length; i++) {
        if (res[i] > 0) {
            for (int j = 0; j < res[i]; j++) {
                list.add(((char) ('a' + i) + ""));
            }
        }
    }
	return list;           
    }
/*
 * 1005. K 次取反后最大化的数组和
 */
public static int largestSumAfterKNegations(int[] A, int K) {
	//将数组升序排序
	Arrays.sort(A);
	int sum=0;
	int i=0;
	while (K>0) {
		//如果数组的数小于0，先尽可能的转换成大于0的数。
		if (A[i]<0) {
			A[i]=-A[i];
			i++;
			K--;
		}else {
		//如果数组中的负数已经全部转换成了正数，那就对数组再升序排序一次
			Arrays.sort(A);
			break;
		}			
	}
	//由于现在数组中全部是正数，所以只用对最小值下手就行了。
	if (K%2!=0) {
		A[i]=-A[i];
	}
	for (int j = 0; j < A.length; j++) {
		sum+=A[j];
	}
	return sum;    
}	

/*
 * 1009. 十进制整数的反码
 */
public static int bitwiseComplement(int N) {
	String nString = Integer.toBinaryString(N);
	String res="";
	for (int i = 0; i < nString.length(); i++) {
		if (nString.charAt(i)=='0') {
			res+="1";
		}else {
			res+="0";
		}
	}
	return Integer.parseInt(res, 2);    
}
	/**
	 * 1047. 删除字符串中的所有相邻重复项
	 * @param args
	 */
	public static  String removeDuplicates(String S) {
		StringBuilder a=new StringBuilder();
	    for(int i=0;i<S.length();i++){
	        if(a.length()==0){
	            a.append(S.charAt(i));
	        }else if(a.charAt(a.length()-1)==S.charAt(i)){
	            a.delete(a.length()-1,a.length());
	        }else{
	            a.append(S.charAt(i));
	        }
	    }
	    return  a.toString();
		
	}	
	
	public static void main(String[] args) {
		int[] A= {4,2,3};
		int K=1;
		bitwiseComplement(5);

	}

}
