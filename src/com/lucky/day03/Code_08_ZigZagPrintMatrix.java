package com.lucky.day03;

public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int row1 = 0;
		int col1 = 0;
		int row2 = 0;
		int col2 = 0;
		int endRow = matrix.length - 1;
		int endCol = matrix[0].length - 1;
		//fromUp刚开始为false，表示从左下方向右上方的顺序开始打印
		boolean fromUp = false;
		while (row1 != endRow + 1) {
			printLevel(matrix, row1, col1, row2, col2, fromUp);
			//当col1等于endCol时，说明已经移动到最右边，row1+1，开始向下移动
			row1 = col1 == endCol ? row1 + 1 : row1;
			//当col1不等于endCol时，说明还没移动到最右，col1+1向右移动
			col1 = col1 == endCol ? col1 : col1 + 1;
			//当row2等于endRow时，说明已经移动到最下，col2+1向右移动
			col2 = row2 == endRow ? col2 + 1 : col2;
			//当row2等于endRow时，说明已经移动到最下，row2不变
			row2 = row2 == endRow ? row2 : row2 + 1;
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

