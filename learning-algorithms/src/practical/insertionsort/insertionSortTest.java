package practical.insertionsort;

public class insertionSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array  = new int[] {20,1,3,76,20,90,100};
		array = insertionSort(array);
		
		for(int j = 0; j < array.length-1;j++) {
			System.out.println(array[j]);
		}

	}

	private static int[] insertionSort(int[] array) {
		// TODO Auto-generated method stub
		int size = array.length-1;
		int element = 0;
		int j =0;
		for(int i = 1; i<size;i++) {
			element = array[i];
			j = i-1;
			while(j>=0 && array[j]>element) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = element;
		}
		return array;
	}

}