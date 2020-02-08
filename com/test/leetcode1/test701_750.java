package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test701_750 {

/*
 *703. 数据流中的第K大元素 
 */
	List<Integer> relist = new ArrayList<>();
	int k;
	public test701_750(int k, int[] nums) {
		this.k = k;
		for (int i = 0; i < nums.length; i++) {
			relist.add(nums[i]);
		}
		Collections.sort(relist);	
    }
    public int add(int val) {
    	relist.add(val);
    	Collections.sort(relist);  	
		return relist.get(relist.size()-k);    
    }
/*
 * 704. 二分查找
 */
public static int search(int[] nums, int target) {
	int left = 0,right = nums.length-1;
	int middle;
	while (left<=right) {
	  middle=left+(right-left)/2;
	  if (nums[middle]==target) {
		return middle;
	}
	  if (nums[middle]>target) {
		right=middle-1;
	}
	  if (nums[middle]<target) {
		left=middle+1;
	}		
	}	
	return -1;        
    }
/*
 * 706. 设计哈希映射
 */
List<int []> list;
/** Initialize your data structure here. */
public test701_750() {
	list= new ArrayList<>();
}

/** value will always be non-negative. */
public void put(int key, int value) {
	remove(key);
	int s[] = new int[2];
	s[0] = key;
	s[1] = value;
	list.add(s);	
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
public int get(int key) {
	for (int[] s:list) {
		if (s[0]==key) {
			return s[1];
		}
	}
	return -1;   
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */
public void remove(int key) {
	for (int[] s:list) {
		if (s[0]==key) {
			list.remove(s);
			break;
		}
	} 
}
/*
 * 709. 转换成小写字母
 */
public static  String toLowerCase(String str) {
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)>='A'&&str.charAt(i)<='Z') {
			str=str.replace(str.charAt(i), (char) (str.charAt(i)+32));
		}
	}	
	return str;    
}
/*
 * 717. 1比特与2比特字符
 */
public boolean isOneBitCharacter(int[] bits) {
	      int start = 0 ;
	        while(start<bits.length-1){
	            if(bits[start] == 0){
	                start++;
	            }else{
	                start+=2;
	            }
	        }
	        return start == bits.length-1;  
}
/*
 * 720. 词典中最长的单词
 */
public String longestWord(String[] words) {
	//对数组排序，再利用Set对字母存储，小的单词一定包含在后面大的单词里面。后面只需要取前缀相同的
    //对字母排序后，第一个单词一定是共有的，后面只需在此基础上添加
    Arrays.sort(words);
    Set<String> set = new HashSet<>();
    String res = "";
    for (String s : words) {
        //如果单词只有一个字母，那一定是共有的
        if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
            res = s.length() > res.length() ? s : res;
            set.add(s);
        }
    }
    return res;
}
/*
 * 722. 删除注释
 */
public List<String> removeComments(String[] source) {
	List<String> list = new ArrayList<>();
	String ss = "";
	int flag=0;
	for (int i = 0; i < source.length; i++) {
		if (flag!=1) ss=source[i];
		for (int j = 0; j < source[i].length()-1; j++) {
			String chs =source[i].substring(j, j+2);			
			if (chs.equals("//")&&flag!=1) { // 如果出现//并且前面没有块注释/*，那就只保留//前面的部分
				ss=ss.substring(0, ss.indexOf("//"));
				break;				
			}else if (source[i].substring(j, j+2).equals("/*")&&flag!=1) { //如果出现块注释/*，并且前面没有块注释/*
				ss=ss.substring(0, ss.indexOf("/*"));
				System.out.println("head:"+source[i].substring(0, j)+"---");
				flag=1;	
				j++;				
				continue;
			}else if (source[i].substring(j, j+2).equals("*/")&&flag==1) { //如果出现块注释，并且前面有/*
                ss+=source[i].substring(j+2);
				//System.out.println("tail:"+source[i].substring(j+2)+"----");				
				flag=0;
				j++;	
				continue;
			}
		}
		if (!ss.equals("")&&flag==0) {
			list.add(ss);
		}
	}
	return list;       
}

/*
 * 724. 寻找数组的中心索引
 */
