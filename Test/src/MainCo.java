import java.util.Scanner;


public class MainCo {
	public static void getRst(int[] a,int n){
		int start = -1;
		int end = -1;
		int count = 0;
		int max = 0;
		for(int i = 0;i < n;i ++){
			for(int j = n-1;j >= i;j --){
				int sum = 0;
				count = 0;
				for(int k = i;k <= j;k ++){
					sum += a[k];
					count ++;
				}
				if(sum == 0 && count > max){
					start = i;
					end = j;
					max = count;
					count = 0;
				}
			}
		}
		if(start!= -1 && end != -1){
			for(int q = start;q<=end;q++)
				System.out.println(a[q] + " ");
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String rst = scan.nextLine();
		String[] s = rst.split(" ");
		int len = s.length;
		int[] a = new int[len];
		for(int i = 0;i < len;i ++){
			a[i] = Integer.valueOf(s[i]);
		}
		getRst(a,len);
		scan.close();
	}

}
