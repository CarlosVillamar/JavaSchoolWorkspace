package gooogleCodeCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class TroubleSort {

	static ArrayList<Integer> numlist = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// try {
		System.out.println("Give me a number 3 or larger ");
		Scanner scanner = new Scanner(System.in);
		int setLength = scanner.nextInt();
		
		if (setLength >= 3) {
			System.out.println("Enter a set of " + setLength + " numbers one by one ");
			for (int i = 0; i < setLength; i++) {
				int num2 = scanner.nextInt();
				numlist.add(num2);
			}
			scanner.close();
			troubleSort(numlist);

		} else {
			scanner.close();
			System.out.println("Whoops try again");
			System.exit(0);

		}
	}

	public static void troubleSort(ArrayList<Integer> list) {
		System.out.println("Here is the set of  numbers you gave lets sort them out \n" + list);
		Boolean done = false;

		int temp = 0;
		while (!done) {
			done = true;
			for (int i = 0; i <= list.size() - 1; i++) {
				/**I created an series of if statements to perform different if statements and operations based on where we are in the for loop
				 * we have a series of operations for the following conditions:
				 * +the end of the loop | we reached the end of the list
				 * +when we reach the second to last index in the list
				 * +Operations for anywhere else in the list
				 * 
				 * One of the challenges with this problem was checking everything was in order after we made a swap
				 * This led to a conscious decision to reset the loop ( the counter ) to zero whenever a swap was made
				 * This allows for the algorithm to double check the list when we sorted something.
				 */

				if (i == list.size() - 2) {
					/**We  need to make sure we check the last two indices before the list ends
						This way we do not have to perform and an operation on the last index and ensure we do not
						Receive an array out of bounds error
					*/
					if (list.get(i) > list.get(i + 1)) {
						System.out.println("Second to last index is bigger than the last index  lets swap them and verify our list is in order now \n" + list);
						temp = list.get(i);
						list.set(i, list.get(i + 1));
						list.set(i + 1, temp);
						i =0;
						done = false;
					} 

				} else if (i == list.size() - 1) {
					/** 
					 * We reached the end of our list and everything is swapped 
					 * */
					done = true;
					System.out.println("We sorted the list");
					System.out.println(list);
					System.exit(0);
				} else if (i < list.size() - 1) {
					//Lets circle through the list as usual
					System.out.println("index: " + String.valueOf(i) + " list size " + String.valueOf(list.size() - 1));

					if (list.get(i) > list.get(i + 2)) {
						System.out.println("number 2 indecies over is smaller " + String.valueOf(list.get(i))+ " > " +  String.valueOf(list.get(i + 2)));
						done = false;
						temp = list.get(i);
						list.set(i, list.get(i + 2));
						list.set(i + 2, temp);
						i=0;

						} 
					if (list.get(i) > list.get(i + 1)) {
							System.out.println("number one index over is smaller " + String.valueOf(list.get(i))+ " > " + String.valueOf(list.get(i + 1)));
							done = false;
							temp = list.get(i);
							list.set(i, list.get(i + 1));
							list.set(i + 1, temp);
							i=0;

					}
				}
			}
		}
	}

}
