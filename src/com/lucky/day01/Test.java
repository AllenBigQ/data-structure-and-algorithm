package com.lucky.day01;

public class Test {
	public static void swap1(int x){
		System.out.println("x="+x);
	}
	public static void swap2(int x){
		System.out.println("x="+x);
	}
	public static void main(String[] args) {
		int x=0;
		for (int i = 0; i < 3; i++) {
			swap1(++x);
		}
		System.out.println(x);
		x=0;
		for (int i = 0; i < 3; i++) {
			swap1(x+++1);
		}
		System.out.println(x);
	}
}
