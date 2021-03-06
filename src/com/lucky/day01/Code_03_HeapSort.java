package com.lucky.day01;

import java.util.Arrays;
/**
 * 
 * @author Allen
 * 堆排序
 */
public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//将数组调成为大根堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		//size是堆的大小
		int size = arr.length;
		//0位置和堆最后一个位置上的数交换，size减一，
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}
	//数组刚开始是堆结构，但不一定是大根堆结构所以这一步先调整成大根堆
	//例如数组是5 7 0 6 8，调整成大根堆后是8 7 0 5 6	,index从0或者从1开始都是可以的
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	//index表示我从哪个位置开始heapify(英译堆化),size代表堆得大小是多少(不是数组的大小)
	public static void heapify(int[] arr, int index, int size) {
		//left代表index的左孩子的位置
		int left = index * 2 + 1;
		//left左孩子小于size说明没越界
		while (left < size) {
			//left+1代表index右孩子的位置
			//右孩子不越界并且右孩子位置的值大于左孩子位置的值
			//那么这个最大值的位置就是右孩子，否则就是左孩子
			//简单说就是取出我的左右孩子中较大孩子的下标
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//这个largest位置的值和父节点的值比较，取出较大的下标
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}

