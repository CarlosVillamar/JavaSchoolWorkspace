package practical.QS;

import java.util.Arrays;

public class qsTest {
	public static void main(String[] args) {
		int[] inputArray = new int[] { 20, 1, 3, 76, 20, 90, 100 };
		QuickSort(inputArray, 0, inputArray.length - 1);

		System.out.println(Arrays.toString(inputArray));
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;

		for (int j = start; j <= end-1; j++) {
			if (arr[j] <= pivot) {
				i++;
				arr[i] = arr[j];
			}
		}
		arr[i + 1] = arr[end];
		return i + 1;
	}

	public static void QuickSort(int[] arr, int start, int finish) {

		if (start < finish) {
			int pivot = partition(arr, start, finish);

			QuickSort(arr, start, pivot - 1);
			QuickSort(arr, pivot + 1, finish);

		}

	}
}
