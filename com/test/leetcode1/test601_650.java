package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class test601_650 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	/*
	 * 605. 种花问题
	 */
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		String ss ="";
		ss="0"+ss;
		for (int i = 0; i < flowerbed.length; i++) {
			ss+=flowerbed[i];
		}
		ss+="0";
		System.out.println(ss);
		int k=0;
		while (k<ss.length()-3) {
			if (ss.substring(k, k+3).equals("000")) {
				n-=1;
				k+=3;
		}else {
			k++;
		}	
			
		}
		return n==0?true:false;
	    
	}
/*
 * 606. 根据二叉树创建字符串	
 */
	@Test
	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		String ss = String.valueOf(t.val);
		if (t.left != null || t.right != null) {
			ss += "(" + tree2str(t.left) + ")";
			if (t.right != null) {
				ss += "(" + tree2str(t.right) + ")";
			}

		}
		return ss;
	}
/*
 * 609. 在系统中查找重复文件
 */
public List<List<String>> findDuplicate(String[] paths) {
	List<List<String>> list = new ArrayList<List<String>>();
	Map<String, Integer> map = new HashMap<String, Integer>();
	int index = 0;
	for (String str : paths) {
		String[] strs = str.split(" ");
		for (int i = 1; i < strs.length; i++) {
			String key = strs[i].substring(strs[i].indexOf("(") + 1, strs[i].indexOf(")"));
			if (!map.containsKey(key)) {
				map.put(key, index++);
				list.add(new ArrayList<String>());
			}
			list.get(map.get(key)).add(strs[0] + "/" + strs[i].substring(0, strs[i].indexOf("(")));
		}
	}
	for (int i = list.size() - 1; i >= 0; i--) {
		if (list.get(i).size() < 2) 
			list.remove(i);
	}
	return list;      
  }
/*
 * 617. 合并二叉树
 */
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	if (t1 == null) {
        return t2;
    }
    if (t2 == null) {
        return t1;
    }
    // 先合并根节点
    t1.val += t2.val;
    // 再递归合并左右子树
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;       
    }

/*SQL
 * 620. 有趣的电影
 */
/*SQL
 * 627. 交换工资
 */

/*
 * 628. 三个数的最大乘积
 */
public int maximumProduct(int[] nums) {
	Arrays.sort(nums);
	return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1]);
    
}
/*
 * 633. 平方数之和
 */
public boolean judgeSquareSum(int c) {
	if (c==1||c==0) {
		return true;
	}
	int i=0;
	int j = (int) Math.sqrt(c);
	while (i<=j) {
		int sum = i*i+j*j;
		if (sum>c) {
			j--;
		}
		if (sum<c) {
			i++;
		}if (sum==c) {
			return true;
		}		
	}
	return false;   
}
/*
 * 637. 二叉树的层平均值 层次遍历
 */
public List<Double> averageOfLevels(TreeNode root) {
	List<Double> list = new ArrayList<>();
	if (root==null) {
		return list ;
	}	
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);	
	while (!queue.isEmpty()) {
		double sum=0;
		int size = queue.size();
		for (int i = 0; i < size; i++) {
		TreeNode currentNode = queue.poll();		 
		if (currentNode.left!=null) 
			queue.add(currentNode.left);		
		if (currentNode.right!=null) 
			queue.add(currentNode.right);
		sum+=currentNode.val;
		}
	list.add((sum*1.0d)/size);		
	}
	return list;   
}
/*
 * 643. 子数组最大平均数 I
 */
public double findMaxAverage(int[] nums, int k) {
	double max=0;
	for (int i = 0; i < k; i++) {
		max+=nums[i]; 
	}	
	for (int i = 1; i < nums.length-k; i++) {
		double tmp=0;
		for (int j = i; j < i+k; j++) {
			tmp+=nums[j];
		}
		max=Math.max(max, tmp/k);
	}
	return max;
    
}



/*
 * 645. 错误的集合
 */
public int[] findErrorNums(int[] nums) {
	int[] res = new int[2];
	int newsum=0;
	Arrays.sort(nums);
	for (int i = 0; i < nums.length-1; i++) {
		if (nums[i]==nums[i+1]) {
			res[0]=nums[i];
		}
		newsum+=nums[i];		
	}
	newsum+=nums[nums.length-1];
	res[1]=res[0]-(newsum-((1+nums.length)*nums.length)/2);	
	return nums;   
}
/*
 * 647. 回文子串
 */
public int countSubstrings(String s) {
	int count=0;
	for (int i = 1; i <= s.length(); i++) {		
		for (int j = 0; j < s.length()+1-i; j=j+1) {
			if (ishuiwenchuan(s.substring(j, j+i))) {
				count+=1;
			}
		}
	}
	return count;    
}
//判断是否回文串
public boolean ishuiwenchuan(String t) {
	for (int i = 0; i < t.length()/2; i++) {
		if (t.charAt(i)!=t.charAt(t.length()-1-i)) {
			return false;
		}
	}
	return true;
}

	public static void main(String[] args) {
		int[][] nums = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
		//imageSmoother(nums);
	}

}
