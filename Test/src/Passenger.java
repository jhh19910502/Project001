import java.util.Scanner;


public class Passenger {
	public int getRst(int[] a,int n,int m){
		int[] count = new int[n];
		for(int i = 0;i < n;i ++){
			count[i] = 0;
		}
		for(int j = 0;j < n;){
			if(a[j]>=m){
				if(a[j]%m==0)
					count[j] = a[j]/m;
				else
					count[j] = a[j]/m + 1;
				j ++;
			}else{
				int sum = a[j];
				int k=j;
				for(;k < n;k ++){
					if(sum < m){
						sum += a[k];
						count[k] = 1;
					}
				}
				j =k-1;
			}
		}
		int rst = 0;
		for(int p=0;p<n;p++){
			rst+=count[p];
		}
		return rst;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scan.nextInt();
		}
		Passenger p = new Passenger();
		int rst = p.getRst(arr,n,m);
		System.out.println(rst);
		

	}

}
