package com.lucky.day03;

public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		//fromUp刚开始为false，表示从左下方向右上方的顺序开始打印
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR = tC == endC ? tR + 1 : tR;
			tC = tC == endC ? tC : tC + 1;
			dC = dR == endR ? dC + 1 : dC;
			dR = dR == endR ? dR : dR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int row1, int col1, int row2, int col2,
			boolean f) {
		if (f) {
			while (row1 != row2 + 1) {
				System.out.print(m[row1++][col1--] + " ");
			}
		} else {
			while (row2 != row1 - 1) {
				System.out.print(m[row2--][col2++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}

