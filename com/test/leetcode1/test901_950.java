package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test.leetcode1.test001_050.TreeNode;

public class test901_950 {
 //树结点定义
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/*
 * 905. 按奇偶排序数组
 */
public int[] sortArrayByParity(int[] A) {
	//借用快速排序的思想
	int left=0,right=A.length-1,tmp=0;
	while (left<right) {
		while (left<right&&A[left]%2==0) {
			left++;
		}
		while (left<right&&A[right]%2!=0) {
			right--;
		}	
		if (left<right) {
			tmp = A[left];
			A[left] = A[right];
			A[right] = tmp;	
		}							
	}	
	return A;   
}

/*
 * 908. 最小差值 I so easy
 */
public int smallestRangeI(int[] A, int K) {
	//先从大到小排序
	Arrays.sort(A);
	//如果最大值和最小值之间差距比2k小，说明两数处理后有机会相等
	if ((A[A.length-1]-A[0])<=2*K) {
		return 0;
	}else {
		//如果最大值和最小值之间差距比2k大，那只能尽量处理使两者之间的差距变小
		return (A[A.length-1]-K)-(A[0]+K);
	}    
}

/*
 * 914. 卡牌分组
 */
public static boolean hasGroupsSizeX(int[] deck) {
	Map<Integer, Integer> map =new HashMap<Integer, Integer>();
	//计算每一种数字出现的次数
	for (int i = 0; i < deck.length; i++) {
		map.put(deck[i], map.getOrDefault(deck[i], 0)+1);
	}
	int min=10000;
	//找出最少的出现次数
	for (int count:map.values()) {
		System.out.println(count);
		min = Math.min(min, count);
		
	}
	//如果某个数字只出现了1次，说明只能单个分组，不满足题目要求
	if (min<=1) {
		return false;
	}
	int min1 = min;
	//判断两个数是否互质
	for (int count:map.values()) {
		int c=0;		
		while ((c=count%min1)!=0) {
			count = min1;
			min1=c;			
		}
		if (min1==1) {
			return false;
		}
		min1=min;
	}	
	return true;    
}


/*
 * 917. 仅仅反转字母  
 * 字符串是常量，不可以重新赋值哦
 */
public static String reverseOnlyLetters(String S) {
	char[] arr = S.toCharArray();
	int i=0,j=arr.length-1;
	char tmp;
	while (i<j) {
		while (i<j&&!isLetter(arr[i])) {
			i++;
		}
		while (i<j&&!isLetter(arr[j])) {
			j--;
		}
		tmp = arr[i];
		arr[i]= arr[j];
		arr[j]=tmp;
		i++;
		j--;				
	}		
	return String.copyValueOf(arr);   
}
public static boolean isLetter(char ch) {
	return (ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z');
}
/*
 * 
 */
public int[] sortArrayByParityII(int[] A) {
	int i=0,j=1,tmp;
	while (i<A.length||j<A.length) {
		while (i<A.length&&A[i]%2==0) {
			i+=2;			
		}
		while (j<A.length&&A[j]%2!=0) {
			j+=2;
		}
		if (i<A.length&&j<A.length) {
			tmp=A[i];
			A[i] =A[j];
			A[j] = tmp;
		}		
	}
	return A;    
}

/*
 * 925. 长按键入
 */
public boolean isLongPressedName(String name, String typed) {
    if(name.length()>typed.length()){
        return false;
    }
    int i=0;
    int j=0;
    while(i<name.length()&&j<typed.length()){
        if(name.charAt(i)==typed.charAt(j)){
            i++;
            j++;
        }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
            j++;
        }else{
            return false;
        }
    }
    return i ==name.length();    
}
/*
 * 929. 独特的电子邮件地址
 */
public static int numUniqueEmails(String[] emails) {
	Set<String> set =new HashSet<>();	
	for (int i = 0; i < emails.length; i++) {
		String ss ="";
		if (emails[i].contains("+")) {		
		//如果地址中有+，就只截取+前面的内容并删除.,然后再与@及后面的字符串做拼接，形成一个正常的地址。
		ss=emails[i].substring(0, emails[i].indexOf('+')).replaceAll("\\.", "")+emails[i].substring(emails[i].indexOf('@'), emails[i].length());			
		}else {
		//如果地址中没有+，就只截取@前面的内容并删除.,然后再与@及后面的字符串做拼接，形成一个正常的地址。
		ss=emails[i].substring(0, emails[i].indexOf('@')).replaceAll("\\.", "")+emails[i].substring(emails[i].indexOf('@'), emails[i].length());			
		}
		System.out.println(ss);
		set.add(ss);			
	}	
	return set.size();    
}
/*
 * 937. 重新排列日志文件
 */
public String[] reorderLogFiles(String[] logs) {
	int len = logs.length;
	//冒泡排序
	for(int i = 0; i < len-1; i++){
	    for(int j = 0; j < len-1-i; j++){
		String leftStr = logs[j].substring(logs[j].indexOf(" ")+1);
		String rightStr = logs[j+1].substring(logs[j+1].indexOf(" ")+1);
		if(isSwap(leftStr, rightStr)){
		    String tmp = logs[j];
			logs[j] = logs[j+1];
			logs[j+1] = tmp;
		    }
		}
	 }
	return logs;
    }
	
