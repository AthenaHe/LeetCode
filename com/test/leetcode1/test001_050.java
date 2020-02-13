package com.test.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class test001_050 {
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

	/**
	 * 1.两数之和
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] addnum = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			addnum[0] = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				addnum[1] = nums[j];
				if (addnum[0] + addnum[1] == target) {
					addnum[0] = i;
					addnum[1] = j;
					System.out.println(i + "," + j);
					return addnum;
				}
			}

		}
		return addnum;
	}
/*
 * 2. 两数相加
 */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	//创建一个代表头结点的链表
	ListNode headnode=new ListNode(0);
	//创建一个指针指向头结点
	ListNode tmp=headnode;
	//进位
	int carry=0;
	int sum=0;
	while (l1!=null||l2!=null||carry!=0) {
		//位数相加+进位
		int l1val=(l1!=null?l1.val:0);
		int l2val=(l2!=null?l2.val:0);
		sum = l1val+l2val+carry;
		carry=sum/10;
		
		//将相加和的值给新结点
		ListNode sumNode = new ListNode(sum%10);
		tmp.next=sumNode;
		tmp=sumNode;
		if (l1!=null) l1=l1.next;
		if (l2!=null) l2=l2.next;
}
	return headnode.next;        
    }
/*
 * 3. 无重复字符的最长子串
 */
public static int lengthOfLongestSubstring(String s) {
	int max=Integer.MIN_VALUE;
	String tmp = "";
	int count=0;
	for (int i = 0; i < s.length(); i++) {	
	if (!tmp.contains(s.substring(i, i+1))) {
		tmp+=s.substring(i, i+1);
		count++;
	}else {
		if (max<count) {
			max=count;
		}		
		i=s.indexOf(tmp)+tmp.indexOf(s.substring(i, i+1));
		tmp = "";
		count=0;
		break;
	}
	if (max<count) {
		max=count;
	}	
}
return max;    
}
/*
 * 5. 最长回文子串
 */
public String longestPalindrome(String s) {
	for (int len = s.length(); len>=0; len--) {
		for (int i = 0; i < s.length()-len+1; i++) {
			if(ishuiwen(s.substring(i, i+len))) {
				return s.substring(i, i+len);
			}
		}
	}
	return "";    
}
//判断是否是回文
public boolean ishuiwen(String t) {
	for (int i = 0; i < t.length()/2; i++) {
		if (t.charAt(i)!=t.charAt(t.length()-i-1)) {
			return false;
		}
	}
	return true;
}

	/**
	 * 7. 整数反转  
	 * @param x
	 * @return
	 */
public static int reverse(int x) {
	int flag=1;
	long n=0;
	if (x<0) {
		flag=-1;
		x=-x;
	}
	while (x>0) {	
	n=n*10+x%10;
	x/=10;
	}
	if (flag==-1) {
		n=-n;
	}
	if (n<=Integer.MAX_VALUE&&n>=Integer.MIN_VALUE) {
		return (int)n;
	}
	
	return 0;
}
/**
 * 9. 回文数判断
 * @param x
 * @return
 */
public Boolean IsPalindrome(int x) {
	/**
	 * 如果x小于0或者最后一个数不为0，本身也不为0则不是回文数
	 */
	if (x<0||(x % 10 == 0 && x!= 0)) {
		return false;
	}
	int n=0;
	//将数字的一半长度进行反转
	while (x>n) {
		n=n*10 + x%10;
		x/=10;		
	}
	return x==n || x==n/10;
}
/*
 * 11. 盛最多水的容器
 */
public int maxArea(int[] height) {
	int maxArea = 0;
	for (int i = 0; i < height.length-1; i++) {
		for (int j = i+1; j < height.length; j++) {
				maxArea=Math.max(maxArea,Math.min(height[i], height[j])*(j-i));
		}
	}
	return maxArea;
    
}
/*
 * 12. 整数转罗马数字 difficult
 */
