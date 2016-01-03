import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {

    static int[] getClosest(Point2D.Double[] points)
    {
        int[] result = new int[2];
        int size = points.length;
        double min = Double.MAX_VALUE;
        int one = -1;
        int two = -1;
        double[] t = new double[size];
        for(int k =0;k <size;k ++){
        	double ts = Math.pow(points[k].x, 2)+Math.pow(points[k].y, 2);
        	t[k] = Math.sqrt(ts);
        }
        for(int i = 0;i < size;i ++){
        	for(int j = i+1;j < size;j ++){
        		if(Math.abs(t[j]-t[i])>min)continue;
        		double temp = Math.pow(points[j].x - points[i].x, 2)+Math.pow(points[j].y - points[i].y, 2);
        		double dis = Math.sqrt(temp);
        		if(dis < min){
        			min = dis;
        			one = i;
        			two = j;
        		}
        			
        	}
        }
        result[0] = one;
        result[1] = two;
        return result;
    }
    
    public static void main(String[] args) {
        Point2D.Double[] points;
        Scanner input = new Scanner(System.in);
        {
            int n = input.nextInt();
            input.nextLine();
            points = new Point2D.Double[n];
            for (int i = 0; i < n; ++i) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                input.nextLine();
                points[i] = new Point2D.Double(x, y);
            }
        }
        int[] result = getClosest(points);
        System.out.printf("Closest points: %d, %d\n", result[0], result[1]);
    }
}