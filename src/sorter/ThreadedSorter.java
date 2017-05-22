package sorter;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class ThreadedSorter implements Runnable {

	private CyclicBarrier barrier;
	private int[] array;
	private SortOrder order;
	
	public ThreadedSorter(CyclicBarrier barrier, int[] array, SortOrder order) {
		this.barrier = barrier;
		this.array = array;
		this.order = order;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long operationsPerformed = 0;

		int[] left = Arrays.copyOfRange(array, 0, (array.length / 2));
		int[] right = Arrays.copyOfRange(array, (array.length / 2), array.length);
		
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		
		
		if (left.length > 1){
			ThreadedSorter leftSorter = new ThreadedSorter(barrier, left, this.order);
			Thread leftSorterThread = new Thread(leftSorter);
		}
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
	}

}
