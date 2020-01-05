package com.test.leetcode1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class test801_850 {
/*
 * 804. 唯一摩尔斯密码词
 */
public static  int uniqueMorseRepresentations(String[] words) {
	String[] mors = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	Set<String> set = new HashSet<String>();
	for (String word:words) {
		String tmp="";
		for (int i = 0; i < word.length(); i++) {
			tmp+=mors[word.charAt(i)-'a'];
		}
		set.add(tmp);
	}
	return set.size();   
}

/*
 * 806. 写字符串需要的行数
 */
public int[] numberOfLines(int[] widths, String S) {
	int[] res = new int[2];
	if (S.length()==0) {
	    return res;
	}
	res[1] = 0;
	res[0]=1;
	for (int i = 0; i < S.length(); i++) {
	    if (res[1]<=100) {
	    	res[1]+=widths[S.charAt(i)-'a'];
	    }
	    if (res[1]>100) {			
	    	res[1]=widths[S.charAt(i)-'a'];
	        res[0]+=1;
	    }
	}		
	return res;   
}

/*
 * 811. 子域名访问计数
 */
public List<String> subdomainVisits(String[] cpdomains) {
	List<String> list = new ArrayList<>();
	Map<String, Integer> map = new HashMap<String, Integer>();
	// 遍历每一组字符串
	for (int i = 0; i < cpdomains.length; i++) {
		// 将访问次数和域名分开存放
		String[] tmp = cpdomains[i].split(" ");
		// 访问次数
		int number = Integer.parseInt(tmp[0]);
		// 域名进行.分割(要转义)
		String[] domain = tmp[1].split("\\.");
		String tmp1 = "";
		// 从后往前遍历，最后一个域名不用加.,其余的要加.
		for (int j = domain.length - 1; j >= 0; j--) {
			if (j == domain.length - 1) {
				tmp1 += domain[j];
			} else {
				tmp1 = domain[j] + "." + tmp1;
			}
			// 如果map集合中没有该域名，就新增域名并加number，有该域名就在此基础上再加number
			map.put(tmp1, map.getOrDefault(tmp1, 0) + number);
		}
	}
	// 遍历map集合，map的key：域名，value：访问次数
	for (String res : map.keySet()) {
		list.add(map.get(res) + " " + res);
	}
	return list;
}
/*
 * 812. 最大三角形面积
 */
public  double largestTriangleArea(int[][] points) {
	int N = points.length;
    double ans = 0;
    for (int i = 0; i < N; ++i)
        for (int j = i+1; j < N; ++j)
            for (int k = j+1; k < N; ++k)
                ans = Math.max(ans, area(points[i], points[j], points[k]));
    return ans;
}

public double area(int[] P, int[] Q, int[] R) {
    return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                         -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
}
//求两点之间的边长
public static  double getLength(int[] point1,int[] point2) {
	return Math.sqrt(Math.pow(point1[0]-point2[0],2)+Math.pow(point1[1]-point2[1],2));
}

/*
 * 819. 最常见的单词
 */
public static String mostCommonWord(String paragraph, String[] banned) {
	// 将禁用单词放到list集合中
	List<String> list = new ArrayList<>();
	for (int i = 0; i < banned.length; i++) {
		list.add(banned[i]);
	}
	// paragraph单词们先转换为小写字母，按空格分割放到数组中
	String[] words = paragraph.toLowerCase().split(" ");
	// 把paragraph中的纯净单词放到map键值对中，键是单词，值是单词出现的次数
	Map<String, Integer> map = new HashMap<>();
	// 过滤掉单词中不是字母的符号,变成纯净的单词数组
	for (int i = 0; i < words.length; i++) {
		// System.out.println(":"+words[i]);
		String tmp = "";
		for (int j = 0; j < words[i].length(); j++) {
			if (words[i].charAt(j) >= 'a' && words[i].charAt(j) <= 'z') {
				tmp += words[i].charAt(j);
				// 如果最后一个是字母，要判断是否把tmp单词放到map中
				if (j == words[i].length() - 1) {
					if (!list.contains(tmp)) {
						map.put(tmp, map.getOrDefault(tmp, 0) + 1);
					}
				}
			} else {
				if (!list.contains(tmp)) {
					map.put(tmp, map.getOrDefault(tmp, 0) + 1);
				}
				tmp = "";
			}
		}
	}
	// 找到出现次数最多的单词
	int max = Integer.MIN_VALUE;
	String res = "";
	for (String word : map.keySet()) {
		if (max < map.get(word)) {
			max = map.get(word);
			res = word;
		}
	}
	return res;
}

/*
 * 821. 字符的最短距离
 */
public static int[] shortestToChar(String S, char C) {
	List<Integer> list = new ArrayList<>();
	for (int i = 0; i < S.length(); i++) {
		//根据第i个字符把字符串切成两半
		//左边的包含此字符，右边的包含此字符
		String left = S.substring(0, i+1);
		System.out.println(left);
		String right = S.substring(i);
		System.out.println(right);
		int lindex=Integer.MAX_VALUE,rindex=Integer.MAX_VALUE;
		if (left.lastIndexOf(C)!=-1) {
			lindex=left.length()-1-left.lastIndexOf(C);
		}		
		if (right.lastIndexOf(C)!=-1) {
			 rindex = right.indexOf(C);
		}
		list.add(Math.min(lindex,rindex));
	}
	//转换成数组返回
	int[] res = new int[list.size()];
	for (int i = 0; i < res.length; i++) {
		res[i] = list.get(i);
	}
	return res;	
}

/*
 * 824. 山羊拉丁文
 */
public String toGoatLatin(String S) {
	if (S.length()==0) {
		return null;
	}
	String res="";
	String[] words = S.split(" ");
	List<String> list = new ArrayList<>();
	list.add("a");list.add("e");list.add("i");list.add("o");list.add("u");
	list.add("A");list.add("E");list.add("I");list.add("O");list.add("U");
	for (int i=0;i<words.length;i++ ) {
		if (list.contains(words[i].substring(0, 1))) {
			words[i]=words[i].substring(1,words[i].length())+words[i].substring(0, 1);
		}
		words[i]+="ma";
		for (int j = 1; j <= i+1; j++) {
			words[i]+="a";
		}
	res+=words[i]+" ";
	}
	return res.trim();
    
}
	/*
	 * 832. 翻转图像
	 */
	public static int[][] flipAndInvertImage(int[][] A) {
		int tmp = 0;
//先水平翻转
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length / 2; j++) {
				tmp = A[i][j];
				A[i][j] = A[i][A[i].length - j - 1];
				A[i][A[i].length - j - 1] = tmp;
			}
		}
