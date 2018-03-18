package com.lucky.offer66;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 
 * @author Allen
 *
 */
public class Solution1 {
	public boolean Find(int target, int[][] array) {
		int i = 0, j = array[0].length - 1;
		while (i < array.length && j > -1) {
			if(target<array[i][j]){
				j--;
			}else if(target>array[i][j]){
				i++;
			}else{
				return true;
			}
		}
		return false;
	}
	
}
