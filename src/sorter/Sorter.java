package sorter;

import java.util.Arrays;
import java.util.Date;

public class Sorter {
	public static long sort(int[] array, SortOrder order, SortingMethod method){		
		switch(method){
		case BUBBLE_SORT:
			bubbleSort(array, order);
		case MERGE_SORT:
			mergeSort(array, order);
		}
		
		return 0;
	}
	
	private static long bubbleSort(int[] array, SortOrder order){
		long startDate= (new Date()).getTime();
		
		for(int i=0; i<array.length; i++){
			for(int j=i+1; j<array.length; j++){
				switch(order){
				case ASCENDANT:
					if(array[i]>array[j]){
						int aux= array[i];
						array[i]=array[j];
						array[j]=aux;
					}
					break;
				case DESCENDANT:
					if(array[i]<array[j]){
						int aux= array[i];
						array[i]=array[j];
						array[j]=aux;
					}
				}
				 
			}
		}
		
		return 0;
	}
	
	private static long mergeSort(int[] array, SortOrder order){
		
		int[] left= Arrays.copyOfRange(array, 0, (array.length/2));
		int[] right= Arrays.copyOfRange(array, (array.length/2), array.length);
		
		if(left.length>1) mergeSort(left, order);
		if(right.length>1) mergeSort(right, order);
		
		for(int x=0, i=0, j=0; x<array.length; x++){
			if(i==left.length){
				array[x]= right[j];
				j++;
			}else if(j==right.length){
				array[x]= left[i];
				i++;
			}else{
				switch(order){
					case ASCENDANT:
						if(left[i]<right[j]){
							array[x]=left[i];
							i++;
						}else{
							array[x]=right[j];
							j++;
						}
						break;
					case DESCENDANT:
						if(left[i]>right[j]){
							array[x]=left[i];
							i++;
						}else{
							array[x]=right[j];
							j++;
						}
				}
			}
		}
		
		return 0;
	}
}
