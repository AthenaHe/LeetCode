package com.test.leetcode2;

public class test1001_1050 {
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
		
	}	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
