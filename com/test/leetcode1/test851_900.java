package com.test.leetcode1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test851_900 {
//链表结构体定义
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
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
    if (A.length()!=B.length()||(A.length()==0&&B.length()==0)) {
		return false;
	}
	
	Set<Character> set = new HashSet<>();
	for (int i = 0; i < A.length(); i++) {
		set.add(A.charAt(i));
	}
	if (A.equals(B)&&set.size()<A.length()) {
		return true;
	}
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
	if (alist.size()==2&&blist.size()==2) {
		return alist.get(0)==blist.get(1)&& alist.get(1)==blist.get(0);
	}
	return false;
    }
/*
 * 860.柠檬水找零
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
 * 867.转置矩阵
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
public int binaryGap(int N) {
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
		// TODO Auto-generated method stub

	}

}
