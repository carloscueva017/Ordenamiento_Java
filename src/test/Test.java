package test;

import sorter.*;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		final int length= 10;
		
		int[] array1= new int[length];
		int[] array2= new int[length];
		
		for(int i=0; i<length; i++){
			int num= (int)(Math.random()*100);
			array1[i]=num;
			array2[i]=num;
		}
		System.out.print("Bubble sort started... ");
		Date start = new Date();
		long operationsPerformedBubbleSort= Sorter.sort(array1, SortOrder.ASCENDANT, SortingMethod.BUBBLE_SORT);
		double timeTaken= ((new Date()).getTime() - start.getTime())/(double)1000;
		System.out.println("Bubble sort ended. ");
		System.out.println("\t" + operationsPerformedBubbleSort + " operations performed aprox.");
		System.out.println("\tTook " + timeTaken + " seconds aprox. to complete.");
		
		System.out.println();
		
		System.out.print("Merge sort started... ");
		start = new Date();
		long operationsPerformedMergeSort= Sorter.sort(array2, SortOrder.ASCENDANT, SortingMethod.MERGE_SORT);
		timeTaken= ((new Date()).getTime() - start.getTime())/(double)1000;
		System.out.println("Merge sort ended. ");
		System.out.println("\t" + operationsPerformedMergeSort + " operations performed aprox.");
		System.out.println("\tTook " + timeTaken + " seconds aprox. to complete.");
	}
}
