package gooogleCodeCollection;

import java.util.*;

public class WaffleChoppers {
	// Arup Guha
	// 4/13/2018
	// Solution to 2018 Code Jam Round 1A Problem: Waffle Choppers
	// Written in contest, commented later.


		public static int r;
		public static int c;
		public static int h;
		public static int v;

		public static int numChips;

		public static int[][] grid;

		public static void main(String[] args) {

			Scanner stdin = new Scanner(System.in);
			System.out.println("Enter the number of waffles we would like to make: ");
			int waffleNum= stdin.nextInt();

			// Process each case.
			for (int loop=1; loop<=waffleNum; loop++) {

				System.out.println("Enter the number of row our waffle will have: ");
				r = stdin.nextInt();
				System.out.println("Enter the number of columns our waffle will have: ");
				c = stdin.nextInt();
				grid = new int[r][c];
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
							grid[i][j] = 0;
						else {
							grid[i][j] = 1;
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
			System.exit(0);
		}

		public static boolean solve() {

			// A number of items we can check via basic divisibility.
			if (numChips%(h+1) != 0) return false;
			if (numChips%(v+1) != 0) return false;
			if (numChips%((h+1)*(v+1)) != 0) return false;
			if (numChips == 0) return true;

			ArrayList<Integer> hCuts = new ArrayList<Integer>();

			// How many chips we need after cuts all in one direction.
			int target = numChips/(h+1);
			int cur = 0;
			
			// We just greedily cut as soon as we can for horizontal cuts.
			for (int i=0; i<r; i++) {

				for (int j=0;j<c;j++)
					cur += grid[i][j];

				// Time to cut.
				if (cur == target) {
					hCuts.add(i);
					cur = 0;
				}
				
				// If this triggers, it means we went from too few to too many, so it's impossible.
				else if (cur > target)
					return false;
			}

			// New target in a single piece.
			int cTarget = numChips/((h+1)*(v+1));

			int[] pCur = new int[h+1];

			// Go column by column to see if we can cut.
			for (int myc=0; myc<c; myc++) {

				// Across each slice we add the chocolate chips, just for this single column for each piece.
				for (int i=0; i<hCuts.size(); i++) {
					int start = i == 0 ? 0 : hCuts.get(i-1)+1;
					int end = hCuts.get(i);
					for (int j=start; j<=end; j++) {
						pCur[i] += grid[j][myc];
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