public int pivotIndex(int[] nums) {
	int sum=0,newsum=0;
	for (int i = 0; i < nums.length; i++) {
		sum+=nums[i];
	}
	for (int i = 0; i < nums.length; i++) {		
		if ((newsum*2+nums[i])==sum) {
			return i;
		}
		newsum+=nums[i];
	}
	
	return -1;
    
}
/*
 * 728. 自除数
 */
public static List<Integer> selfDividingNumbers(int left, int right) {
	List<Integer> list = new ArrayList<>();
	for (int i = left; i <= right; i++) {
		String iString = String.valueOf(i);
		int j=0;
		while (j<iString.length()) {
			if (iString.charAt(j)=='0'||i%Integer.parseInt(String.valueOf(iString.charAt(j)))!=0) {
				break;
				
			}else {
				j++;
			}			
		}
		if (j==iString.length()) {
			list.add(i);
		}
		}
	return list;   
}

/*
 * 733. 图像渲染
 */
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	int orign_color = image[sr][sc];
	fillNewColor(image, sr, sc, orign_color, newColor);
	return image;      
}
public void fillNewColor(int[][] image, int sr, int sc,int orign_color, int newColor) {
	if (image[sr][sc]==newColor||image[sr][sc]!=orign_color) {
		return;
	}
	image[sr][sc] = newColor;	
	if (sr>0) {
		fillNewColor(image, sr-1, sc, orign_color, newColor);
	}
	if(sr<image.length-1) {
		fillNewColor(image, sr+1, sc, orign_color, newColor);
	}
	if (sc>0) {
		fillNewColor(image, sr, sc-1, orign_color, newColor);
	}
	if (sc<image[0].length-1) {
		fillNewColor(image, sr, sc+1, orign_color, newColor);
	}	
}
/*
 * 744. 寻找比目标字母大的最小字母
 */
public char nextGreatestLetter(char[] letters, char target) {
	for (int i = 0; i < letters.length-1; i++) {
		if (letters[i]<=target&&letters[i+1]>=target) {
			return letters[i+1];
		}
	}	
	return letters[0];    
}

/*
 * 746. 使用最小花费爬楼梯
 */
public int minCostClimbingStairs(int[] cost) {
	//动态规划的做法
	int len =cost.length;
    int[] dp=new int[len];
    dp[0]=cost[0];
    dp[1]=cost[1];   
    for(int i=2;i<len;i++){
        dp[i]=Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
    }  
    return Math.min(dp[len-1],dp[len-2]);
}
/*
 * 747. 至少是其他数字两倍的最大数
 */
public int dominantIndex(int[] nums) {
	if (nums.length<2) {
		return 0;
	}
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
		map.put(nums[i], i);
	}
	Arrays.sort(nums);
	if (nums[nums.length-1]>=nums[nums.length-2]*2) {
		return map.get(nums[nums.length-1]);
	}
	return -1;   
}

/*
 * 748. 最短完整词
 */
public static String shortestCompletingWord(String licensePlate, String[] words) {
	List<Character> list = new ArrayList<>();
	licensePlate=licensePlate.toLowerCase();//将牌照中的大写字母转换成小写
    //将牌照中的字母放到list集合中
	for (int i = 0; i < licensePlate.length(); i++) {
		if (licensePlate.charAt(i)>='a'&& licensePlate.charAt(i)<='z') {
			list.add(licensePlate.charAt(i));
		}
	}
	int wordlength=Integer.MAX_VALUE;
	String result="";
	for (int i = 0; i < words.length; i++) {
		List<Character> list2=new ArrayList<>(list);
        //牌照中包含word字母，就把牌照中对应字母删除
		for (int j = 0; j < words[i].length(); j++) {
			list2.remove((Character)words[i].charAt(j));
		}
        //最终牌照中的字母全部被删除，说明words中的该单词包含牌照中的所有字母，并记录短长度的单词
		if (list2.size()==0&&words[i].length()<wordlength) {
			result=words[i];
			wordlength=words[i].length();
		}		
	}	
	return result;   
}
	public static void main(String[] args) {	
		String licensePlate = "Ah71752";
		String[] words= {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
		System.out.println(shortestCompletingWord(licensePlate,words));
	}

}
