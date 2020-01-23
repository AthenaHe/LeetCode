package com.test.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class test051_100 {
	//链表结构体定义
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }	
	  //树结点定义
		public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	/**
	 * 53. 最大子序和
	 * 
	 * 当到达一个位置时，如果此时的子序列之和小于 0 的话，那么从当前位置开始的新子序列一定比保留原来的子序列的和更大。
		递推公式：dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		//动态规划法
		if(nums.length == 0) 
			return 0;
	    int max = nums[0];
	    int cur = nums[0];
	    for(int i = 1; i < nums.length; i ++) {
	        if(cur < 0) {
	            cur = nums[i];
	        } else {
	            cur += nums[i];
	        }
	        
	        max = Math.max(cur, max);
	    }
	    
	    return max;
	}
	
	/**
	 * 58. 最后一个单词的长度
	 * @param args
	 */
	public static int lengthOfLastWord(String s) {
	    String[] words=s.split(" ");
	    if (words.length==0 || words[words.length-1].length()==0) {
			return 0;
		}
	    else {
			return words[words.length-1].length();
		}
	}
/*
 *59. 螺旋矩阵 II 
 */
public int[][] generateMatrix(int n) {
	int step=1;
	int left=0,right=n-1,top=0,bottom=n-1;
	int[][] res=new int[n][n];
	while (step<=n*n) {
	//→
	for (int i = left; i < right; i++) res[top][i]=step++;
	top++;
	//↓
	for (int i = top; i < bottom; i++) res[i][right]=step++;
	right--;
	//←
	for (int i = right; i >=left; i--) res[bottom][i]=step++;
	bottom--;
	//↑
	for (int i = bottom; i >=top; i--) res[i][left]=step++;
	left++;
	}
	return res;       
    }
	/**
	 * 66.加一
	 * @param args
	 */
	public  static int[] plusOne(int[] digits) {
		for(int i = digits.length - 1; i >= 0; i --) {
	        if(digits[i] != 9) {
	            digits[i] ++;
	            return digits;
	        }
	        
	        digits[i] = 0;		
	    }    
		digits = new int[digits.length + 1];
		digits[0] = 1;
	    return digits;
	        
	    } 
/*
 * 67.二进制求和
 */
  public String addBinary(String a, String b) { 
	 StringBuffer sb = new StringBuffer();
	 int i=a.length()-1,j=b.length()-1,carry=0;
	 while (i>=0||j>=0||carry!=0) {
		if (i>=0) {
			carry+=(a.charAt(i--)-'0');
		}
		if (j>=0) {
			carry+=(a.charAt(j--)-'0');			
		}
		sb.append(carry%2);
		carry=carry/2;
		
	}
	  return sb.reverse().toString();  
  }	
	
	/**
	 * 69. x 的平方根
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		
//		for (int i = 1; i <= x/2; i++) {	
//			if ((i<=x/i)&&((i+1)>x/(i+1))) {
//				return i;
//			}		
//		}	
//		return x;
		//不懂
		if (x <= 1) {
			return x;
		}
		int l = 1;
		int r = x / 2;
		while (true) {
			int m = l + (r - l) / 2;//⌊(√x)⌋≤(⌊x/2⌋+1)，
			if (m > x / m) {
				r = m - 1;
			} else if (m + 1 > x / (m + 1)) {
				return m;
			} else {
				l = m + 1;
			}
		}
	    
	}


	/**
	 * 70 ，爬楼梯
	 * @param args
	 */
	public int climbStairs(int n) {
	    if(n<=2){
	        return n;
	    }
	    int f1 = 1;
	    int f2 = 2;
	    for(int i=3;i<=n;i++){
	        int temp = f1+f2;
	        f1 = f2;
	        f2 = temp;
	    }
	    return f2;
	}

/*
 *78. 子集 
 */
public List<List<Integer>> subsets(int[] nums) {
	//可以直接从后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
	List<List<Integer>> lists = new ArrayList<>();
	lists.add(new ArrayList<>());
	for (int i = 0; i < nums.length; i++) {
		int len=lists.size();
		for (int j = 0; j < len; j++) {
			List<Integer> list = new ArrayList<>(lists.get(j));
			list.add(nums[i]);
			lists.add(list);
		}
	}
	return lists;       
    }
	/**
	 * 83. 删除排序链表中的重复元素
	 * @author hehuan
	 *
	 */

	    public ListNode deleteDuplicates(ListNode head) {
	    	if (head==null) {
				return null;
			}
	    	ListNode listnode = head;
	    	while (listnode.next!=null) {
				if (listnode.val == listnode.next.val) {
					listnode.next=listnode.next.next;
				}else {
					listnode = listnode.next;
				}
				
	    	}
			return head;
	        
	    }
	/**
	 * 88. 合并两个有序数组
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public  static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k=m+n-1;
	    //从后向前遍历
		while (i>=0&&j>=0) {
			if (nums1[i]>nums2[j]) {
				nums1[k--] = nums1[i--];
			}else {
				nums1[k--] = nums2[j--];
			}		
		}	
		while (j>=0) {
			nums1[k--]=nums2[j--];		
		}
	}




	/**
	 * 100.相同二叉树
	 * @author hehuan
	 *
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {		
		if (p==null&&q==null) {
			return true;
		}
		if (p!=null&&q!=null && p.val==q.val) {
			boolean left= isSameTree(p.left, q.left);
			boolean right =isSameTree(p.right, q.right);
			return left&&right;
		}else {
			return false;
		}	
	    
	}

}
