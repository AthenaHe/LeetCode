package com.test.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test251_300 {
//树结点定义
		public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
/*
 * 257. 二叉树的所有路径
 */
public List<String> binaryTreePaths(TreeNode root) {
	List<String> list = new ArrayList<>();
	if (root==null) {
		return list;
	} 
	solve(root, "", list);
	return list;
 }
public void solve(TreeNode root,String cur,List<String> res) {
	if (root==null) {
		return;
	}
	cur+=root.val;
	if (root.left==null&&root.right==null) {
		res.add(cur);
	}else {
		solve(root.left, cur+"->", res);
		solve(root.right, cur+"->", res);
	}
}

	/**
	 * 258. 各位相加
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
//			int tmp;
//			while ((num / 10) != 0) {
//				tmp = num;
//				num = 0;
//				while (tmp != 0) {
//					num += tmp % 10;
//					tmp /= 10;
//				}
//			}
//			return num;
		if (num==0) {
			return 0;
		}
		    return num%9==0?9:num%9;		
		}

	/**
	 * 268. 缺失数字  有点不太懂
	 * @param nums
	 * @return
	 */
	public static  int missingNumber(int[] nums) {
		int res = nums.length;//为什么等于长度
		for (int i = 0; i < nums.length; i++) {
			res^=nums[i]^i;
		}
		return res;
	}
	/**
	 * 283. 移动零
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
//		int tmp;
//	    for (int i = 0; i < nums.length; i++) {
//			for (int j = i+1; j < nums.length ; j++) {
//				if (nums[i]==0&&nums[j]!=0) {
//					tmp = nums[i];
//					nums[i]=nums[j];
//					nums[j]=tmp;
//				}
//			}
//		}
		if (nums.length>1) {		
			int j = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i]!=0) {
					nums[j++]=nums[i];
				}
			}
			for (int i = j; i < nums.length; i++) {
				nums[i]=0;
			}		
		}	
	}
	
/*
 * 290.单词规律
 */
public static boolean wordPattern(String pattern, String str) {
	//k,v键值对
	Map<String, String> map = new HashMap<String, String>();
	String[] strArray = str.split(" ");
	if (pattern.length()!=strArray.length) {
		return false;
	}
	System.out.println(pattern.length()+","+strArray.length);
	for (int i = 0; i < pattern.length(); i++) {		
	//如果key存在
	if (map.containsKey(pattern.substring(i, i+1))) {
		//但是key对应的vaule不匹配,就失败
		if (!map.get(pattern.substring(i, i+1)).equals(strArray[i])) {
			return false;
		}
	//如果key不存在
	}else {
		if (map.containsValue(strArray[i])) {
			return false;			
		}else {
			map.put(pattern.substring(i, i+1),strArray[i]);
		}
	}		
}	
	return true;        
}

/*
 * 292. Nim 游戏
 */
public boolean canWinNim(int n) {	
	return n%4!=0;   
}
/*
 * 299. 猜数字游戏
 */
public static String getHint(String secret, String guess) {
	Map<Character, Integer> secretMap = new HashMap<>();
	Map<Character, Integer> guessMap = new HashMap<>();
	int Acount=0,Bcount=0;
	for (int i = 0; i < secret.length(); i++) {
		if (secret.charAt(i)==guess.charAt(i)) {
			Acount++;
		}else {
			secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0)+1);
			guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0)+1);			
		}		
	}
//	System.out.println("secret");
//	for (Character key:secretMap.keySet()) {
//		System.out.println(key+","+secretMap.get(key));
//	}
//	System.out.println("guess");
//	for (Character key:guessMap.keySet()) {
//		System.out.println(key+","+guessMap.get(key));
//	}	
	for (Character key:secretMap.keySet()) {
		if (guessMap.containsKey(key)) {
			
			//System.out.println(key+":"+guessMap.get(key)+","+secretMap.get(key)+","+Math.abs(guessMap.get(key)-secretMap.get(key)));
		Bcount+=Math.min(guessMap.get(key),secretMap.get(key));
		}
	}	
	return Acount+"A"+Bcount+"B";    
}

public static void main(String[] args) {
	String secret="1123";
	String guess="0111";
	System.out.println(getHint(secret, guess));
}


}
