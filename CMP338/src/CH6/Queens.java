package CH6;

public class Queens 
{
	public static int moves = 4;
	public static final int BOARD_SIZE = 8;// row and the col length
	public static final int EMPTY = 0;///zero queens mean empty square
	public static final int QUEEN = 1;//has 1 queen in the square
	private int board[][];// our chess board as a 2 dimensional array
	
	int[] hori;
	int[] vert;
	
	public Queens()
	{
			board = new int [BOARD_SIZE][BOARD_SIZE];
	}
	
	public Queens(int row, int col)
	{
			board = new int [BOARD_SIZE][BOARD_SIZE];//empty board
			if((row>=1)&&(col>=1)&& (row<=8)&&(col<=8))
			{///set the queens placement
				setQueen(row,col);
			}
			
			/**for(int row= 0; row < board.length; row++)
			{
				for(int col=0; col < board[row].length; col++)
				{
					board[row][col] = EMPTY;
				}
			}
			hori = new int[moves];
			vert = new int[moves];
			
			//up right
			hori[0] = -1;
			vert[0] = 1;
			
			//down left
			hori[1] = 1;
			vert[1] = -1;
			
			//up left
			hori[2] = -1;
			vert[2] = -1;
			
			//down left
			hori[3] = 1;
			vert[3] = 1;
			**/
	}
	public void clearBoard()
	{
		for(int i = 0; i<BOARD_SIZE;i++)
			for(int j=0; j<BOARD_SIZE; j++)
			{
			board[i][j] = EMPTY;
			}
		
	}
	public void displayBoard()
	{
		for(int i = 0; i<BOARD_SIZE;i++)
		{
			for(int j=0; j<BOARD_SIZE; j++)
				{
				System.out.print(board[i][j]+ "/t");
				//System.out.print(board[i][j] + "/t");
				}
		System.out.println("-------------");
		}
		System.out.println("===============");
				
	}
	public boolean placeQueens(int col)
	{
		if(col> BOARD_SIZE)
		{	this.displayBoard();
			return true;
		}
		else
		{
			boolean queenPlaced = false;
			int row = 1;//Square's number in column.. is off by 1 by (index = col or row -1);
			while(!queenPlaced && row <=BOARD_SIZE)
			{
				if(underAttack(row,col))//if row can be attacked by another queen
				{
					row++;//check next row
				}
				else 
				{
					setQueen(row,col);
					queenPlaced = placeQueens(col+1);//recursive call
					//if no queen is possible in next column
				this.displayBoard();
				if(!queenPlaced)
				{
					removeQueen(row,col);
					row++;
				}
				}
				
			}
			
			return queenPlaced;
		}
	}
	public void setQueen(int row, int col) {
		// TODO Auto-generated method stub
		board[row][col] = QUEEN;//PUT A 1 REPRESENTING THAT SQUARE 
	}
	private void removeQueen(int row, int col) {
		// TODO Auto-generated method stub
		board[row][col] = EMPTY;//PUT A 0 REPRESENTING THAT SQUARE
	}
	private int getIndex(int num)
	{//
		return  num-1;
	}
	
	private boolean underAttack(int row, int col) {
		//check all proceeding colnmuns in the same row from 0 to col-1
		for(int preCol =0; preCol<getIndex(preCol);preCol++)
		{
			if(board[getIndex(row)][preCol]==QUEEN)
			{
				return true;
			}
		}
		
		//check all proceeding rows in the same column from 0 to col-1
		for(int preRow =0; preRow<getIndex(preRow);preRow++)
		{
			if(board[getIndex(col)][preRow]==QUEEN)
			{
				return true;
			}
		}
		//check the upper left diagonal row-- col--
		for(int topSq = getIndex(row), botSq= getIndex(col); topSq >=0 && botSq < 0;topSq--,botSq--)
		{
			if(board[getIndex(topSq)][botSq]== QUEEN)
			{ 
				return true;
			}
		}
		//check the downward left diagonal row++ col--
		for(int topSq = getIndex(row),botSq= getIndex(col); topSq < board.length && botSq >= 0; topSq++, botSq--)
		{
			if(board[getIndex(topSq)][botSq] == QUEEN)
			{
				return true;
			}
		}
		/**for(int topSq = row, botSq= col; topSq >=0 && botSq >=0; topSq--,botSq--)
		{
			if(board[getIndex(topSq)][botSq]==QUEEN)
			{
				return true;
			}
		}
		for(int topSq = row, botSq= col; topSq < BOARD_SIZE && botSq < BOARD_SIZE;topSq--,botSq--)
		{
			if(board[getIndex(topSq)][botSq]==QUEEN)
			{
				return true;
			}
		}**/
		//The for loops commented out is an alternative
		return false;
	}
	
}
