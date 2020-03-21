package com.test.basis;
/*
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class TestBall {
	public static void main(String[] args) {
		double a=100;
		double sum=100;
		for (int i = 2; i <=10; i++) {
			a=a*0.5;
			sum+=a*2;
		}
		System.out.println("第10次反弹a="+a+"米");
		System.out.println("第10次落地经过sum="+sum+"米");
	}
}
