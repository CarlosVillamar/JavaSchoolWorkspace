package gooogleCodeCollection;

import java.util.*;

public class WaffleChoppers {

		public static int r;//waffle row
		public static int c;//waffle column
		public static int h;//horizontal cuts
		public static int v;//vertical cuts

		public static int numChips;

		public static int[][] waffleGrid;//this is the two dimensional array our grid consists of 

		public static void main(String[] args) {

			Scanner stdin = new Scanner(System.in);
			System.out.println("Enter the number of waffles we would like to make: ");
			int waffleNum= stdin.nextInt();//How many waffles are we going to make 

			// Process each case.
			for (int loop=1; loop<=waffleNum; loop++) {

				System.out.println("Enter the number of row our waffle will have: ");
				r = stdin.nextInt();
				System.out.println("Enter the number of columns our waffle will have: ");
				c = stdin.nextInt();
				waffleGrid = new int[r][c];
				
				System.out.println("Enter  number of horizontal cuts you would like to make: ");
				h = stdin.nextInt();
				System.out.println("Enter the number of vertical cuts you would like to make: ");
				v = stdin.nextInt();

				// Read in the grid.
				numChips = 0;
				System.out.println("Remember . will denote a chip \n");
				for (int i=0; i<r; i++) {
					
					System.out.println("Enter the sequence for row " + (i+1) + "\n" );
					String s = stdin.next();
					for (int j=0; j<c; j++) {
						if (s.charAt(j) == '.')
							waffleGrid[i][j] = 0;
						else {
							waffleGrid[i][j] = 1;
							numChips++;
						}
					}
				}

				// Solve and output the result.
				boolean res = solve();
				if (res)
					System.out.println("Case #"+loop+": POSSIBLE");
				else
					System.out.println("Case #"+loop+": IMPOSSIBLE");
			}
			stdin.close();
			System.exit(0);
		}

		public static boolean solve() {

			// Here is a number of statements we can check via basic divisiblity.
			if (numChips%(h+1) != 0) return false;
			if (numChips%(v+1) != 0) return false;
			if (numChips%((h+1)*(v+1)) != 0) return false;
			if (numChips == 0) {
				System.out.println("There are no chips, so we  have no cuts to make");
				return true;
			}

			ArrayList<Integer> hCuts = new ArrayList<Integer>();

			// How many chips we need after cuts all in one direction.
			int target = numChips/(h+1);
			int cut = 0;
			
			// We just greedily cut as soon as we can for horizontal cuts.
			for (int i=0; i<r; i++) {

				for (int j=0;j<c;j++)
					cut += waffleGrid[i][j];//remember by now our waffle cells have values of 1 or 0

				// Time to cut.
				if (cut == target) {
					hCuts.add(i);
					cut = 0;
				}
				
				// If this triggers, it means we went from too few to too many, so it's impossible.
				else if (cut > target)
					return false;
			}

			// New target in a single piece.
			int cTarget = numChips/((h+1)*(v+1));

			int[] pCur = new int[h+1];

			// Go column by column to see if we can cut.
			for (int col_index=0; col_index<c; col_index++) {

				// Across each slice we add the chocolate chips, just for this single column for each piece.
				for (int i=0; i<hCuts.size(); i++) {
					int start = i == 0 ? 0 : hCuts.get(i-1)+1;
					int end = hCuts.get(i);
					for (int j=start; j<=end; j++) {
						pCur[i] += waffleGrid[j][col_index];
					}
				}

				// We check if every piece has the correct number of pieces.
				// If any piece has gone over, it's impossible.
				boolean canCut = true;
				for (int i=0; i<hCuts.size(); i++) {
					if (pCur[i] != cTarget) canCut = false;
					if (pCur[i] > cTarget) return false;
				}

				// This means we can make a vertical cut so all pieces to its left are correct.
				// Just reset our counters to 0.
				if (canCut) {
					Arrays.fill(pCur, 0);
				}
			}

			return true;
		}
	
}