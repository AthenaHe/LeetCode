package com.test.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * 1237. 找出给定方程的正整数解	
 */
interface CustomFunction {
	public int f(int x, int y);
};
public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
	List<List<Integer>> lists=new ArrayList<>();	
	for (int i = 0; i <= z; i++) {
		for (int j = 0; j <=z; j++) {
			List<Integer> list = new ArrayList<>();
			if (customfunction.f(i, j)==z) {
				list.add(i);
				list.add(j);
				lists.add(list);
			}
			
		}
	}
	return lists;
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
 * 1275. 找出井字棋的获胜者
 */
	 /**
     * 思路：
     * 1、只关注最后一个玩家即可
     * 如果最后一个玩家的同一行或同一列或对角线上有三个或三个以上相同元素则最后一个玩家获胜
     * 至于最后一个玩家到底是A还是B可以通过判断索引是奇数还是偶数还确定到底是哪个玩家
     * 2、最后一个玩家没有获胜的情况
     * 此时检查一下方格是否已经被填满了，如果填满了说明是平局
     * 如果没有填满说明游戏还未结束
     *
     * @param moves
     * @return
     */
    public String tictactoe(int[][] moves) {
        // 同一行
        int rowCounter = 0;
        // 同一列
        int colCounter = 0;
        // 主对角线
        int mainCounter = 0;
        // 副对角线
        int subCounter = 0;
        int key = (moves.length - 1) % 2;
        int[] last = moves[moves.length - 1];
        int he = last[0] + last[1];
        int cha = last[0] - last[1];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == key) {
                int[] move = moves[i];
                if (move[0] == last[0]) {
                    rowCounter++;
                }
                if (move[1] == last[1]) {
                    colCounter++;
                }
                if (move[0] + move[1] == he) {
                    subCounter++;
                }
                if (move[0] - move[1] == cha) {
                    mainCounter++;
                }
            }
        }
        if (rowCounter >= 3 || colCounter >= 3 || mainCounter >= 3 || subCounter >= 3) {
            return key == 0 ? "A" : "B";
        }
        // 格子未填满并且未分出胜负的情况
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }

/*
 * 1287. 有序数组中出现次数超过25%的元素
 */
public int findSpecialInteger(int[] arr) {
	int count=1,tmp=arr[0];
	for (int i = 1; i < arr.length; i++) {
		if (arr[i]==tmp) {
			count++;
			if (count>arr.length%4) {
				return arr[i];
			}
		}else {
			count=1;
			tmp=arr[i];
		}
	}
	return 0;   
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
 * 1295. 统计位数为偶数的数字
 */
public int findNumbers(int[] nums) {
	int count=0;
	for (int i = 0; i < nums.length; i++) {
		if ((nums[i]+"").length()%2==0) {
			count++;
		}
	}
	return count; 
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
