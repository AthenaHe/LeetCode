package com.test.basis;
import java.util.Scanner;
/*
 * #兔子繁殖问题#
 * 有一对兔子，从出生后的第3个月开始每个月都生一对小兔子，
 * 小兔子长到第三个月之后每个月又生一对兔子， 假如兔子不死，
 * 问每个月的兔子数为多少？
 * ==斐波那契数列求值问题
 */
public class TestRabbit {
	//方法1.迭代实现
	public void fib1(int month) {
		int f1=0,f2=1,f;
		for (int i = 1; i <=month; i++) {
			f=f1+f2;
			f1=f2;
			f2=f;
			System.out.println("第"+i+"个月的兔子对数为："+f2);
		}
	}	
	//方法2.递归实现
	public int fib2(int month) {
		if (month==1||month==2) {
			return 1;
		}
		return fib2(month-1)+fib2(month-2);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int month=scanner.nextInt();
		TestRabbit main = new TestRabbit();
		main.fib1(month);
//			for (int i = 1; i <=month; i++) {
//				System.out.println("第"+i+"个月的兔子对数为："+main.fib2(month));	
//			}			
	}	
}
