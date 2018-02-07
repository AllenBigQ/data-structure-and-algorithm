package com.lucky.day04;

import java.util.Stack;

public class Code_05_PreInPosTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	//递归版先序遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	//递归版中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}
	//递归版后序遍历
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}
	//非递归先序遍历
	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			//创建一个栈，将head节点压入栈里
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			//如果栈不为空则循环
			while (!stack.isEmpty()) {
				//栈里弹出一个元素，然后打印(第一次是把刚压入的头结点弹出)
				head = stack.pop();
				System.out.print(head.value + " ");
				//如果右孩子不为空则压入栈里
				if (head.right != null) {
					stack.push(head.right);
				}
				//如果左孩子不为空则压入栈里
				//先判断右再判断左，所以取出时就是先左再右
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	//非递归中序遍历
	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			//当栈不为空或者head不等于null的时候就执行
			while (!stack.isEmpty() || head != null) {
				//如果head不等于null就把head压入栈，并且head指向左孩子继续循环
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {	//如果head等于null，弹出栈顶元素head并打印，并且head指向右孩子继续循环
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}
	//非递归后序遍历
	public static void posOrderUnRecur1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			//创建两个栈
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			//先序遍历是中左右，设计出中右左，压入另一个栈再取出，就是左右中后序遍历
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		preOrderUnRecur(head);
		inOrderUnRecur(head);
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);

	}

}
