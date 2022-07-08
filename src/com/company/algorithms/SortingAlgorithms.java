package com.company.algorithms;

public class SortingAlgorithms {

	public static void bubbleSort(int[] array, boolean isAscending) {
		/*traverse the array. compare adjacent elements and swap them along the way
		 it is stable*/
		int start = 0;
		int end = array.length - 1;
		while (end > start) {
			// when end index is 1. it makes sense to terminate the loop
			boolean isSwapped = false;
			for (int i = start; i < end; i++) {
				if (isAscending) {
					if (array[i] > array[i + 1]) {
						//difference between ascending and descending is just '>'/'<' this sign
						Utils.swap(array, i, i + 1);
						isSwapped = true;
					}
				} else {
					if (array[i] < array[i + 1]) {
						Utils.swap(array, i, i + 1);
						isSwapped = true;
					}
				}
			}
			end--;                                          // if the full array is traversed once without swapping that means, the array is sorted
			if (!isSwapped) break;        // that's why I'm breaking the outer loop

		}
	}

	public static void selectionSort(int[] array, boolean isAscending) {
		//select max or min element. Put it at its correct position
		// it is not stable
		int start = 0;
		int end = array.length - 1;
		while (end > start) {
			int index;
			if (isAscending)
				index = Utils.getMaxIndex(array, start, end);         // we are finding the max element
			else index = Utils.getMinIndex(array, start, end);         // we are finding the min element
			if (index != end) {
				// if the max/min element is not at the end we will swap last element with selected element
				Utils.swap(array, end, index);
			}
			end--;
		}
	}

	public static void insertionSort(int[] array, boolean isAscending) {
		 /*we will take a sorted portion of an array and put element at their right position
		in that sorted portion*/
		// it is stable
		int start = 0;
		while (start < array.length - 1) {                                              //this loop will run forward
			for (int end = start + 1; end > 0; end--) {                       //this one will run backward
				if (isAscending) {
					if (array[end] < array[end - 1]) {
						Utils.swap(array, end, end - 1);
					} else
						break;                   // if the new element is already at its correct position break the loop
				} else {
					if (array[end] > array[end - 1]) {
						Utils.swap(array, end, end - 1);
					} else
						break;                   // if the new element is already at its correct position break the loop
				}
			}
			start++;
		}
	}
}