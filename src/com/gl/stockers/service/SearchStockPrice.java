package com.gl.stockers.service;

public class SearchStockPrice {
	public int value, l, r, mid;
	public double array[];

	/*
	 * Binary Search searches the element in a sorted array. Sorted array is passed
	 * from the Driver class. Elements are sorted using merge sort
	 */
	public void implementationOfBinarySearch(double array[], double value) {
		l = 0;
		r = array.length - 1;
		// Find the middle element of an array
		mid = l + (r - l) / 2;
		while (l <= r) {
			if (value < array[mid]) {
				// search in left sub array
				r = mid - 1;
			} else if (value > array[mid]) {
				/// search in right sub array
				l = mid + 1;
			} else {
				System.out.println("Stock of value " + value + " is present ");
				break;
			}
			mid = l + (r - l) / 2;
		}
		if (l > r) {
			System.out.println("Value not found");
		}
	}
}