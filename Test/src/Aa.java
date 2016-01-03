
public class Aa {
	public static void getRst(int[] a,int len){
		int fir = a[0];
		int sec = -(1>>32);
		for(int i = 0 ;i < len;i ++){
			if(a[i] > fir){
				sec = fir;
				fir = a[i];
			}else if(a[i]>sec){
				sec = a[i];
			}
		}
		System.out.println("最大数为:"+fir);
		System.out.println("第二大数为:"+sec);
	}
	public static void findMax(int[] a,int len){
		int sum = -(1<<10);
		for(int i = 0;i < len;i ++){
			int max = -(1<<10);
			int temp = 0;
			for(int j = i;j < len;j ++){
				temp += a[j];
				if(temp > max)
					max = temp;
			}
			if(sum < max)
				sum = max;
		}
		System.out.println("sum="+sum);
	}
	public static int max(int a,int b){
		return a > b ? a : b;
	}
	public static void findMaxDy(int[] a,int n){
		if(n == 1){
			System.out.println("sum="+a[0]);
			return;
		}
		int[] end = new int[n];
		int[] all = new int[n];
		end[0] = all[0] = a[0];
		for(int i = 1;i < n;i ++){
			end[i] = max(end[i-1]+a[i],a[i]);
			all[i] = max(all[i-1],end[i]);
		}
		System.out.println("sum="+all[n-1]);
	}
	public static void main(String[] args) {
		int[] a = {1,-2,4,8,-4,7,-1,-5};
		//findMaxDy(a,a.length);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(1<<2);
		/*
		int[] a={1,5,9,2,3,8,19,21,27,14,9,23,16,20,11,2};
		getRst(a,a.length);
		*/
	}

}
