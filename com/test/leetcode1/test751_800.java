package com.test.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test751_800 {
public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
/*
 * 754. 到达终点数字
 */
public int reachNumber(int target) {
	target=Math.abs(target);
	int sum=0;
	int i=1;
	while(true) {
		sum+=i;
		if (sum>=target&&(sum-target)%2==0) {
			return i;
		}
		i++;  
	}
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
 * 783. 二叉搜索树结点最小距离
 */
private TreeNode pre = null;   //pre记录前一节点
private int res = Integer.MAX_VALUE;
public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
  }
//中序遍历
private void dfs(TreeNode root){
    if(root == null) return;
    dfs(root.left);
    if(pre != null){
        res = Math.min(root.val-pre.val,res);   //记录最小
    }
    pre = root;
    dfs(root.right);
}
/*
 * 784. 字母大小写全排列
 */
public List<String> letterCasePermutation(String S) {
	List<String> res = new ArrayList<>();
	S=S.toLowerCase();
	List<StringBuilder> tmpList = new ArrayList<>();
	tmpList.add(new StringBuilder());
	System.out.println(tmpList.size());
	for (int i = 0; i < S.length(); i++) {
		int size = tmpList.size();
		if (S.charAt(i)>='a'&&S.charAt(i)<='z') {
			for (int j = 0; j < size; j++) {
				tmpList.add(new StringBuilder(tmpList.get(j)));
				tmpList.get(j).append(S.charAt(i));
				tmpList.get(j+size).append(Character.toUpperCase(S.charAt(i)));
			}
			
		}else {
			for (int j = 0; j < size; j++) {
				tmpList.get(j).append(S.charAt(i));
			}
			
		}
	}
	for (StringBuilder sb:tmpList) {
		res.add(sb.toString());
	}	
	return res;	
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
 * 791. 自定义字符串排序
 */
public String customSortString(String S, String T) {
	Map<Character, Integer> map = new HashMap();
	for (int i = 0; i < T.length(); i++) {
		map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0)+1);
	}
	String res = "";
	for (int i = 0; i < S.length(); i++) {
		if (map.containsKey(S.charAt(i))) {
			for (int j = 0; j < map.get(S.charAt(i)); j++) {
				res+=S.charAt(i);
			}
			map.remove(S.charAt(i));
		}
	}
	//剩下的往后面添
	for (char ch:map.keySet()) {
		for (int i = 0; i < map.get(ch); i++) {
			res+=ch;
		}
	}
	return res;  
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
