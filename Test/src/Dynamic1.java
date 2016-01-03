import java.util.Scanner;


public class Dynamic1 {
	public static double getMin(double x,double y){
		return x < y? x : y;
	}
	public static double getRst(int x,int y,int z){
		if(x == 0 && y == 0 && z == 0){
			return 0.0;
		}else if(x != 0 && y == 0 && z == 0){
			return 60*0.95 + getRst(x-1,0,0);
		}else if(x == 0 && y != 0 && z == 0){
			return 60*0.95 + getRst(0,y-1,0);
		}else if(x == 0 && y == 0 && z != 0){
			return 60*0.95 + getRst(0,0,z-1);
		}else if(x != 0 && y != 0 && z == 0){
			double s1 = 60*0.95 + getRst(x-1,y,0);
			double s2 = 60*0.95 + getRst(x,y-1,0);
			double s3 = 120*0.9 + getRst(x-1,y-1,0);
			return getMin(getMin(s1,s2),s3);
		}else if(x != 0 && y == 0 && z != 0){
			double s1 = 60*0.95 + getRst(x-1,0,z);
			double s2 = 60*0.95 + getRst(x,0,z-1);
			double s3 = 120*0.9 + getRst(x-1,0,z-1);
			return getMin(getMin(s1,s2),s3);
		}else if(x == 0 && y != 0 && z != 0){
			double s1 = 60*0.95 + getRst(0,y-1,z);
			double s2 = 60*0.95 + getRst(0,y,z-1);
			double s3 = 120*0.9 + getRst(0,y-1,z-1);
			return getMin(getMin(s1,s2),s3);
		}else{
			double s1 = 60*0.95 + getRst(x-1,y,z);
			double s2 = 60*0.95 + getRst(x,y-1,z);
			double s3 = 60*0.95 + getRst(x,y,z-1);
			double s4 = 120*0.9 + getRst(x-1,y-1,z);
			double s5 = 120*0.9 + getRst(x-1,y,z-1);
			double s6 = 120*0.9 + getRst(x,y-1,z-1);
			double s7 = 180*0.85 + getRst(x-1,y-1,z-1);
			double min1 = getMin(s1,s2);
			double min2 = getMin(s3,s4);
			double min3 = getMin(s5,s6);
			double min4 = getMin(min3,s7);
			double min5 = getMin(min1,min2);
			double min = getMin(min4,min5);
			return min;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		scan.close();
		double rst = getRst(x,y,z);
		System.out.println("rst="+rst);
	}

}