public String intToRoman(int num) {
	//用数组定义字典
    int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
    String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
    //定义一个字符串
    StringBuilder res = new StringBuilder();    
    for(int i = 0; i <values.length; i++){
        int a = num / values[i];
        if(a==0)continue;
        for(int j = a; j > 0;j --)
            res.append(strs[i]);
        num -= (a*values[i]);
        if(num ==0)break;
    }
    return res.toString(); 
    
}

	/**
	 * 13. 罗马数字转整数
	 * 字符          数值
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
	 * @param args
	 */
	public static int romanToInt(String s) {
		int sum = 0;
		Map<Character, Integer> map=new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for (int i = 0; i < s.length()-1; i++) {
			if (map.get(s.charAt(i))>=map.get(s.charAt(i+1))) {
				sum+=map.get(s.charAt(i));
			}else {
				sum+=-map.get(s.charAt(i));
			}
		}
		sum+=map.get(s.charAt(s.length()-1));
		return sum;
	    
	}
	/**
	 * 14. 最长公共前缀-->是从串首开始的公共字符串
	 * @param args
	 */
	public static String longestCommonPrefix(String[] strs) {

		String s = "";
	    if(strs.length>0)
	        s=strs[0];
	    for(int i=1;i<strs.length;i++){
	        s=common(s,strs[i]);
	    }
	    return s;
	}
	//求公
	public static String common(String s1,String s2){
	    int len=s1.length()>s2.length()?s2.length():s1.length(),i=0;
	    while(i<len && s1.charAt(i)==s2.charAt(i))
	        i++;
	    return s1.substring(0,i);
	}
/*
 * 15. 三数之和
 */
public List<List<Integer>> threeSum(int[] nums) {
	Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
            int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
        }
    }
    return list; 
}
	
	
	/**
	 * 20. 有效的括号 
	 * 可以利用栈的特点进行求解   
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
			case '[':
			case '{':
				stack.push(s.charAt(i));			
				break;
			case ')':
				if (stack.isEmpty()||stack.lastElement()!='(') return false; 
					stack.pop();break;
			case ']':
				if (stack.isEmpty()||stack.lastElement()!='[') return false;
					stack.pop();break;
					
			case '}':
				if (stack.isEmpty()||stack.lastElement()!='{') return false;
					stack.pop();break;
		}	
		}
		return stack.isEmpty();  
	}
/*
 * 21.合并两个有序链表 
 */
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode node = new ListNode(0);
	ListNode p=node;	
	while (l1!=null&&l2!=null) {
		//如果l1指针当前的值小，那就把l1的当前值加入合并链表
		if (l1.val<l2.val) {
			p.next=l1;
			p=p.next;
			l1=l1.next;
		}else {
		//如果l2指针当前的值小，那就把l2的当前值加入合并链表
			p.next=l2;
			p=p.next;
			l2=l2.next;
		}		
	}
	//当有一个链表遍历完，另一个还没有遍历完，那就把另一个直接加到合并链表的末尾
	if (l1==null) {
		p.next=l2;
	}else {
		p.next=l1;
	}
		return node.next;      
    }

	/**
	 * 26. 删除排序数组中的重复项
	 * @param nums
	 * @return
	 */
			
	public  static int removeDuplicates(int[] nums) {
		int j=0;
		if (nums.length>0){
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i]!=nums[i+1]) {
				nums[j++]=nums[i];
			}
		}
			nums[j++]=nums[nums.length-1];
		}
		return j;
	    
	}
	 /**
	  * 27. 移除元素
	  * @param args
	  */
	 public static int removeElement(int[] nums, int val) {
	 	int j=0;
	     for (int i = 0; i < nums.length; i++) {
	 		if (nums[i]!=val) {
	 			nums[j++]=nums[i];			
	 		}
	 	}
	     return j;
//	 	int[] N=nums;
//	 	int j=0;
//	 	for (int i = 0; i < nums.length; i++) {
//	 		if (nums[i]==val) {
//	 			N[i]=N[i++];
//	 			 j=N.length-1;
//	 		}
//	 		
//	 	}
//	 	System.out.println(j);
	 //	
//	 	return j;
	 	
	 	
	 }
	 /**
	  * 28.实现strStr()
	  * @param args
	  */

	 public static int strStr(String haystack, String needle) {
	 	
//	 	if (needle.equals("")||needle==null) {
//	 		return 0;		
//	 	}
//	 	return haystack.indexOf(needle)>=0?haystack.indexOf(needle):-1;
//	      
	 	return haystack.indexOf(needle);
	 }
	 /**
	  * 35.搜索插入位置
	  * @param args
	  */
	 public  static int searchInsert(int[] nums, int target) {
		 
		 for (int i = 0; i < nums.length; i++) {
			if (target==nums[i]) {
				return i;
			}else if (target<nums[i]) {
				return i-1;
			}			
			}
		 return nums.length;
		}

