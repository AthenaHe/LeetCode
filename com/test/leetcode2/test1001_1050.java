package com.test.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test1001_1050 {
//树结点定义
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
/*
 * 1002. 查找常用字符 little difficult
 */
public List<String> commonChars(String[] A) {
	List<String> list = new ArrayList<>();
	int[] res = new int[26];
	//找交集
    for (char ch : A[0].toCharArray()) {
        res[ch - 'a']++;
    }
	for (int i = 1; i < A.length; i++) {
		int[] tmp=new int[26];
		for (char ch:A[i].toCharArray()) {
			tmp[ch-'a']++;
		}
		for (int j = 0; j < 26; j++) {
			res[j] = Math.min(res[j], tmp[j]);
		}
	}
	for (int i = 0; i < res.length; i++) {
        if (res[i] > 0) {
            for (int j = 0; j < res[i]; j++) {
                list.add(((char) ('a' + i) + ""));
            }
        }
    }
	return list;           
    }
/*
 * 1005. K 次取反后最大化的数组和
 */
public static int largestSumAfterKNegations(int[] A, int K) {
	//将数组升序排序
	Arrays.sort(A);
	int sum=0;
	int i=0;
	while (K>0) {
		//如果数组的数小于0，先尽可能的转换成大于0的数。
		if (A[i]<0) {
			A[i]=-A[i];
			i++;
			K--;
		}else {
		//如果数组中的负数已经全部转换成了正数，那就对数组再升序排序一次
			Arrays.sort(A);
			break;
		}			
	}
	//由于现在数组中全部是正数，所以只用对最小值下手就行了。
	if (K%2!=0) {
		A[i]=-A[i];
	}
	for (int j = 0; j < A.length; j++) {
		sum+=A[j];
	}
	return sum;    
}	

/*
 * 1009. 十进制整数的反码
 */
public static int bitwiseComplement(int N) {
	String nString = Integer.toBinaryString(N);
	String res="";
	for (int i = 0; i < nString.length(); i++) {
		if (nString.charAt(i)=='0') {
			res+="1";
		}else {
			res+="0";
		}
	}
	return Integer.parseInt(res, 2);    
}
/*
 * 1010. 总持续时间可被 60 整除的歌曲 
 * 不可用双循环
 */
public int numPairsDivisibleBy60(int[] time) {
	int[] record = new int[60];
    int count = 0;
    for(int t : time){
        t %= 60;        //求这个时间的余数
        if(t != 0)  
            count += record[60 - t];    //如果时间余数不为0，找出相加为0的余数总和相加
        else count += record[t];        //如果为0，加其他为0的数
        record[t] ++;
    }
    return count;    
}

/*
 * 1013. 将数组分成和相等的三个部分
 */
public static  boolean canThreePartsEqualSum(int[] A) {
	int sum=0;
	for (int i = 0; i < A.length; i++) {
		sum+=A[i];		
	}
	if (sum%3!=0||sum==0) {
		return false;
	}
	//System.out.println(sum/3+","+sum%3);
	int sum1=0,sum2=0;
	int i=0,j=A.length-1;
	while (i-1<j&&j>=0&&i<A.length) {
		if (sum1!=sum/3) {
			sum1+=A[i];	
			i++;
		}	
		
		if (sum2!=sum/3) {
			sum2+=A[j];
			j--;
		}
		System.out.println(sum1+","+sum2);
		if (sum1==sum/3&&sum2==sum/3&&i-1<j) {
			return true;
		}		
	}	
	return false;    
}

/*
 * 1018. 可被 5 整除的二进制前缀
 */
public List<Boolean> prefixesDivBy5(int[] A) {
	List<Boolean> res = new ArrayList<>();
    int sum= 0;
    for(int i = 0; i < A.length; i++){
    	//(sum<< 1) + A[i]将二进制转换成十进制
        sum= ((sum<< 1) + A[i]) % 5;
        res.add(sum== 0);
    }
    return res;
    
}

/*
 * 1021. 删除最外层的括号
 */
public String removeOuterParentheses(String S) {
	String res = "";
	Stack<Character> stack = new Stack<>();
	//这样做，最外层的就不会加到最终结果中
	for (int i = 0; i < S.length(); i++) {
		if (S.charAt(i)==')') {
			stack.pop();
		}
		if (!stack.isEmpty()) {
			res+=S.charAt(i);
		}
		if (S.charAt(i)=='(') {
			stack.push(S.charAt(i));			
		}
	}
	return res;   
}
/*
 * 1022. 从根到叶的二进制数之和
 * 递归难以理解
 */
int sum=0;
public int sumRootToLeaf(TreeNode root) {
	  help(root,"");
	  return sum;
}

void help(TreeNode root,String s){
  if(root==null) return;
  s+=root.val;
  if(root.left==null&&root.right==null){
        sum+=Integer.parseInt(s,2);
        return;
    }
  help(root.left,s);
  help(root.right,s);
}
/*
 * 1025. 除数博弈
 */
public boolean divisorGame(int N) {
	return ((N & 1) == 0);    
}
/*
 * 1029.两地调度
 */
public int twoCitySchedCost(int[][] costs) {
	int[] gap = new int[costs.length];
	int res = 0;
	//先计算全部去A市的费用
	for (int i = 0; i < costs.length; i++) {
		res+=costs[i][0];
		gap[i] = costs[i][1]-costs[i][0];
	}
	//再根据差值进行排序
	Arrays.sort(gap);
	//获取差值最小的前一半的元素和A市所有费用的和就相当于
	//A+1/2(B-A)=1/2(A+B)
	for (int i = 0; i < costs.length/2; i++) {
		res+=gap[i];
	}
	return res;
    
}

/*
 * 1033. 移动石子直到连续
 */
public int[] numMovesStones(int a, int b, int c) {
	int[] res = new int[2];
	//先给abc升序排序
	int[] abc = {a,b,c};
	Arrays.sort(abc);
	a=abc[0];
	b=abc[1];
	c=abc[2];
	System.out.println(a+","+b+","+c);
	//最大步数的情况就是将c和a一步一步往中间移动
	//max = (b-a-1)+(c-b-1);
	res[1] = c-a-2;
	System.out.println(res[1]);
	//最小情况分四种
	//1.如果abc都相邻，那就不用移动了
	if (c-b==1&&b-a==1) {
		res[0]=0;
	}
	//2.如果b只和其中一个相邻，那就把另一个移到b旁边
	if (b-a==1||c-b==1) {
		res[0]=1;
	}
	//3.如果b和另外两个不相邻，但是和其中一个中间还有一个位置，那就把另一个移动它们中间
	if (b-a==2||c-b==2) {
		res[0]=1;
	}
	//4.如果b和另外两个都不相邻，那就另外两个分别移动一次到b的旁边
	if (c-b>1&&b-a>1) {
		res[0]=2;
	}			
	return res;   
}

/*
 * 1037. 有效的回旋镖
 */
public boolean isBoomerang(int[][] points) {
	 	int x1 = points[0][0] - points[1][0];
	    int y1 = points[0][1] - points[1][1];	    
	    int x2 = points[0][0] - points[2][0];
	    int y2 = points[0][1] - points[2][1];
	    return x1*y2!=x2*y1;
}
/*
 * 1041. 困于环中的机器人
 */
public boolean isRobotBounded(String instructions) {
	int x=0,y=0,direction=0;//北0，东1，南2，西3
	//四次重复命令来判断是否有环
	for (int i = 0; i < 4; i++) {
	for (int j = 0; j < instructions.length(); j++) {
		char ch=instructions.charAt(j);
		//往前面走
		if (ch=='G') {
			if (direction==0) {
				y+=1;
			}else if (direction==1) {
				x+=1;
			}else if (direction==2) {
				y-=1;
			}else if (direction==3) {
				x-=1;
			}
		//向右转
		}else if (ch=='R') {
			direction=(direction+1)%4;
		//向左转
		}else if (ch=='L') {
			direction=(direction+3)%4;
		}				
	}	
	}
	//如果四次重复命令后回到原点，则说明一定有环
	if (x==0&&y==0) {
		return true;
	}
	return false;  
}
	/**
	 * 1047. 删除字符串中的所有相邻重复项
	 * @param args
	 */
	public static  String removeDuplicates(String S) {
		StringBuilder a=new StringBuilder();
	    for(int i=0;i<S.length();i++){
	        if(a.length()==0){
	            a.append(S.charAt(i));
	        }else if(a.charAt(a.length()-1)==S.charAt(i)){
	            a.delete(a.length()-1,a.length());
	        }else{
	            a.append(S.charAt(i));
	        }
	    }
	    return  a.toString();
		
	}	
	
	public static void main(String[] args) {
		int[] A= {3,3,6,5,-2,2,5,1,-9,4};
		int K=1;
		//bitwiseComplement(5);
		System.out.println(canThreePartsEqualSum(A));
	}

}
