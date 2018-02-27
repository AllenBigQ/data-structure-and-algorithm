package com.lucky2.day01;

public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = m.toCharArray();
		int i1 = 0;
		int i2 = 0;
		int[] next = getNextArray(str2);
		while (i1 < str1.length && i2 < str2.length) {
			if (str1[i1] == str2[i2]) {
				i1++;
				i2++;
			} else if (next[i2] == -1) {
				i1++;
			} else {
				i2 = next[i2];
			}
		}
		return i2 == str2.length ? i1 - i2 : -1;
	}

	public static int[] getNextArray(char[] str2) {
		if (str2.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[str2.length];
		next[0] = -1;
		next[1] = 0;
		//0，1位置规定完，i从2位置开始往下求
		int i = 2;
		//cn为要跳到哪个位置
		int cn = 0;
		while (i < next.length) {
			//如果当前位置的前一个位置和跳到的位置相同
			if (str2[i - 1] == str2[cn]) {
				//当前位置的next值就等于cn+1，然后i++
				next[i++] = ++cn;
				//如果当前位置的前一个值和跳到的位置不同则：
				//如果cn>0说明还可以继续往前跳
			} else if (cn > 0) {
				//cn跳到next[cn]值的位置
				cn = next[cn];
			} else {
				//cn已经为负，不能再继续跳，则这个位置的next值为0
				next[i++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}

