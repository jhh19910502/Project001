import java.util.Scanner;


public class Dynamic2 {
	public static int getMax(int a,int b){
		return a>b?a:b;
	}
	public static int getRst(int c,int num,int[] w,int[] v){
		if(c <=0 || num < 0)
			return 0;
		else{
			int a = 0;
			if(c >= w[num])
				a = v[num] + getRst(c-w[num],num-1,w,v);
			int b = getRst(c,num-1,w,v);
			int max = getMax(a,b);
			return max;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int num = scan.nextInt();
		int[] v = new int[num];
		int[] w = new int[num];
		for(int i = 0;i < num;i ++){
			w[i] = scan.nextInt();
			v[i] = scan.nextInt();
		}
		scan.close();
		int rst = getRst(c,num-1,w,v);
		System.out.println("rst="+rst);
	}

}
