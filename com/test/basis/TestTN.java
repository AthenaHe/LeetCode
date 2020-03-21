package com.test.basis;
/*
 * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */
public class TestTN {
	//数字1，2，3，4组成三位数
	public static void main(String[] args) {
		int i=0;//保存百位上的数字
		int j=0;//保存十位上的数字
		int k=0;//保存个位上的数字
		int n=0;//保存数字的个数
		for (i = 1; i <=4; i++) {
			for (j = 1; j <=4; j++) {
				for (k = 1; k <=4; k++) {
					if (i!=j&&j!=k&&i!=k) {
						n+=1;
						System.out.print(i*100+j*10+k+" ");
					}	
				}				
			}			
		}
		System.out.println("\n总共能够组成"+n+"个数字");
	}
	/*//数字1，2，3，0组成三位数
	public static void main(String[] args) {
		int i=0;//保存百位上的数字
		int j=0;//保存十位上的数字
		int k=0;//保存个位上的数字
		int n=0;//保存数字的个数
		for (i = 1; i <=3; i++) {
			for (j = 0; j <=3; j++) {
				for (k = 0; k <=3; k++) {
					if (i!=j&&j!=k&&i!=k) {
						n+=1;
						System.out.print(i*100+j*10+k+" ");
					}	
				}				
			}			
		}
		System.out.println("\n总共能够组成"+n+"个数字");
	}*/
}
