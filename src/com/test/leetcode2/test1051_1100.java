package com.test.leetcode2;

import java.util.ArrayList;

public class test1051_1100 {
	/**
	 * 1051. 高度检查器
	 * @param heights
	 * @return
	 */
	public  static int heightChecker(int[] heights) {
		int tmp;
		//int[] res=heights;
		int[] res = new int[heights.length];
		for (int i = 0; i < res.length; i++) {
			res[i]=heights[i];
		}
		for (int i = 0; i < heights.length; i++) {
			
			for (int j = i+1; j < heights.length; j++) {
				if (heights[i]>heights[j]) {
					tmp=heights[i];
					heights[i]=heights[j];
					heights[j]=tmp;
				}
			}
		}
		tmp=0;
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]+"-----"+heights[i]);
			if (res[i]!=heights[i]) {
				tmp++;
			}
		}	
		return tmp;
	    
	}

	/**
	 * 1071. 字符串的最大公因子  xxx有问题，返回了空串
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String gcdOfStrings(String str1, String str2) {
		
		int len1 = str1.length();
	    int len2 = str2.length();
	    if (len1 == len2)
	    {
	        if (str1 == str2)
	            return str1;
	        else
	            return "";
	    }
	    else if (len1 > len2)
	    {
	        String substr = str1.substring(len2);
	        return gcdOfStrings(substr, str2);
	    }
	    else
	    {
	        String substr = str2.substring(len1);
	        return gcdOfStrings(substr, str1);
	    }
	}

	/**
	 * 1078. Bigram 分词
	 * @param text
	 * @param first
	 * @param second
	 * @return
	 */
	public String[] findOcurrences(String text, String first, String second) {
		String[] texts = text.split(" ");
	    ArrayList<String> result = new ArrayList<String>();
	    int x = 0;
	    for (int i = 0; i < texts.length - 2; i++) {
	        if (texts[i].equals(first) && texts[i + 1].equals(second)) {
	            result.add(texts[i + 2]);
	        }
	    }
	    return result.toArray(new String[result.size()]);
	}

	/**
	 * 1089. 复写零
	 * @param arr
	 */
	public static void duplicateZeros(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	    	if (arr[i]==0 && i+1<arr.length) {
				for (int j = arr.length-2; j > i; j--) {
					arr[j+1]=arr[j];
				}
				arr[i+1]=0;
				i++;
			}
	    	System.out.print(arr[i]+",");
	    		
		}
	    System.out.println();
	   for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
	}
}
