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

		public static int numberOfCuts;//number of cuts in each row

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
				numberOfCuts= 0;
				System.out.println("Remember . will denote a chip \n");
				
				//we will create a loop to fill out our two-dimensional array ( or matrix) 
				for (int i=0; i<r; i++) {
					
					System.out.println("Enter the sequence for row " + (i+1) + "\n" );
					String s = stdin.next();
					for (int j=0; j<c; j++) {
						if (s.charAt(j) == '.') {
							waffleGrid[i][j] = 0;
							//we basically set the index in the matrix to have o to denote the chip in the waffle
						}else {
						//setting an index to 1 in the matrix means we want to cut it and increment a counter to keep track of what we have to cut
						waffleGrid[i][j] = 1;
						numberOfCuts++;
						}
						
					}
				}

				// Solve and output the result.
				boolean chipsForEveryOne = solve();
				if (chipsForEveryOne)
					System.out.println("Waffle #"+loop+": POSSIBLE");
				else
					System.out.println("Waffle #"+loop+": IMPOSSIBLE");
			}
			stdin.close();
			System.exit(0);
		}

		public static boolean solve() {
			/**
			 * The purpose  of  this boolean function is to figure out whether or not we can cut our waffle and
			 * still meet our chip criteria
			 */
			 
			/**The statements below we will determine if we have too many row or column cuts compared to the number of cuts we already determined we have to make,
				we determine this by trying to find out if the all the number of cuts we determined and the cuts we have to make, are even or odd factors of each other
				if the values are not multiples of one another, this is one way we can determine we will not have a equal distrobution of chips
				this way we filter out a waffle with data that is already destined to fail**/
			
			if (numberOfCuts%(h+1) != 0 || numberOfCuts%(v+1) != 0 || numberOfCuts%((h+1)*(v+1)) != 0 ) {
				System.out.println("Not enough chips to distrubute evenly") ;
				return false;
				}

			//this statement conforms we have chips in every cell in the waffle
			if (numberOfCuts == 0) {
				System.out.println("we have an even number of chips, so all are cuts will have an equal distribution of chips");
				return true;
			}

			
			ArrayList<Integer> horizontalCutsArray = new ArrayList<Integer>();

			// How many chips do we need after cuts for each horizontal cut
			int cutsPerRow = numberOfCuts/(h+1);
			System.out.println("The number of cuts we have to make per row" + cutsPerRow );
			int cut = 0;
			// New target in a single piece.


			// We just greedily cut as soon as we can for horizontal cuts.
			for (int i=0; i<r; i++) {

				for (int j=0;j<c;j++)
					cut += waffleGrid[i][j];//remember by now our waffle cells have values of 1 or 0
				System.out.println("cuts we have to make for this row " + cut);
			

				// Time to cut.
				if (cut == cutsPerRow) {
					horizontalCutsArray.add(i);
					System.out.println("We have an equal number of chips and cuts to make in this row" );
					cut = 0;
				
				}else if (cut > cutsPerRow) {
					// If this triggers, it means we went from too few to too many, so it's impossible.
					System.out.println("this row contains too many cuts we have to make, there are not enough chips in this row to distrubute evenly ");
					return false;
				}
			}

			//we now need to establish a new two dimensional array based on the rows cuts we have made  
			//and the columns we have to now cut
			int[] chipsInEachRow = new int[h+1];
			for (int col_index=0; col_index<c; col_index++) {
				for (int i=0; i<horizontalCutsArray.size()-1; i++) {
					chipsInEachRow[i] += waffleGrid[i][col_index];
				
				}
			}
			
			int verticalCutTarget = numberOfCuts/((h+1)*(v+1));
			System.out.println("Our new chip target per piece after the vertical cuts will be "+ verticalCutTarget);
			
			//now that we now what needs to be divided up for each row lets make sure we can actually make the cuts and have enough chips for each piece
			for(int i=0;chipsInEachRow.length-1>i;i++) {
				if (chipsInEachRow[i] != verticalCutTarget || chipsInEachRow[i]>verticalCutTarget) {
					System.out.println("Looks like we can now cut this vertically and every one still gets the same amount of chips \nyayyyyy");
					return true;
				}else {
					System.out.println("Turns out we actully don't have enough chips to go aroud");
					return false;
				}
			}
			return true;
		}
	
}
