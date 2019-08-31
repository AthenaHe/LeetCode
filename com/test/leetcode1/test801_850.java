package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class test801_850 {
public class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}
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
 * 836. 矩形重叠 不懂不懂	
 */
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	return !(rec1[2] <= rec2[0] ||   // left
            rec1[3] <= rec2[1] ||   // bottom
            rec1[0] >= rec2[2] ||   // right
            rec1[1] >= rec2[3]);    // top
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
/*
 * 852. 山脉数组的峰顶索引 so easy
 */
public int peakIndexInMountainArray(int[] A) {
for (int i = 0; i < A.length-1; i++) {
		if (A[i]>A[i+1]) {
			return i;
		}
	}
return 0;  
}
/*
 * 859. 亲密字符串
 */
public boolean buddyStrings(String A, String B) {
	//1.如果A，B长度不相等或者都是空串，不满足条件
	if (A.length()!=B.length()||(A.length()==0&&B.length()==0)) {
		return false;
	}
	
	Set<Character> set = new HashSet<>();
	for (int i = 0; i < A.length(); i++) {
		set.add(A.charAt(i));
	}
	//2.如果A等于B，并且A中有重复字符，说明可以交换重复字符，满足条件
	if (A.equals(B)&&set.size()<A.length()) {
		return true;
	}
	//3.1 如果A中只有2个字符位置和B不同，继续判断
	List<Character> alist = new ArrayList<Character>();
	List<Character> blist = new ArrayList<Character>();
	int count=0;
	for (int i = 0; i < A.length(); i++) {
		if (A.charAt(i)!=B.charAt(i)) {
			count++;
			if (count<=2) {
			alist.add(A.charAt(i));
			blist.add(B.charAt(i));
			}else {
				return false;
			}						
		}				
	}
	//3.2 如果A中2个不同字符正好与B相反，则满足条件。
	if (alist.size()==2&&blist.size()==2) {
		return alist.get(0)==blist.get(1)&& alist.get(1)==blist.get(0);
	}
	return false;	
}
/*
 * 860. 柠檬水找零
 */
public boolean lemonadeChange(int[] bills) {
	//0.如果第一个收到的不是5元，并且后面还有顾客要买，那么游戏over
	if (bills.length>1&&bills[0]!=5) {
		return false;
	}
	int five = 1;//假装收到了第一位顾客的5块钱
    int ten = 0;
    for (int i = 1; i < bills.length; i++) {
        switch (bills[i]) {
            case 5: //1.收到了5块钱，不找零
                five++;
                break;
            case 10:	//2.收到了10块钱
                if (five > 0) { //找零一张5元
                    five--;
                    ten++;
                } else {
                    return false;
                }
                break;
            case 20:  //3.收到了20块钱，先尽量把10元找出去，5元尽量留着
                if (five > 0 && ten > 0) { //3.1找零一张5元，一张10元
                    five--;
                    ten--;
                } else if (five >= 3) { //3.2找零3张5元
                    five -= 3;
                } else {
                    return false;//(最好不要收到20块，20块只能自己留着了，因为没有机会找零出去的)
                }
                break;
        }
    }
    return true;    
}
/*
 * 867. 转置矩阵
 */
public int[][] transpose(int[][] A) {
	int[][] B = new int[A[0].length][A.length];
	for (int i =0; i < A.length; i++) {
		for (int j = 0; j < A[i].length; j++) {
			B[j][i] = A[i][j];
		}
	}
	return B;
}
/*
 * 868. 二进制间距
 */
public static int binaryGap(int N) {
	String str = Integer.toBinaryString(N);
	int i=0,j=0,max=0;
	while (i<str.length()) {
		if (str.charAt(i)=='1') {
			max = Math.max(max, i-j);
			j=i;	
		}
		i++;		
	}
	return max;    
}
/*
 * 876. 链表的中间结点
 */
public ListNode middleNode(ListNode head) {
	ListNode slow=head;
	ListNode fast = head;
	while (fast!=null&&fast.next!=null) {
		slow=slow.next;
		fast=fast.next.next;
		
	}	
	return slow;
    
}
	public static void main(String[] args) {
	int[] commands = {4,-1,4,-2,4}; 
	int[][] obstacles = {{2,4},{3,5}};
	
	System.out.println(-5%4);
	}

}
