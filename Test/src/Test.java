import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Test{
	public int getMax(int[] a){
		int maxSeq = Integer.MIN_VALUE;
		int max = 0;
		int start = 0,end = 0;
		for(int i = 0;i < a.length;i ++){
			if(a[i] > 0){
				max += a[i];
			}
			else{
				start = i;
				max = a[i];
			}
			if(max > maxSeq){
				end = i;
				maxSeq = max;
			}
		}
		System.out.println("start="+start+",end="+end);
		return maxSeq;
		
	}
	public int getRst(int[] a){
		if(a == null || a.length < 1)
			return 0;
		int[] d = new int[a.length];
		d[0] = 1;
		for(int i = 1;i < a.length;i ++){
			int max = 0;
			for(int j = 0;j < i;j ++){
				if(a[j] < a[i] && d[j] > max){
					max = d[j];
				}
			}
			d[i] = max + 1;
		}
		int rst = 0;
		int pos = 0;
		for(int i = 0;i < a.length;i ++){
			if(d[i] > rst){
				rst = d[i];
				pos = i;
			}
		}
		if(pos == 0)System.out.println(a[pos]);
		else{
			Stack<Integer> s = new Stack<Integer>();
			s.push(a[pos]);
			int tmp = d[pos] - 1;
			int p = a[pos];
			for(int j = pos-1;j >= 0;j --){
				if(a[j] < p && d[j] == tmp){
					s.push(a[j]);
					p = a[j];
					tmp --;
				}
			}
			while(!s.empty()){
				System.out.print(s.peek()+" ");
				s.pop();
			}
			System.out.println();
		}
		return rst;
	}
	private List<String> list = new ArrayList<String>();
	public void combine(String str){
		if(str == null)
			return;
		char[] ch = str.toCharArray();
		Stack<Character> s = new Stack<Character>();
		for(int i = 1;i <= ch.length;i ++){
			combi(ch,0,i,s);
		}
	}
	public void combi(char[] ch,int start,int number,Stack<Character> stack){
		if(number == 0){
			StringBuilder st = new StringBuilder("");
			Iterator<Character> it  = stack.iterator();
			while(it.hasNext()){
				st.append(it.next());
			}
			list.add(st.toString());
		}else if(start == ch.length){
			return;
		}else{
			stack.push(ch[start]);
			combi(ch,start+1,number-1,stack);
			stack.pop();
			combi(ch,start+1,number,stack);
		}
			
	}
	public static void main(String[] args) throws Exception, RuntimeException {
//		int[] a = {-1,5,2,3,8,-1,6,8,9,10,12};
//		Class c = Test.class;
//		Method m = c.getMethod("getMax", int[].class);
//		Object obj = c.getConstructor(null).newInstance(null);
//		m.invoke(obj, a);
//		Test t = new Test();
//		t.combine("edbca");
//		for(String s:t.list){
//			System.out.println(s);
//		}
		Class<?> c = Test.class;
		Method[] mt = c.getDeclaredMethods();
		for(int i = 0;i < mt.length;i ++){
			int num = mt[i].getModifiers();
			System.out.print(Modifier.toString(num)+" ");
			Class<?> ct = mt[i].getReturnType();
			System.out.print(ct+" ");
			Class<?>[] c1 = mt[i].getParameterTypes();
			System.out.print(mt[i].getName()+"(");
			int argNum = 0;
			for(int j = 0;j < c1.length;j ++){
				String tmp = "arg" + argNum;
				System.out.print(c1[j].getName()+" "+tmp);
				if(j != c1.length - 1)
					System.out.print(",");
				argNum ++;
			}
			System.out.print(")");
			System.out.println();
		}
		
		Class<?> cl = Test.class;
		Method m = c.getDeclaredMethod("getMax", int[].class);
		Object obj = cl.newInstance();
		m.invoke(obj, new int[]{-1,5,2,3,8,-1,6,8,9,10,12});
	}
}