package CH6;

public class chessTest
{
	public static void main(String[] args)
	{
		Queens chess = new Queens();

		chess.displayBoard();
		
		System.out.println("GO");
		
		chess.placeQueens(4);
		
		
		
		//start from first col
		
				//what happens if the first column has a queen?
				//chess.setQueen(3, 2);
				//chess.placeQueens(2);//next col
				
	}
}