/**
* 38.报数
* @param args
*/
	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String lastlist = countAndSay(n - 1) + "0";// 上一列数
		//System.out.println("lastlist:" + lastlist);
		String result = "";
		int count = 0;
		for (int i = 0; i < lastlist.length() - 1; i++) {
			count++;
			if (lastlist.charAt(i) != lastlist.charAt(i + 1)) {
				result += count + "" + lastlist.charAt(i);
				count = 0;
			}
		}
		return result;
	}
/*
 * 43. 字符串相乘
 */
public static String multiply(String num1, String num2) {
	if (num1.length()<num2.length()) {
		String tmp = num1;
		num1=num2;
		num2=tmp;	
	}
	String res = "",str="",str1="0";
	int num=0;
	int jinwei=0,benwei=0; int ji=0;
	for (int i = num2.length()-1; i >=0; i--) {
		str =  multiplysimple(num1, num2.substring(i,i+1));		
		res=str1.substring(str1.length()-1, str1.length())+res;//最后一位放入结果中
		str1=multiadd(str1.substring(0, str1.length()-1), str);		
	}
	if(!str.equals("0")) {
	res=str+res;
	}
	return res;        
    }
public static String multiplysimple(String num1,String num) {
	String res = "";
	if (num.equals("0")) {
		return num;
	}
	int jinwei=0,benwei=0,ji=0;
	for (int i = num1.length()-1; i>=0; i--) {
		ji=Integer.parseInt(num1.substring(i, i+1))*Integer.parseInt(num)+jinwei;
		benwei = ji%10;
		jinwei = ji/10;
		res=benwei+res;
	}
	if (jinwei!=0) {
		res=jinwei+res;
	}	
	return res;
}

public static String multiadd(String num1,String num2) {
	String res="";
	int len=Math.min(num1.length(),num2.length());
	int he=0,benwei=0,jinwei=0;
	int i=0,j=0;
	for (i = num1.length()-1,j = num2.length()-1;i>=num1.length()-len&&j>=num2.length()-len; i--,j--) {
			he=Integer.parseInt(num1.substring(i, i+1))+Integer.parseInt(num2.substring(j, j+1))+jinwei;
			benwei=he%10;
			jinwei = he/10;
			res=benwei+res;
		}
		for (i=num1.length()-len-1;i>=0;i--) {
			he=jinwei+Integer.parseInt(num1.substring(i, i+1));
			benwei=he%10;
			jinwei = he/10;
			res=benwei+res;
		}
		for (j=num2.length()-len-1;j>=0;j--) {
			he=jinwei+Integer.parseInt(num2.substring(j, j+1));
			benwei=he%10;
			jinwei = he/10;
			res=benwei+res;
		}
		if (jinwei!=0) {
			res=jinwei+res;
		}		
	return res;	
}
/*
 * 49. 字母异位词分组	
 */
 public List<List<String>> groupAnagrams(String[] strs) {
	 Map<String,ArrayList<String>> map=new HashMap<>();
     for(String s:strs){
         char[] ch=s.toCharArray();
         Arrays.sort(ch);
         String key=String.valueOf(ch);
         if(!map.containsKey(key))    map.put(key,new ArrayList<>());
         map.get(key).add(s);
     }
     return new ArrayList<List<String>>(map.values());
   }
 
 public static void main(String[] args) {
	 String s = "A";
	// convert(s, 1);
}
 
}