/**
 * RC4算法的java语言实现，运行环境为J2SE-1.5
 * 拥有JRE环境时双击RC4.bat可以直接运行结果
 * 版本：v1.0
 * 完成时间：2014-10-16 22:39:55
 * @author 毛宇锋
 * */
import java.util.*;
public class RC4_Encrypt {
	static Scanner sc=new Scanner(System.in);
	static int []S= new int[256];
	static int[] key;
	static int []c;
	static int[]p;
	/**
	 * 交换数组S中两个数字的位置
	 * @param int i 第一个数字的位置，int j 第二个数字的位置
	 * @return void
	 * */
	static void swap(int i,int j)
	{
		int temp=S[i];
		S[i]=S[j];
		S[j]=temp;
	}
	/**
	 * 密钥调度算法
	 * @param int[] key密钥
	 * @return void
	 * */
	static void KSA(int []key)
	{
		for(int i=0;i<256;i++)
			S[i]=i;
		int j=0;
		for(int i=0;i<256;i++)
		{
			j=(j+S[i]+key[i % key.length])%256;
			swap(i,j);
		}
	}
	/**
	 * 加密解密算法
	 * @param int []key 密钥，int []p原文，int []c密文
	 * @return void
	 * */
	static void encrypt(int []key,int []p,int []c)
	{
		KSA(key);
		int i=0;
		int j=0;
		int count=0;
		for (int temp : p) {
			i=(i+1)%256;
			j=(j+1)%256;
			swap(i,j);
			int k=S[(S[i]+S[j])%256];
			c[count]=temp^k;
			count++;
		}
	}
	public static void main(String[] args) 
	{
		key=new int[]{1,2,3,4,5,6,7,8,9,10};
		p=new int[]{10,9,8,7,6,5,4,3,2,1};
		c=new int[10];
		encrypt(key, p, c);
		System.out.println("\n======================加密===========================");
		for (int i : c) {
			System.out.print(i+" ");
		}
		System.out.println("\n======================解密===========================");
		int []p2=new int[]{79, 166 ,157, 43, 153, 99, 95, 253, 90 ,180 };
		int []c2=new int[10];
		encrypt(key, p2, c2);
		for (int i : c2) {
			System.out.print(i+" ");
		}
	}
}
