package com.lucky.day03;

public class Code_07_PrintMatrixSpiralOrder {
/**
 * 
 * @param matrix
 * 给定一个整型矩阵matrix，按照转圈的方式打印它。
 * 给定左上角和右下角的两个点，然后打印两个点所围城的这一圈数字
 * 然后两个点往圈内缩小，再继续打印，直到越界
 */
	public static void spiralOrderPrint(int[][] matrix) {
		int row1 = 0;
		int col1 = 0;
		int row2 = matrix.length - 1;
		int col2 = matrix[0].length - 1;
		while (row1 <= row2 && col1 <= col2) {
			printEdge(matrix, row1++, col1++, row2--, col2--);
		}
	}

	public static void printEdge(int[][] m, int row1, int col1, int row2, int col2) {
		//row1=row2说明矩阵只有一行
		if (row1 == row2) { 
			for (int i = col1; i <= col2; i++) {
				System.out.print(m[row1][i] + " ");
			}
		//col1=col2说明矩阵只有一列
		} else if (col1 == col2) { 
			for (int i = row1; i <= row2; i++) {
				System.out.print(m[i][col1] + " ");
			}
		} else { 
			//(curRow,curCol)代表当前要打印的点，从左上角开始打印
			int curRow = row1;
			int curCol = col1;
			//向右打印
			while (curCol != col2) {
				System.out.print(m[row1][curCol] + " ");
				curCol++;
			}
			//向下打印
			while (curRow != row2) {
				System.out.print(m[curRow][col2] + " ");
				curRow++;
			}
			//向左打印
			while (curCol != col1) {
				System.out.print(m[row2][curCol] + " ");
				curCol--;
			}
			//向上打印
			while (curRow != row1) {
				System.out.print(m[curRow][col1] + " ");
				curRow--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
