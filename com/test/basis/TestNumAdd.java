package com.test.basis;

import java.util.Scanner;
/*
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 
 * 程序分析：关键是计算出每一项的值。
 */
public class TestNumAdd {
	public static void main(String[] args) {
		System.out.println("请输入数字0-9:");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println("请输入数字重复次数");
		int n = scanner.nextInt();
		int sum=0;
		for (int i = n; i>0; i--) {
			sum+=a*i*Math.pow(10, (n-i));		
		}
		System.out.println("sum="+sum);	
	}
}
