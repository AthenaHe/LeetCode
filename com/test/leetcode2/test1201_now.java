package com.test.leetcode2;

public class test1201_now {
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/*
 * 1232. 缀点成线
 */
	public static boolean checkStraightLine(int[][] coordinates) {
		int x1, x2, y1, y2;
		boolean flag = true;
		x1 = coordinates[0][0];
		x2 = coordinates[1][0];
		y1 = coordinates[0][1];
		y2 = coordinates[1][1];
		if (x2 == x1) {// 斜率为0
			flag = false;
		}
		int pointcount = coordinates.length;// 点的个数
		if (flag) { // 如果存在斜率；
			int k = (y2 - y1) / (x2 - x1);// 斜率
			for (int i = 2; i < coordinates.length; i++) {
				if (coordinates[i][0] - x1==0) {
					return false;
				}
				if (k*1.0 != (coordinates[i][1] - y1)*1.0 / (coordinates[i][0] - x1)) {
					return false;
				}
			}
		} else {
			for (int i = 2; i < coordinates.length; i++) {
				if ((coordinates[i][0] - x1) != 0) {
					return false;
				}
			}
		}
		return true;
	}
/*
 * 1252. 奇数值单元格的数目
 */
public int oddCells(int n, int m, int[][] indices) {
	int[] row=new int[n];
	int[] col=new int[m];
	int res=0;
for (int i = 0; i < indices.length; i++) {
    row[indices[i][0]]++;//这一行都加1
	col[indices[i][1]]++;//这一列都加1	
}
for (int i = 0; i < n; i++) {
	for (int j = 0; j < m; j++) {
		if ((row[i]+col[j])%2!=0) {
			res++;
		}
	}
}
	return res;       
}
/*
 * 1266. 访问所有点的最小时间
 */
public int minTimeToVisitAllPoints(int[][] points) {
	int[] nowpoints= {points[0][0],points[0][1]};
	int step=0;
	for (int i = 1; i < points.length; i++) {		
	step+=Math.max(Math.abs(nowpoints[0]-points[i][0]), Math.abs(nowpoints[1]-points[i][1]));
	//System.out.println(Math.abs(nowpoints[0]-points[i][0])+","+Math.abs(nowpoints[1]-points[i][1]));
	nowpoints[0]=points[i][0];
	nowpoints[1]=points[i][1];
		}		
	return step;  
}
/*
 * 1290. 二进制链表转整数
 */
public int getDecimalValue(ListNode head) {
	ListNode node=head;
	int num=node.val;
	while ((node=node.next)!=null) {
		num=node.val+num*2;
	}
	return num;   
}
/*
 * LCP 1. 猜数字
 */
public int game(int[] guess, int[] answer) {
	int count=0;
	for (int i = 0; i < guess.length; i++) {
		if (guess[i]==answer[i]) {
			count++;
		}
	}
	return count;    
}
/*
 * LCP 2.分式化简
 */
	public static int[] fraction(int[] cont) {
		int[] result= new int[2];
		int tmp=0;
		result[0]=cont[cont.length-1];
		result[1] = 1;
		for (int i = cont.length-1; i >0 ; i--) {
		tmp=result[1];
		result[1]=result[0];
		result[0]=cont[i-1]*result[0]+tmp;
		}
		tmp=gcd(result[0], result[1]);
		result[1]/=tmp;
		result[0]/=tmp;
		System.out.println(result[0]+","+result[1]);
		return result;   
	}
	//求最大公约数
	public static int  gcd(int a,int b) {
		while (a%b!=0) {
			int tmp=a%b;
			a=b;
			b=tmp;		
		}
		return b;	
	}
	public static void main(String[] args) {
	int coordinates[][]= {{1,1},{2,2},{3,4},{5,6},{7,7}};
	System.out.println(checkStraightLine(coordinates));
	}
}
