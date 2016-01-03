import java.util.Scanner;


class Trs {
	public static String getRst(String src,long times){
		String[] arr = src.split(" ");
		String[] date = arr[0].split("-");
		String[] time = arr[1].split(":");
		int size = date.length;
		long[] d = new long[size];
		long[] t = new long[size];
		for(int i = 0;i < size;i ++){
			d[i] = Long.valueOf(date[i]);
			t[i] = Long.valueOf(time[i]);
		}
		long tempSec = (t[2] + times)%60;
		long secL = (t[2] + times)/60;
		t[2] = tempSec;
		long tempMin = (t[1] + secL)%60;
		long minL = (t[1] + secL)/60;
		t[1] = tempMin;
		long tempHour = (t[0] + minL)%24;
		long hourL = (t[0] + minL)/24;
		t[0] = tempHour;
		return "";
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String src = scan.nextLine();
		String ti = scan.nextLine();
		Long times = Long.valueOf(ti);
		String dst = getRst(src,times);
		System.out.println(dst);
	}

}
