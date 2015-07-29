/**
 * RC4�㷨��java����ʵ�֣����л���ΪJ2SE-1.5
 * ӵ��JRE����ʱ˫��RC4.bat����ֱ�����н��
 * �汾��v1.0
 * ���ʱ�䣺2014-10-16 22:39:55
 * @author ë���
 * */
import java.util.*;
public class RC4_Encrypt {
	static Scanner sc=new Scanner(System.in);
	static int []S= new int[256];
	static int[] key;
	static int []c;
	static int[]p;
	/**
	 * ��������S���������ֵ�λ��
	 * @param int i ��һ�����ֵ�λ�ã�int j �ڶ������ֵ�λ��
	 * @return void
	 * */
	static void swap(int i,int j)
	{
		int temp=S[i];
		S[i]=S[j];
		S[j]=temp;
	}
	/**
	 * ��Կ�����㷨
	 * @param int[] key��Կ
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
	 * ���ܽ����㷨
	 * @param int []key ��Կ��int []pԭ�ģ�int []c����
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
		System.out.println("\n======================����===========================");
		for (int i : c) {
			System.out.print(i+" ");
		}
		System.out.println("\n======================����===========================");
		int []p2=new int[]{79, 166 ,157, 43, 153, 99, 95, 253, 90 ,180 };
		int []c2=new int[10];
		encrypt(key, p2, c2);
		for (int i : c2) {
			System.out.print(i+" ");
		}
	}
}
