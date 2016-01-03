import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FuErMosi {
	public static void getRst(List<String> list) {
		char[] str1 = list.get(0).toCharArray();
		char[] str2 = list.get(1).toCharArray();
		char[] str3 = list.get(2).toCharArray();
		char[] str4 = list.get(3).toCharArray();
		int i=0,j=0;
		boolean find = false;
		int week = 0;
		int hour = 0;
		while(i < str1.length && j < str2.length){
			if(!find && str1[i] == str2[j] && str1[i] >= 'A' && str1[i] <= 'G'){
				week = str1[i] - 'A' + 1;
				find = true;
				i ++;
				j ++;
				continue;
			}
			if(find && str1[i] == str2[j] && (str1[i] >= 'A' && str1[i] <= 'N'||str1[i] >= '0' && str1[i] <= '9')){
				if(str1[i] >= '0' && str1[i] <= '9'){
					hour = str1[i] - '0';
				}else{
					hour = str1[i] - 'A' + 10;
				}
				break;
			}
			i ++;
			j ++;
		}
		 i = 0;
		 j = 0;
		 int sec = -1;
		 while(i < str3.length && j < str4.length){
			 sec ++;
			 if(str3[i] == str4[j] && (str3[i] >= 'A' && str3[i] <= 'Z' || str3[i] >= 'a' && str3[i] <= 'z')){
				 break;
			 }
			 i ++;
			 j ++;
		 }
		 StringBuffer str = new StringBuffer("");
		 switch(week){
		 case 1:
			 str.append("MON");
			 break;
		 case 2:
			 str.append("TUE");
			 break;
		 case 3:
			 str.append("WED");
			 break;
		 case 4:
			 str.append("THU");
			 break;
		 case 5:
			 str.append("FRI");
			 break;
		 case 6:
			 str.append("SAT");
			 break;
		 default:
			 str.append("SUN");
			 break;
		 }
		 if(hour < 10)
			 str.append(" 0").append(hour).append(":");
		 else
			 str.append(" ").append(hour).append(":");
		 if(sec < 10)
			 str.append("0").append(sec);
		 else
			 str.append(sec);
		 System.out.println(str.toString());
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < 4;i ++){
			list.add(scan.nextLine());
		}
		scan.close();
		getRst(list);
	}

}
