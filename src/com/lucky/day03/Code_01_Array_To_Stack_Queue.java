package com.lucky.day03;
/**
 * 
 * @author Allen
 * 用数组结构实现大小固定的栈和队列
 */
public class Code_01_Array_To_Stack_Queue {

	public static class ArrayStack {
		private Integer[] arr;
		//此时数组中的容量
		private Integer size;
		//初始化的时候设置这个栈的大小
		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}
		//返回顶部的数值
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size - 1];
		}
		//压入一个数
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[size++] = obj;
		}
		//取出一个数
		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--size];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		//此时数组中存有多少个数
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		//压入一个数
		public void push(int obj) {
			//如果size等于数组大小，说明数组已经满了
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			//数组没满则size+1
			size++;
			//将这个数加入到last的数组位置
			arr[last] = obj;
			//如果last=arr.length-1说明last已经到达数组最后一个位置
			//使last=0，重新开始，否则last+1向下一个位置移动
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		//取出一个数
		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {
		
	}

}

