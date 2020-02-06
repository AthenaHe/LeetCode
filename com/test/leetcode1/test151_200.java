package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class test151_200 {
public class ListNode {
	 int val;
	  ListNode next;
	  ListNode(int x) {
	      val = x;
	      next = null;
	  }
}
/*
 * 155. 最小栈
 */
class MinStack {
 /** initialize your data structure here. */
	private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int x) {
        if(min >= x){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    public int top() {
      return stack.peek();
    }
    public int getMin() {
        return min;
    }       
}
/**
 * 160. 相交链表
 */
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	/**
    定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
    两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
    **/
    if(headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
    while(pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;   
}
/*
 *165. 比较版本号 
 */
public int compareVersion(String version1, String version2) {
	int res=0,i=0;
	String[] v1 = version1.split(".");
	String[] v2 = version2.split(".");
	int len=Math.min(v1.length, v2.length);
	for ( i = 0; i < len; i++) {
		
		if (Integer.parseInt(v1[i])>Integer.parseInt(v2[i])) {
			res=1;
		}else {
			res=-1;
		}
	}
	if (i<=v1.length&&v1[i].equals("0")) {
		res=1;
	}else if(i<=v2.length){
		res=-1;
	}	
	return res;    
}

/**
 * 167. 两数之和 II - 输入有序数组 
 * @param numbers 
 * @param target
 * @return
 */
	public int[] twoSum2(int[] numbers, int target) {
		//二分法
		int[] index = new int[2];
		int i=0,j=numbers.length-1;
		while (i<j) {
			if (numbers[i]+numbers[j]>target) {
				j--;
			}else if (numbers[i]+numbers[j]<target) {
				i++;
			}else {
				index[0]=i+1;
				index[1]=j+1;
				break;
			}			
		}		
		return index;	    
	}
/*
 * 168. Excel表列名称
 */
public static String convertToTitle(int n) {
	if (n <= 0) {
        return "";
    }
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
        n--;
        sb.append((char) (n % 26 + 'A'));
        n =n / 26;
    }
    return sb.reverse().toString();       
}

	/**
	 * 	169. 求众数->出现次数大于数组元素长度的一半的数
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		if (nums[0] == nums[len / 2]) {
			return nums[0];
		} else if (nums[len-1] == nums[len / 2]) {
			return nums[len - 1];
		} else {
			return nums[len / 2];
		}
	}
/*
 * 171. Excel表列序号
 */
public int titleToNumber(String s) {
	int number = 0;
	for (int i = 0; i < s.length(); i++) {
		int tmp= s.charAt(i)-64;
		number=number*26+tmp;
	}
	return number;   
}
/*
 * 172.阶乘后的零
 */
public int trailingZeroes(int n) {
   //题目简化为查找阶乘中5的个数(分解后) 
	
	//不断除以 5, 是因为每间隔 5 个数有一个数可以被 5 整除, 
	//然后在这些可被 5 整除的数中, 每间隔 5 个数又有一个可以被 25 整除, 故要再除一次,
	//... 直到结果为 0, 表示没有能继续被 5 整除的数了.
	int count = 0;
	while(n/5!=0) {
		count+=n/5;
		n/=5;
	}
	return count;
    }

	/**
	 * 189. 旋转数组
	 * @param nums
	 * @param k
	 */
public static void rotate(int[] nums, int k) {
	 int tmp;
     for (int i = 0; i<k ; i++) {
    	 tmp = nums[nums.length-1];
    	 for (int j = nums.length-1; j > 0; j--) {
			nums[j]=nums[j-1];
		}
    	 nums[0]=tmp;  	 
	} 
     for (int i = 0; i < nums.length; i++) {
		System.out.print(nums[i]+",");
	}    
    }
/*
 * 190.颠倒二进制位
 */
public static int reverseBits(int n) {	
	
    return Integer.reverse(n);
}
/*
 * 191. 位1的个数
 */
public static int hammingWeight(int n) {
	String str =Integer.toBinaryString(n);
	int count=0;
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)=='1') 
			count++;
	}
	//Integer.bitCount(n);	
	return count;    
}



	/**
	 * 198. 打家劫舍
	 * @param nums
	 * @return
	 */
public  static int rob(int[] nums) {
	int n = nums.length;
    if (n <= 1) return n == 0 ? 0 : nums[0];
    int[] memo = new int[n];
    memo[0] = nums[0];
    memo[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++)
        memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
    return memo[n - 1];
}

public static void main(String[] args) {
	convertToTitle(128);
	
}
}