    //是否需要交换
    public boolean isSwap(String leftStr, String rightStr){
    //字符串的首字母leftCh、rightCh
	char leftCh = leftStr.charAt(0), rightCh = rightStr.charAt(0);
	//右边是字母
	if(rightCh >= 'a' && rightCh <= 'z'){
		//左边是数字
	   if(leftCh >= '0' && leftCh <= '9'){
	       //1. 左边是数字, 右边是字母, 字母日志要排在数字日志之前, 需要交换
		return true;
	     }else if(leftStr.compareTo(rightStr) > 0){
               //2. 两边都是字母, 没有按字母顺序排列, 需要交换
	       return true;
	    }
	}
	return false;
	//Arrays.sort(logs, (log1, log2) -> 表示log1和log2进行比较排序
//	Arrays.sort(logs, (log1, log2) -> {
//		//split(" ", 2)表示把标志符和日志符合分开
//        String[] split1 = log1.split(" ", 2);
//        String[] split2 = log2.split(" ", 2);
//        //log1中的标志符第一个字母是否是数字
//        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//        //如果不是数字
//        if (!isDigit1 && !isDigit2) {
//        	//比较两个字符串日志是否一样
//            int cmp = split1[1].compareTo(split2[1]);
//            if (cmp != 0) return cmp;
//            return split1[0].compareTo(split2[0]);
//        }
//        return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
//    });
  //  return logs;
} 
/*
 * 938. 二叉搜索树的范围和   
 */
 public int rangeSumBST(TreeNode root, int L, int R) {
	 if (root==null) 
		return 0;
	 if (root.val>=L&&root.val<=R) {
		return root.val+rangeSumBST(root.left, L, R)+rangeSumBST(root.right, L, R);
	}else if (root.val<L) {
		return rangeSumBST(root.right, L, R);
	}else {
		return rangeSumBST(root.left, L, R);
	}     
 }

/*
 * 941.有效的山脉数组
 */
public boolean validMountainArray(int[] A) {
	int i=0,j=A.length-1;
	//设置双指针，当左边递增时，指针继续后移
	while (i<j&&A[i]<A[i+1]) {
		i++;		
	}
	//当右边递减时，指针继续左移
	while (i<j&&A[j]<A[j-1]) {
		j--;		
	}
	while (i==j&&i!=0&&j!=A.length-1) {
		return true;		
	}	
	return false;    
}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,4,3,2,1};
		String[] aaStrings =String.valueOf(34).split("");
		System.out.println(aaStrings[0]+","+aaStrings[1]);

	}

}
