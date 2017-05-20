package test;

import sorter.*;

public class Test {
	public static void main(String[] args) {
		final int length= 1000;
		
		int[] array1= new int[length];
		int[] array2= new int[length];
		
		for(int i=0; i<length; i++){
			int num= (int)(Math.random()*100);
			array1[i]=num;
			array2[i]=num;
		}
		System.out.print("Bubble sort started... ");
		long operationsPerformedBubbleSort= Sorter.sort(array1, SortOrder.ASCENDANT, SortingMethod.BUBBLE_SORT);
		System.out.print("Bubble sort ended. ");
		System.out.println(operationsPerformedBubbleSort + " operations performed to order the array using bubble sort");
		
		System.out.print("Merge sort started... ");
		long operationsPerformedMergeSort= Sorter.sort(array2, SortOrder.ASCENDANT, SortingMethod.MERGE_SORT);
		System.out.print("Merge sort ended. ");
		System.out.println(operationsPerformedMergeSort + " operations performed to order the array using merge sort");
	}
}
