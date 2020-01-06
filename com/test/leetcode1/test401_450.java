package com.test.leetcode1;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class test401_450 {
	//链表结构体定义
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }	
	  //2叉树结点定义
		public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		//N叉数结点定义
		class Node {
		    public int val;
		    public List<Node> children;

		    public Node() {}

		    public Node(int _val,List<Node> _children) {
		        val = _val;
		        children = _children;
		    }
		};
/*
 * 401. 二进制手表
 */
 public List<String> readBinaryWatch(int num) {
	 List<String> list = new ArrayList<>();
	 //暴力破解，直接循环遍历
	 for (int i = 0; i < 12; i++) {
		for (int j = 0; j < 60; j++) {
			if(count_1(i)+count_1(j)==num)
				list.add(i+":"+(j<10?"0"+j:j));
		}
	}
	return null;        
    }
 //计算二进制中1的个数
 int count_1(int n) {
	 int res = 0;
	 while (n!=0) {
		 if ((n & 1) == 1) {
			 res++;
         }
         n = n >> 1;
		
	}
	return res;
 }
 
/**
 * 404. 左叶子之和
 * @param root
 * @return
 */
	 public int sumOfLeftLeaves(TreeNode root) {
		 if(root == null) return 0;
	        int res = 0;
	        //判断节点是否是左叶子节点，如果是则将它的和累计起来
	        if(root.left != null && root.left.left == null && root.left.right == null){
	            res += root.left.val;
	        }
	        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;	        
	    }
	 
/*
 * 405. 数字转换为十六进制数
 */
 public String toHex(int num) {
	 char [] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
     if (num == 0) {
         return "0";
     }
     StringBuilder sb = new StringBuilder();
     while (num != 0) {
         sb.append(array[num & 15]);//使用位与,每四位数为一个16进制数
         num = num >>> 4;	//无符号右移，左边填0
     }
     return sb.reverse().toString();
 }
/**
 * 409. 最长回文串	 	 
 * @param s
 * @return
 */
	public static int longestPalindrome(String s) {
		List<Character> list = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (list.contains(s.charAt(i))) {
				list.remove(Character.valueOf(s.charAt(i)));
				j = j + 2;
			} else {
				list.add(Character.valueOf(s.charAt(i)));
			}
		}
		if (!list.isEmpty()) {
			j++;
		}
		return j;

	}
	
	
/**
 * 412. Fizz Buzz	 so easy
 * @param n
 * @return
 */
public List<String> fizzBuzz(int n) {
	List<String> list = new ArrayList<>();
	for (int i = 1; i <= n; i++) {
		if (i%3==0&&i%5==0) {
			list.add("FizzBuzz");
		}else if (i%3==0) {
			list.add("Fizz");
		}else if (i%5==0) {
			list.add("Buzz");
		}else {
			list.add(String.valueOf(i));
		}
	}
	return list;       
    }

/**
 * 414. 第三大的数
 * @param nums
 * @return
 */
public static int thirdMax(int[] nums) {
	  if(nums.length==1){
          return nums[0];
      }
      if(nums.length==2){
          return Math.max(nums[0],nums[1]);
      }
      int max1=Integer.MIN_VALUE;
      int max2=Integer.MIN_VALUE;
      int max3=Integer.MIN_VALUE;
      boolean f=true;
      int flag=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]==Integer.MIN_VALUE&&f){
              flag++;
              f=false;
          }
          if(nums[i]>max1){
              flag++;
              //原先第二大传递给第三大
              max3=max2;
              //原先最大值传递给第二大
              max2=max1;
              //更新最大值
              max1=nums[i];
          }else if (nums[i]>max2 && nums[i]<max1){
              flag++;
              max3=max2;
              max2=nums[i];
          } else if( nums[i]>max3 && nums[i]<max2){
              flag++;
              max3=nums[i];
          }
      }
      return flag>=3?max3:max1;
    
}

/**
 * 415. 字符串相加
 * @param num1
 * @param num2
 * @return
 */
public String addStrings(String num1, String num2) {
	StringBuilder sb = new StringBuilder();
    int carry = 0, i = num1.length()-1, j = num2.length()-1;
    while(i >= 0 || j >= 0 || carry != 0){
        if(i>=0) carry += num1.charAt(i--)-'0';
        if(j>=0) carry += num2.charAt(j--)-'0';
        sb.append(carry%10);
        carry /= 10;
    }
    return sb.reverse().toString();
    
}

/*
 * 429. N叉树的层序遍历
 */
