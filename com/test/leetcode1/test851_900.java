package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test.leetcode1.test001_050.TreeNode;

public class test851_900 {
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
 * 872. 叶子相似的树
 */

public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>(); 
	isLeaf(root1, list1);
	isLeaf(root2, list2);
	return list1.equals(list2);    
}
public void isLeaf(TreeNode root,List<Integer> list) {
	if (root==null) {
		return;
	}
	isLeaf(root.left, list);
	if (root.left==null&&root.right==null) {
		list.add(root.val);
	}
	isLeaf(root.right, list);	
}
/*
 * 874.模拟行走的机器人 difficult
 */
public int robotSim(int[] commands, int[][] obstacles) {
	//障碍物的横坐标
    Map<Integer,List<Integer>> mapx = new HashMap<>();
    //障碍物的纵坐标
    Map<Integer,List<Integer>> mapy = new HashMap<>();
    //如果存在障碍物
    if(obstacles.length!=0){   	
        for(int i=0;i<obstacles.length;i++){
        	//把横坐标相同的障碍物放到一个list集合中
            if(!mapx.containsKey(obstacles[i][0])){
                List<Integer> l1 = new ArrayList<>();
                l1.add(obstacles[i][1]);
                mapx.put(obstacles[i][0],l1);
            }else{
                mapx.get(obstacles[i][0]).add(obstacles[i][1]);
            }
            //把纵坐标相同的障碍物放到一个list集合中
            if(!mapy.containsKey(obstacles[i][1])){
                List<Integer> l2 = new ArrayList<>();
                l2.add(obstacles[i][0]);
                mapy.put(obstacles[i][1],l2);
            }else{
                mapy.get(obstacles[i][1]).add(obstacles[i][0]);
            }
        }
    }
    
    //dy=1向北，dy=-1向南，dx=1，向东，dx=-1向西，(x,y)位置
    int x=0,y=0,dy=1,dx=0,max=0;
    for(int i=0;i<commands.length;i++){
    	//向右转90度
        if(commands[i]==-1){
            if(dy!=0){
                dx=dy;dy=0;
            }else{
                dy = -dx;dx=0;
            }
         //向左转90度
        }else if(commands[i]==-2){
            if(dy!=0){
                dx=-dy;dy=0;
            }else{
                dy=dx;dx=0;
            }
        //如果是移动的命令
        }else{
        	//如果x方向上没有障碍物，那就移动命令指示的长度即可
            if(mapx.size()==0){
                x+=dx*commands[i];
                y+=dy*commands[i];
            }else{
            //如果x方向上有障碍物
               //沿x方向走
                if(dx!=0){
                	//xx是本该移动到的位置
                    int xx = x+dx*commands[i],flag=0;
                    if(mapy.containsKey(y)){
                        Collections.sort(mapy.get(y));
                      //如果障碍物在移动的路径之间
                        for(int xxx:mapy.get(y)){ 
                        	//x--xxx--xx
                            if(xxx>x&&xxx<=xx){
                            	//x的位置在障碍物的前面一个位置（因为被障碍物挡住了）
                                x = xxx-1;
                                flag=1;
                                break;
                            //xx--xxx--x
                            }else if(xxx>=xx&&xxx<x){
                                x = xxx+1;
                                flag=1;
                                break;
                            }
                        }
                        //如果没有障碍物，就直接到下一个地点
                        if(flag==0)
                            x=xx;
                    }else{
                        x=xx;
                    }
                 //如果dx=0，则dy!=0
                }else{//沿y方向走
                    int yy = y+dy*commands[i],flag=0;
                    if(mapx.containsKey(x)){
                        Collections.sort(mapx.get(x));
                        for(int yyy:mapx.get(x)){
                            if(yyy>y&&yyy<=yy){
                                y = yyy-1;
                                flag=1;
                                break;
                            }else if(yyy>=yy&&yyy<y){
                                y = yyy+1;
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0)
                            y=yy;
                    }else
                        y=yy;
                }
            }
            max = Math.max(x*x+y*y,max);
        }
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
/*
 * 883. 三维形体投影面积
 */
public int projectionArea(int[][] grid) {
	//顶部、前面、侧面的面积
	int top=0,front=0,side=0;
	//顶部 如果grid[][]!=0,top++
	for (int i = 0; i < grid.length; i++) {
		int maxside=0,maxfront=0;
		for (int j = 0; j < grid[i].length; j++) {
			if (grid[i][j]!=0) {
				top++;
			}
			maxside=Math.max(grid[i][j], maxside);
			maxfront=Math.max(maxfront, grid[j][i]);
		}
		side+=maxside;
		front+=maxfront;
	}
	return top+side+front;  
}

/*
 * 884. 两句话中的不常见单词
 */
public static String[] uncommonFromSentences(String A, String B) {
	//1.合并A，B放到一个字符串数组中
	String[] AB = (A+" "+B).split(" ");	
	//2.计算每个字符串出现的次数
	Map<String, Integer> map = new HashMap<>();
	for (int i = 0; i < AB.length; i++) {
		map.put(AB[i], map.getOrDefault(AB[i], 0)+1);
	}
	//3.如果出现的次数为1，就是唯一的不常见单词
	List<String> list = new ArrayList<>();		
	for (String key:map.keySet()) {
		if (map.get(key)==1) {
			list.add(key);
		}
	}
	String[] res  = new String[list.size()];
	return list.toArray(res);
}
/*
 * 888. 公平的糖果交换
 */
public static int[] fairCandySwap(int[] A, int[] B) {
	int[] res = new int[2];
	int sumA = 0,sumB = 0;
	for (int i = 0; i < A.length; i++) { //1.求A的和
		sumA+=A[i];
	}
	for (int i = 0; i < B.length; i++) { //2.求B的和
		sumB+=B[i];
	}
	for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < B.length; j++) {
			if ((A[i]-B[j])==(sumA-sumB)/2) { //3.A和B差值的一半是对方多出来的或者缺少的量，找出符合的
				res[0] = A[i];
				res[1] = B[j];
			}
		}
	}
	return res;   
}
/*
 * 892. 三维形体的表面积
 */
public int surfaceArea(int[][] grid) {	
int result=0;
for (int i = 0; i < grid.length; i++) {
	for (int j = 0; j < grid[i].length; j++) {
		if (grid[i][j]!=0) 
			//假设每个v=grid[i][j]都是独立的,每个位置的方块正好是方块四个面*数量加上底面和顶面
			result+=grid[i][j]*4+2;
		//减去面贴在一起的情况
		//如果这一行有方块
		if (i>0)
			result-=Math.min(grid[i-1][j], grid[i][j])*2;
		//如果这一列有方块
		if (j>0)
			result-=Math.min(grid[i][j-1], grid[i][j])*2;
	}
}
return result;
}

/*
 * 893. 特殊等价字符串组
 */
public int numSpecialEquivGroups(String[] A) {	
	Set<List<List<Character>>> sets = new HashSet<>();	
	for (int i = 0; i < A.length; i++) {
		List<List<Character>> list = new ArrayList<>();
		List<Character> oddlist = new ArrayList();
		List<Character> evenlist = new ArrayList();
		for (int j = 0; j < A[i].length(); j=j+2) {			
			oddlist.add(A[i].charAt(j));
			if (j+1<A[i].length()) {
				oddlist.add(A[i].charAt(j+1));
			}			
		}
		Collections.sort(oddlist);
		Collections.sort(evenlist);
		list.add(oddlist);
		list.add(evenlist);	
		sets.add(list);
	}
	
	return sets.size();   
}

/*
 * 896. 单调数列
 */
public boolean isMonotonic(int[] A) {
if (A.length<=2) {
	return true;
}
boolean flag1 = false,flag2 = false;  //flag1递增标志  flag2递减标志
for(int i = 1;i < A.length;i++){
    if(A[i] - A[i-1] > 0){
        if(flag2)  return false;
        flag1 = true;
    }
    else if(A[i] - A[i-1] < 0){
        if(flag1)  return false;
        flag2 = true;
    }
}
return true; 
}

/*
 * 897. 递增顺序查找树 
 * 难
 */
TreeNode headNode;
public TreeNode increasingBST(TreeNode root) {
	if (root==null) {
		return null;
	}
	root.right=increasingBST(root.right);
	if (root.left!=null) {
		TreeNode node = root.left;
		root.left=null;
		headNode = node;
		while(node.right!=null) {
			node=node.right;
		}
		node.right=root;
		return increasingBST(headNode);
	}else {
		return root;
	}   
}


	public static void main(String[] args) {

	}

}
