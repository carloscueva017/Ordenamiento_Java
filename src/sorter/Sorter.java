package sorter;

import java.util.Arrays;

public class Sorter {
	public static long sort(int[] array, SortOrder order, SortingMethod method) {
		long operationsPerformed = 0;

		switch (method) {
		case BUBBLE_SORT:
			operationsPerformed = bubbleSort(array, order);
			break;
		case MERGE_SORT:
			operationsPerformed = mergeSort(array, order);
			break;
		}

		return operationsPerformed;
	}

	private static long bubbleSort(int[] array, SortOrder order) {
		long operationsPerformed = 0;
		
		for (int i = 0; i < array.length; i++) {
			operationsPerformed++;
			for (int j = 0; j < array.length; j++) {
				operationsPerformed++;
				switch (order) {
				case ASCENDANT:
					if (array[i] > array[j]) {
						int aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}
					break;
				case DESCENDANT:
					if (array[i] < array[j]) {
						int aux = array[i];
						array[i] = array[j];
						array[j] = aux;
					}
				}

			}
		}

		return operationsPerformed;
	}

	private static long mergeSort(int[] array, SortOrder order) {
		long operationsPerformed = 0;

		int[] left = Arrays.copyOfRange(array, 0, (array.length / 2));
		int[] right = Arrays.copyOfRange(array, (array.length / 2), array.length);

		if (left.length > 1)
			operationsPerformed += mergeSort(left, order);
		if (right.length > 1)
			operationsPerformed += mergeSort(right, order);

		for (int x = 0, i = 0, j = 0; x < array.length; x++) {
			operationsPerformed++;
			if (i == left.length) {
				array[x] = right[j];
				j++;
			} else if (j == right.length) {
				array[x] = left[i];
				i++;
			} else {
				switch (order) {
				case ASCENDANT:
					if (left[i] < right[j]) {
						array[x] = left[i];
						i++;
					} else {
						array[x] = right[j];
						j++;
					}
					break;
				case DESCENDANT:
					if (left[i] > right[j]) {
						array[x] = left[i];
						i++;
					} else {
						array[x] = right[j];
						j++;
					}
				}
			}
		}

		return operationsPerformed;
	}
}