public List<List<Integer>> levelOrder(Node root) {
	List<List<Integer>> result = new ArrayList<>();
    if( root == null ){
        return result;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);    
    while( !queue.isEmpty() ){
        int size = queue.size();//记录每一层的大小
        List<Integer> list = new ArrayList<>();
        for( int i=0; i<size; i++){
            Node node = queue.poll();
            list.add(node.val);
            List<Node> children = node.children;
            if( children!= null && children.size() > 0){
                for( Node n : children){
                    queue.add(n);
                }
            }
        }
        result.add(list);
    }
    return result;
}

/**
 * 434. 字符串中的单词数
 * @param s
 * @return
 */
public int countSegments(String s) {
String[] words = s.split(" ");
int count=0;
for (int i = 0; i < words.length; i++) {
	if (!words[i].equals("")) {
		count++;
	}
}
return count;
}
/*
 * 437. 路径总和 III
 */
public int pathSum(TreeNode root, int sum) {
	if (root==null) {
		return 0;
	}
	return pathSum(root.left, sum)+pathSum(root.right, sum)+Sum(root,sum);

}
public int Sum(TreeNode root,int sum) {
	if (root==null) return 0;
	int count=0;
	//当递归到最后一个值正好等于和，说明有一条路径
	if (root.val==sum) {
		count=1;
	}
	return count+Sum(root.left, sum-root.val)+Sum(root.right, sum-root.val);
	
}


/**
 * 438. 找到字符串中所有字母异位词  错误，坑爹啊 ！！！
 * @param s
 * @param p
 * @return
 */
public static List<Integer> findAnagrams(String s, String p) {
	List<Integer> list = new ArrayList<>();
	 if (p.length()>=s.length()&&!p.equals(s)) {
	 	return list;
	 }
	int i=0;
	Boolean flag=true;
	while (i+p.length()<=s.length()) {
	String tmp=s.substring(i, i+p.length());
	System.out.println("tmp:"+tmp);
	int res =(tmp.charAt(0)-'a')^(p.charAt(0)-'a');
	for (int j = 1; j < p.length(); j++) {
		if (s.contains(p.charAt(j)+"")) {
		res^=(tmp.charAt(j)-'a')^(p.charAt(j)-'a');
		//System.out.println((tmp.charAt(j)-'a')+","+(p.charAt(j)-'a')+","+((tmp.charAt(j)-'a')^(p.charAt(j)-'a'))+","+res);
	}else {
		flag=false;
		}
	//System.out.println("res:"+res);
	if (res==0&&flag==true) {
		list.add(i);
		System.out.println(i);
	}	
  }
	i++;
	}
	return list;
    
}


/**
 * 441. 排列硬币
 */
public static int arrangeCoins(int n) {
	
	for (long i = 1; i <= Math.sqrt(n); i++) {
		if (((1+i)*i)/2<=n&&((2+i)*(i+1))/2>n) {
			return (int) i;
		}
	}
	return 0;
    
}
/*
 * 443. 压缩字符串
 */
public int compress(char[] chars) {
	int n = chars.length, cur = 0;
    for (int i = 0, j = 0; i < n; i = j) {
        while (j < n && chars[j] == chars[i]) j++;
        chars[cur++] = chars[i];
        if (j - i == 1) continue;
        for (char c : String.valueOf(j - i).toCharArray()) chars[cur++] = c;
    }
    return cur;
    
}



/*
 * 447. 回旋镖的数量
 */
public static  double getDistance(int[] points1,int[] points2) {
	return Math.sqrt((Math.pow((points1[0]-points2[0]), 2)+Math.pow((points1[1]-points2[1]), 2)));
}
public static int numberOfBoomerangs(int[][] points) {
	int count=0;
	if (points.length<3) {
		return 0;
	}
	for (int i = 0; i < points.length; i++) {
	HashMap<Double, Integer> map = new HashMap<>();	
		for (int j = 0; j < points.length; j++) {
			if (i==j) {
				continue;
			}			
			double distance = getDistance(points[i], points[j]);
			//getOrDefault当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
			map.put(distance, map.getOrDefault(distance, 0)+1);			
		}
		for (int k:map.values()) {
		if (k>1) 
			count+=k*(k-1);//从k个点中选两个作为元组后两个元素，全排列
		
		}
	}	
	return count;
    
}

/*
 * 448. 找到所有数组中消失的数字
 */
public static List<Integer> findDisappearedNumbers(int[] nums) {	
	List< Integer> result=new ArrayList<>();
	for (int i = 0; i < nums.length; i++) {
		//System.out.println(nums[i]-1);
		nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
	}
	for (int i = 0; i < nums.length; i++) {
		if (nums[i]>0) {
			result.add(i+1);
		}
	}
	return result;
    
}



	public static void main(String[] args) {
		int[] points= {4,3,2,7,8,2,3,1};
		findDisappearedNumbers(points);
		for (int i:findDisappearedNumbers(points)) {
			System.out.println(i);
		}
			
	}

}
