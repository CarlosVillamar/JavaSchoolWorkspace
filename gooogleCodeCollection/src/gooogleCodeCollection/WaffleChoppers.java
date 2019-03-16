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

		public static int numOfChips;//number of cuts in each row

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
				numOfChips= 0;
				System.out.println("Remember . will denote a chip \n");
				
				//we will create a loop to fill out our two-dimensional array ( or matrix) 
				for (int i=0; i<r; i++) {
					
					System.out.println("Enter the sequence for row " + (i+1) + "\n" );
					String s = stdin.next();
					for (int j=0; j<c; j++) {
						if (s.charAt(j) == '.') {
							waffleGrid[i][j] = 0;
							//we basically set the index in the matrix to have o to denote there is no chip in this cell
						}else {
						//setting an index to 1 in the matrix means we have a chip in this cell and increment a counter to keep track of the number of chips in the whole waffle
						waffleGrid[i][j] = 1;
						numOfChips++;
						}
						
					}
				}

				// Solve and output the result.
				boolean chipsForEveryOne = waffleMaker();
				if (chipsForEveryOne)
					System.out.println("Waffle #"+loop+": This waffle will please everyone");
				else
					System.out.println("Waffle #"+loop+": we need to redistribute the chips on this waffle");
			}
			stdin.close();
			System.exit(0);
		}

		public static boolean waffleMaker() {
			/**
			 * The purpose  of  this boolean function is to figure out whether or not we can cut our waffle and
			 * still meet our chip criteria
			 */
			 
			/**The statements below will check if the number of chips in this waffle  is a factor of the various cuts we have to make in the waffle
			 * this allows us to filter out data sets that will not work, ultimately if we find a set of data that are even or odd numbers, they are not compatiable because 
			 * it would indicate we don't have enough cuts or enough chips to divide evenly**/
			
			if (numOfChips%(h+1) != 0 || numOfChips%(v+1) != 0 || numOfChips%((h+1)*(v+1)) != 0 ) {
				System.out.println("Not enough chips to distrubute evenly") ;
				return false;
				}

			//this statement conforms we do not have any chips
			if (numOfChips == 0) {
				System.out.println("we dont have any chips");
				return true;
			}

			//lets make a list to keep track of  which rows we can divide the chips up evenly 
			ArrayList<Integer> horizontalCutsArray = new ArrayList<Integer>();

			// How many chips do we need after cuts for each horizontal cut
			int chipsPerRow = numOfChips/(h+1);
			System.out.println("\nThe number of cuts we have to make per row " + chipsPerRow );
			
			//lets determine what our chips per column will be
			int chipsPerCol= numOfChips/((h+1)*(v+1));
			System.out.println("Our new chip target per piece after the vertical cuts will be "+ chipsPerCol + "\n");
			
			//we need a list to keep track of the number of chips in each row
			int[] chipsInEachRow = new int[h+1];

			// chips in a single piece.
			int chipTally = 0;
			
			//lets double check our waffle matrix  so we can tally the chips for each row  
			//and compare it to the number of chips per row  to make sure  we can still divides chips evenly
			
			for (int i=0; i<r; i++) {//loop for the rows
				for (int j=0;j<c;j++)//column loop
					
					//remember by now our waffle cells have values of 1 or 0, lets tally them up to figure out how many chips this row willl have
					chipTally += waffleGrid[i][j];
					System.out.println("\nnumber of chips we have to have for this row " + chipTally);
			

				// if  the chipTally for this row matches our estimated chipsPerRow then lets add it to the array and reset the taly for the next row 
				if (chipTally== chipsPerRow) {
					horizontalCutsArray.add(i);
					System.out.println("\nWe have an equal number of chips and cuts to make in this row" );
					chipTally = 0;
				
				}else if (chipTally > chipsPerRow) {
					// turns out we have too many chips then initially thought, this isnt gonna work
					System.out.println("\nthis row contains too many cuts we have to make, there are not enough chips in this row to distrubute evenly ");
					return false;
				}
			}

			//we now need to establish a new two dimensional array based on the rows cuts we have made  
			//and the columns we have to now cut
			for (int col_index=0; col_index<c; col_index++) {
				for (int row_index=0; row_index<horizontalCutsArray.size()-1; row_index++) {
					chipsInEachRow[row_index] += waffleGrid[row_index][col_index];
				}
			}
			
			
			
			//now that we now what needs to be divided up for each row lets make sure we can actually make the cuts 			
			for(int chipsPerPiece: chipsInEachRow) {
				//if the number of chip per piece do not match  or are greater than the number of chips per column then  this confirms we make the cuts and have the same amount of chips in each piece
				if(chipsPerPiece != chipsPerCol || chipsPerPiece > chipsPerCol) {
					System.out.println("\nLooks like we can now cut this vertically and every one still gets the same amount of chips \nyayyyyy");
					return true;
				}else {
					//keep in mind if this case triggers it means we have a row that does not have enough cuts in distribute the chips evenly
					System.out.println("\nTurns out we actully don't have enough chips to go aroud");
					return false;
				}
			}
			return true;
		}
	
}
