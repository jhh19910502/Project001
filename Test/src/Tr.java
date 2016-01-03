import java.util.Scanner;


public class Tr {
	public static void getRst(int[][] a,int col,int row){
		int max = 0;
		int first=0,second=0,third=0,fourth=0;
		boolean changed = false;
		for(int i = 0;i<col-1;i++)
			for(int j=0;j<row-1;j++){
				int sum = a[i][j]+a[i][j+1]+a[i+1][j]+a[i+1][j+1];
				if(sum>max){
					changed = true;
					max = sum;
					first = a[i][j];
					second = a[i][j+1];
					third = a[i+1][j];
					fourth = a[i+1][j+1];
				}
					
			}
		if(changed)
			System.out.println(first + " "+second+" "+third+" "+fourth);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String rst = scan.nextLine();
		String[] s = rst.split(";");
		int col = s.length;
		int row = s[0].split(" ").length;
		int[][] a = new int[col][row];
		for(int i = 0;i < col;i ++){
			String[] temp = s[i].split(" ");
			for(int j = 0;j < row;j ++){
				a[i][j] = Integer.valueOf(temp[j]);
			}
		}
		getRst(a,col,row);
		scan.close();

	}

}
