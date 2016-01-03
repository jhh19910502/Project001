package com.tree;

class Node{
	Node left,right;
	int nodeValue;
	boolean sh;
}
class QueueNode{
	QueueNode next;
	Node nodeValue;
}
class Queue{
	private QueueNode front,back;
	private int num;
	Queue(){
		front = null;
		back = null;
		num = 0;
	}
	Queue(QueueNode n){
		front = back = n;
		num = 1;
	}
	public QueueNode get(){
		if(num == 0)
			return null;
		else if(this.num == 1){
			QueueNode tmp = front;
			num = 0;
			front = back = null;
			return tmp;
		}else{
			QueueNode tmp = front;
			front = front.next;
			num--;
			return tmp;
		}
	}
	public void put(QueueNode node){
		if(num == 0){
			front = back = node;
		}else{
			back.next = node;
			back = back.next;
		}
		num++;
	}
	public int getNum(){
		return num;
	}
}
class Stack{
	private Node[] arr;
	private int top;
	private int num;
	Stack(){
		arr = new Node[20];
		top = -1;
		num = 0;
	}
	public Node pop(){
		if(num == 0)
			return null;
		else{
			Node tmp = arr[top];
			num --;
			top --;
			return tmp;
		}
	}
	public void push(Node node){
		if(num < 20){
			top ++;
			arr[top] = node;
			num++;
		}
	}
	public int getNum(){
		return num;
	}
}
public class Tree {
	public static int getNum(Node root){
		if(root == null)
			return 0;
		else
			return getNum(root.left)+getNum(root.right)+1;
	}
	public static int getDis(Node root){
		if(root == null)
			return 0;
		else{
			int left = getDis(root.left);
			int right = getDis(root.right);
			int max = left>right?left:right;
			return 
					max+1;
					
		}
	}
	public static void preOrder(Node node){
		if(node != null){
			System.out.print(node.nodeValue);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	public static void fdgPreOrder(Node node){
		if(node != null){
			Stack st = new Stack();
			while(node != null || st.getNum() > 0){
				while(node != null){
					System.out.print(node.nodeValue);
					st.push(node);
					node = node.left;
				}
				node = st.pop();
				node = node.right;
			}
		}
	}
	public static void midOrder(Node node){
		if(node != null){
			midOrder(node.left);
			System.out.print(node.nodeValue);
			midOrder(node.right);
		}
	}
	public static void fdgMidOrder(Node node){
		if(node != null){
			Stack st = new Stack();
			while(node != null || st.getNum() > 0){
				while(node != null){
					st.push(node);
					node = node.left;
				}
				node = st.pop();
				System.out.print(node.nodeValue);
				node = node.right;
			}
		}
	}
	public static void lastOrder(Node node){
		if(node != null){
			lastOrder(node.left);
			lastOrder(node.right);
			System.out.print(node.nodeValue);
		}
	}
	public static void fdgLastOrder(Node node){
		if(node != null){
			Stack st = new Stack();
			while(node != null || st.getNum() > 0){
				while(node != null){
					System.out.print(node.nodeValue);
					st.push(node);
					node = node.left;
				}
				node = st.pop();
				node = node.right;
			}
		}
	}
	public static void levelOrder(Node node){
		Queue my = new Queue();
		if(node != null){
			QueueNode n = new QueueNode();
			n.next = null;
			n.nodeValue = node;
			my.put(n);
			while(my.getNum()>0){
				QueueNode tmp = my.get();
				System.out.print(tmp.nodeValue.nodeValue);
				if(tmp.nodeValue.left != null){
					QueueNode tp = new QueueNode();
					tp.next = null;
					tp.nodeValue = tmp.nodeValue.left;
					my.put(tp);
				}
				if(tmp.nodeValue.right != null){
					QueueNode tp = new QueueNode();
					tp.next = null;
					tp.nodeValue = tmp.nodeValue.right;
					my.put(tp);
				}
			}
		}
	}
	public  static void PreOrderTraseNonRecursion(Node t)
	{
		Stack s = new Stack();
		s.push(t);
		while(s.getNum() > 0)
		{
			Node p = s.pop();
			System.out.print(p.nodeValue);
			if(p.right != null)
				s.push(p.right);
			if(p.left != null)
				s.push(p.left);
		}
	}
	public static void main(String[] args) {
		
		Node n8 = new Node();
		n8.nodeValue = 8;
		n8.left = null;
		n8.right = null;
		Node n7 = new Node();
		n7.nodeValue = 7;
		n7.left = null;
		n7.right = null;
		Node n6 = new Node();
		n6.nodeValue = 6;
		n6.left = null;
		n6.right = null;
		Node n5 = new Node();
		n5.nodeValue = 5;
		n5.left = null;
		n5.right = n8;
		Node n4 = new Node();
		n4.nodeValue = 4;
		n4.left = n7;
		n4.right = null;
		Node n3 = new Node();
		n3.nodeValue = 3;
		n3.left = n6;
		n3.right = null;
		Node n2 = new Node();
		n2.nodeValue = 2;
		n2.left = n4;
		n2.right = n5;
		Node n1 = new Node();
		n1.nodeValue = 1;
		n1.left = n2;
		n1.right = n3;
		//int sum = getNum(n1);
		//int sum = getDis(n1);
		//System.out.println(sum);
		System.out.print("递归先序遍历:");
		preOrder(n1);
		System.out.println();
		System.out.print("非递归先序遍历:");
		PreOrderTraseNonRecursion(n1);
		//fdgPreOrder(n1);
		System.out.println();
		System.out.print("中序遍历:");
		midOrder(n1);
		System.out.println();
		System.out.print("非递归中序遍历:");
		fdgMidOrder(n1);
		System.out.println();
		System.out.print("后序遍历:");
		lastOrder(n1);
		System.out.println();
		System.out.print("层序遍历:");
		levelOrder(n1);
	}

}
