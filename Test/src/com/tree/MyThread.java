/**   
* @Title: MyThread.java 
* @Package com.tree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 姜辉晖 
* @email 787279102@qq.com   
* @date Nov 9, 2015 9:25:20 PM 
* @version V1.0   
*/
package com.tree;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MyThread implements Runnable {
	private static int num = 1;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+":"+num);
		num ++;
	}
	public static void main(String[] args){
		short a = 1;
		a += 1;
		System.out.println(a);
//		Thread t1 = new Thread(new MyThread());
//		Thread t2 = new Thread(new MyThread());
//		Thread t3 = new Thread(new MyThread());
//		while(num <= 100){
//			t3.start();
//			t2.start();
//			t1.start();
//		}
	}
}
