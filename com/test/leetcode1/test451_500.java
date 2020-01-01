package com.test.leetcode1;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntToDoubleFunction;



public class test451_500 {
	/**
	 * 453. 最小移动次数使数组元素相等
	 * @param nums
	 * @return
	 */
	public int minMoves(int[] nums) {
		int min=nums[0];
		int len=0;
	for (int i = 1; i < nums.length; i++) {
		if (min>nums[i]) {
			min=nums[i];
		}
	}
	for (int i = 0; i < nums.length; i++) {
		len+=nums[i]-min;
	}
		return len;
	    
	}
/*
 * 455. 分发饼干	
 */
	 public int findContentChildren(int[] g, int[] s) {
		int child = 0;
		int cookie = 0;
		int tmp = 0;
		// 升序排序孩子胃口
		for (int i = 0; i < g.length; i++) {
			for (int j = i + 1; j < g.length; j++) {
				if (g[i] > g[j]) {
					tmp = g[i];
					g[i] = g[j];
					g[j] = tmp;
				}
			}
		}
		// 升序排序小饼干尺寸
		for (int i = 0; i < s.length; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i] > s[j]) {
					tmp = s[i];
					s[i] = s[j];
					s[j] = tmp;
				}
			}
		}
		while (child < g.length && cookie < s.length) { // 当其中一个遍历就结束
			if (g[child] <= s[cookie]) { // 当用当前饼干可以满足当前孩子的需求，可以满足的孩子数量+1
				child++;
			}
			cookie++; // 饼干只可以用一次，因为饼干如果小的话，就是无法满足被抛弃，满足的话就是被用了
		}
		return child;
	}
/*
 * 459. 重复的子字符串
 */
 public boolean repeatedSubstringPattern(String s) {
	 return s.length()>1&&(s+s).indexOf(s, 1)!=s.length();       
   }
 
/*
 * 461. 汉明距离
 */
 public int hammingDistance(int x, int y) {
	    int z = x ^ y;
		int sum = 0;
		while (z!=0){
			sum += z & 1;
			z = z>>1;
		}
		return sum;   
	    }
	/*
	 * 463. 岛屿的周长 有点繁琐，但结果正确
	 */
	 public static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		// 0,0位置的情况
		if (grid[0][0] != 0) {
			perimeter += 4;
		}
		// 0，j位置的情况
		for (int j = 1; j < grid[0].length; j++) {
			if (grid[0][j] != 0) {
				perimeter += 4;
				if (grid[0][j - 1] != 0) {
					perimeter -= 2;
				}
			}
		}
		// i,0位置的情况
		for (int i = 1, j = 0; i < grid.length; i++) {
			if (grid[i][0] != 0) {
				perimeter += 4;
				if (grid[i - 1][0] != 0) {
					perimeter -= 2;
				}
			}
		}
		// i,j位置的情况
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					perimeter += 4;
					if (grid[i][j - 1] != 0) {
						perimeter -= 2;
					}
					if (grid[i - 1][j] != 0) {
						perimeter -= 2;
					}
				}
			}
		}

		return perimeter;
	}
/*
 * 476. 数字的补数
 */
	public static int findComplement(int num) {
		int tmp = 1;
		//使得tmp为全1
        while (tmp < num)
        {
            tmp <<= 1;
            tmp += 1;
        }
        return (tmp^num);
	}
/*
 * 482. 密钥格式化
 */
	 public static String licenseKeyFormatting(String S, int K) {	    
		 S = S.replaceAll("-", "").toUpperCase();
	        int len = S.length();
	        if(len ==0 ) {
	            return "";
	        }
			int remain =len % K;
			int times = len / K;
			StringBuilder sb = new StringBuilder();
			if(remain != 0) {
				sb.append(S.substring(0, remain)+"-");
			}
			while(times>0) {
				sb.append(S.substring(len-times*K, len-times*K+K)+"-");
				times--;
			}
	        return sb.toString().substring(0, sb.toString().length()-1);		 
	    }
	 
	 
/*
 * 485. 最大连续1的个数	 
 */	 
public static int findMaxConsecutiveOnes(int[] nums) {
	int count=0;
	int max=0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i]==1) {
			count++;			
		}	
		if (nums[i]==0) {
			count=0;
		}
		if (max<count) {
			max=count;			
		}
	}	
		return max;
	        
 }

/*
 * 492. 构造矩形
 */
public int[] constructRectangle(int area) {
	int [] LW=new int[2];
	LW[0]=(int)Math.sqrt(area);
	while (area%LW[0]!=0) {
			LW[0]--;
		}
		LW[1]=area/LW[0];	
		if (LW[1]>LW[0]) {
			int tmp=LW[0];
			LW[0]=LW[1];
			LW[1]=tmp;
		}
	return LW;   
}
/*
 * 496. 下一个更大元素 I
 */
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	int[] result = new int[nums1.length];
	for (int i = 0; i < nums1.length; i++) {
		for (int j = 0; j < nums2.length; j++) {
			if (nums1[i]==nums2[j]) {
				result[i]=-1;
				for (int j2 = j+1; j2 < nums2.length; j2++) {
					if (nums2[j2]>nums2[j]) {
						result[i]=nums2[j2];						
					}
				}				
			}
		}
	}
	return result;    
}

/*
 * 500. 键盘行
 */
public String[] findWords(String[] words) {
	if(words==null||words.length==0) return new String[0];
    //用长度为26的数组标识每个字母所在的行号
    int[] map = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
    List<String> list = new ArrayList<String>();
    for(String word:words){
        int temp = map[word.toUpperCase().charAt(0)-65];
        boolean flag = true;
        //通过与首字母比较行号确定是否在同一行
        for(int i=1;i<word.length();i++){
            if(temp != map[word.toUpperCase().charAt(i)-65]){
                flag = false;
                break;
            }
        }
        if(flag) list.add(word);
    }
    return list.toArray(new String[list.size()]);    
}
	
	public static void main(String[] args) {
		int nums = 100;

	}

}
