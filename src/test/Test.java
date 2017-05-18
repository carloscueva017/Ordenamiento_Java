package test;

import java.util.Arrays;

import sorter.*;

public class Test {
	public static void main(String[] args) {
		final int length= 2000;
		
		int[] array1= new int[length];
		int[] array2= new int[length];
		
		for(int i=0; i<length; i++){
			int num= (int)(Math.random()*100);
			array1[i]=num;
			array2[i]=num;
		}
		System.out.print("Bubble sort started... ");
		Sorter.sort(array1, SortOrder.ASCENDANT, SortingMethod.BUBBLE_SORT);
		System.out.println("Bubble sort ended.");
		System.out.print("Merge sort started... ");
		Sorter.sort(array1, SortOrder.ASCENDANT, SortingMethod.MERGE_SORT);
		System.out.println("Merge sort ended.");
	}
}
