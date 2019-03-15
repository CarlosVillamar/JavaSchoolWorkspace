package gooogleCodeCollection;

import java.util.*;

public class WaffleChoppers {
	/**
	 * For this problem we would like to able to cut the waffles we create into individual pieces and ensure
	 * we have an equal amount of chocolate chips for each piece, the purpose of this application is to determine
	 *~~how many rows and columns does each waffle contain?
	 *~~how many horizontal and vertical cuts we will make?
	 *~~what are the contents of each waffle row?
	 */

		public static int r;//waffle row
		public static int c;//waffle column
		public static int h;//horizontal cuts
		public static int v;//vertical cuts

		public static int numChips;//number of chocolate chips

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

				// Here we essentially decorate our waffles
				numChips = 0;
				System.out.println("Remember . will denote a chip \n");
				
				//we will create a loop to fill out our two-dimensional array ( or matrix) 
				for (int i=0; i<r; i++) {
					
					System.out.println("Enter the sequence for row " + (i+1) + "\n" );
					String s = stdin.next();
					for (int j=0; j<c; j++) {
						if (s.charAt(j) == '.') {
							waffleGrid[i][j] = 0;
						}else {
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
			/**
			 * The purpose  of  this boolean function is to figure out whether  or not we can cut our waffle and
			 * still meet our chip criteria
			 */
			 
			//The statements below we will determine if we have too many cuts or too little cuts compared to the number of chips
			//we determine this by trying to find out if the numbers are pairs of even or odd
			//this way we filter out a waffle with data that is already destined to fail
			if (numChips%(h+1) != 0) return false;
			if (numChips%(v+1) != 0) return false;
			if (numChips%((h+1)*(v+1)) != 0) return false;
			
			if (numChips == 0) {
				//every cell in the waffle has a chip....so everything is even
				System.out.println("we have an even number of chips, so we have no cuts to make ");
				return true;
			}

			ArrayList<Integer> horizontalCutsArray = new ArrayList<Integer>();

			// How many chips we need after cuts all in one direction.
			int chips = numChips/(h+1);
			System.out.println("The number of chips we have to work with " + chips );
			int cut = 0;
			
			// We just greedily cut as soon as we can for horizontal cuts.
			for (int i=0; i<r; i++) {

				for (int j=0;j<c;j++)
					cut += waffleGrid[i][j];//remember by now our waffle cells have values of 1 or 0

				// Time to cut.
				if (cut == chips) {
					horizontalCutsArray.add(i);
					cut = 0;
				}
				
				// If this triggers, it means we went from too few to too many, so it's impossible.
				else if (cut > chips)
					return false;
			}

			// New target in a single piece.
			int verticalCutTarget = numChips/((h+1)*(v+1));
			System.out.println("Our new chip target per piece after the vertical cuts will be "+ verticalCutTarget);

			int[] chipsPerPiece = new int[h+1];

			// Go column by column to see if we can cut.
			for (int col_index=0; col_index<c; col_index++) {

				// Across each slice we add the chocolate chips, just for this single column for each piece.
				for (int i=0; i<horizontalCutsArray.size(); i++) {
					int start = i == 0 ? 0 : horizontalCutsArray.get(i-1)+1;
					int end = horizontalCutsArray.get(i);
					for (int j=start; j<=end; j++) {
						chipsPerPiece[i] += waffleGrid[j][col_index];
					}
				}

				// We check if every piece has the correct number of pieces.
				// If any piece has gone over, it's impossible.
				boolean canCut = true;
				for (int i=0; i<horizontalCutsArray.size(); i++) {
					if (chipsPerPiece[i] != verticalCutTarget) canCut = false;
					if (chipsPerPiece[i] > verticalCutTarget) return false;
				}

				// This means we can make a vertical cut so all pieces to its left are correct.
				// Just reset our counters to 0.
				if (canCut) {
//					System.out.println("We can cut again");
					Arrays.fill(chipsPerPiece, 0);
					System.out.println("YERRR" + canCut);
				}
			}

			return true;
		}
	
}