//再自己翻转
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 0) {
					A[i][j] = 1;
				} else {
					A[i][j] = 0;
				}

			}
		}
		for (int i1 = 0; i1 < A.length; i1++) {
			for (int j = 0; j < A[i1].length; j++) {
				System.out.print(A[i1][j] + ",");
			}
			System.out.println();
		}
		return A;
}
/*
 * 830. 较大分组的位置	
 */
public static List<List<Integer>> largeGroupPositions(String S) {
	List<List<Integer>> lists = new ArrayList<>();
	int i=0;
	while (i<S.length()) {		
		int j=i;
		while (j<S.length()&&S.charAt(i)==S.charAt(j)) {
			j++;
		}
			if (j-i>=3) {
			List<Integer> list = new ArrayList<>();	
			list.add(i);
			list.add(j);
			lists.add(list);
			}				
	i=j;
}	
	return lists;        
 }
/*
 * 836. 矩形重叠 不懂不懂	
 */
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	return !(rec1[2] <= rec2[0] ||   // left
            rec1[3] <= rec2[1] ||   // bottom
            rec1[0] >= rec2[2] ||   // right
            rec1[1] >= rec2[3]);    // top
    }
/*
 * 840. 矩阵中的幻方
 */
public int numMagicSquaresInside(int[][] grid) {
	if (grid.length<3||grid[0].length<3) {
		return 0;
	}
	int count=0;
		for (int i = 1; i < grid.length-1; i++) {
			for (int j = 1; j < grid[0].length-1; j++) {
				if (grid[i][j]!=5) continue;
				if (isMagicSquare(grid, i, j)) {
					count++;
				}
			}
		}
	return count;	
}
public boolean isMagicSquare(int[][] grid,int i,int j) {
	Set<Integer> set = new HashSet<>();
	for (int p = i-1; p < i+2; p++) {
		for (int q = j-1; q < j+2; q++) {
			set.add(grid[p][q]);
		}
	}	
	if (set.size()!=9) {
		return false;
	}
	for (int k = 1; k <=9; k++) {
		if (!set.contains(k)) {
			return false;
		}
	}
	//行
	if (grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1]==15&&
		grid[i][j-1]+grid[i][j]+grid[i][j+1]==15&&
		grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1]==15&&
		grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1]==15&&
		grid[i-1][j]+grid[i][j]+grid[i+1][j]==15&&
		grid[i-1][j+1]+grid[i][j+1]+grid[i+1][j+1]==15&&
		grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1]==15&&
		grid[i+1][j-1]+grid[i][j]+grid[i-1][j+1]==15
		) return true;
	return false;	
}

/*
 * 844. 比较含退格的字符串 
 * 	第一眼就想到了栈
 */
public boolean backspaceCompare(String S, String T) {
	Stack<Character> Sstack = new Stack<>();
	Stack<Character> Tstack = new Stack<>();
	for (int i = 0; i < S.length(); i++) {
		if (S.charAt(i)!='#') {
			Sstack.push(S.charAt(i));
		}else if (S.charAt(i)=='#'&&!S.isEmpty()) {
			Sstack.pop();
		}	
	}
	for (int i = 0; i < T.length(); i++) {
		if (T.charAt(i)!='#') {
			Tstack.push(T.charAt(i));
		}else if (T.charAt(i)=='#'&&!T.isEmpty()) {
			Tstack.pop();
		}	
	}	
	return Sstack.equals(Tstack);    
}

/*
 * 849. 到最近的人的最大距离
 */
public static int maxDistToClosest(int[] seats) {
	int first=0,last=seats.length-1;
	while (seats[first]==0) {
		first++;
	}	
	while (seats[last]==0) {
		last--;
	}	
	int max=Math.max(first, seats.length-1-last);
	int num=0;
	while (first<=last) {
		if (seats[first++]==0) {
			num++;
		}else {
			if ((num+1)/2>max) {
				max=(num+1)/2;
			}
		num=0;
		}		
	}
return max;
}

	public static void main(String[] args) {
}
}
