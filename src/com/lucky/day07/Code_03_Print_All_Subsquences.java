package com.lucky.day07;
/**
 * 
 * @author Allen
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}

