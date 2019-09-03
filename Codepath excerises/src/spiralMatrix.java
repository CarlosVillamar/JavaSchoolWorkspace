/*
Problem: Given a matrix of m x n elements (m rows, n columns),
 return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

[
  []
]

[i][j++]
start_r changed
[i++][j]
end_c changed
[i][j--]
end_r changed
[i--][j]
start_c changed


init_w = 4
init_h = 2
run loop
init_w -= 2
init_h -= 2
*/

class spiralMatrix{
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(spiralArr(arr1).toString());
	}

	public static int[] spiralArr(int[][] input) {
		int start_r = 0;
		int start_c = 0;
		int end_r = input.length - 1;
		int end_c = input[0].length - 1;

		int[] spiral = new int[end_r * end_c];
		int pos = 0;
		while (start_r != end_r && start_c != end_c) {
			for (int j = start_c; j <= end_c; j++) {
				spiral[pos] = input[start_r][j];
				pos += 1;
			}
			
			start_r += 1; // start_r = 1
			
			for (int i = start_r; i < end_r; i++) {
				spiral[pos] = input[i][end_c];
				pos += 1;
			}
			
			end_c -= 1; // end_c = 1
			
			for (int j = end_c; j > start_c; j--) {
				spiral[pos] = input[end_r][j];
				pos += 1;
			}
			end_r -= 1; // end_r = 1
			for (int i = end_r; i >start_r; i++) {
				spiral[pos] = input[i][start_c];
				pos += 1;
			}
			start_c += 1;
		}
		while (start_c <= end_c) {
			spiral[pos] = input[start_r][start_c];
			start_c++;
			pos++;
		}
		while (start_r <= end_r) {
			spiral[pos] = input[start_r][start_c];
			start_r++;
			pos++;
		}

		return spiral;
	}

}
