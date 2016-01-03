import java.util.Scanner;


public class Ball {
	public long getRst(long r,long x,long y,long x1,long y1){
		double el = Math.pow((double)y1-y, 2)+Math.pow((double)y1-y, 2);
		double len = Math.sqrt(el);
		long num = (long)Math.ceil(len/(3*r));
		return num;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long r = scan.nextLong();
		long x = scan.nextLong();
		long y = scan.nextLong();
		long x1 = scan.nextLong();
		long y1 = scan.nextLong();
		Ball b = new Ball();
		long rst = b.getRst(r, x, y, x1, y1);
		System.out.println(rst);
		scan.close();
	}

}
