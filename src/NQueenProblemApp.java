
public class NQueenProblemApp {

	public static boolean chessBoard[][];

	public static void main(String args[]){
		int N = 8;
		chessBoard = new boolean[N][N];
		System.out.println(chessBoardToString(chessBoard));
		chessBoard[3][6] = true;
		chessBoard[0][0] = true;
		System.out.println(chessBoardToString(chessBoard));
		chessBoard[6][7] = true;
		System.out.println(chessBoardToString(chessBoard));
		System.out.println("3,6 " + (isAttackable(3,6,chessBoard) ? "attackable":"not attackable"));
		System.out.println("6,7 " + (isAttackable(6,7,chessBoard) ? "attackable":"not attackable"));
		System.out.println(chessBoardToString(chessBoard));
	}

	public static boolean[][] solveNQueenProblem(int N){
		boolean chessBoard[][] = new boolean[N][N];
		int queens[][] = new int[N][2]; // array of queen positions
		int numberOfQueens = 0;
		while(numberOfQueens < N){
			for(int i = 0; i < chessBoard.length; i++){
				
			}
		}
		return chessBoard;
	}
	
	/**
	 * Pass the row and the column of the queen to be checked whether it is attackable
	 * or not. Pass the boolean 2-D array of chess board also.
	 * 
	 * Returns true if the queen can be attacked and false if not.
	 * 
	 * @param row
	 * @param col
	 * @param chessBoard
	 * @return
	 */
	public static boolean isAttackable(int row, int col, boolean chessBoard[][]){
		int i = 0;
		int j = 0;
		//check for attackers coming from left or right positions
		for(j = 0; j < chessBoard[row].length; j++){
			if(chessBoard[row][j] && j != col)
				return true;
		}
		// check for attackers coming from above or below positions
		for(i = 0; i < chessBoard.length; i++){
			if(chessBoard[i][col] && i != row)
				return true;
		}
		//check for attackers coming from north west
		i = row - 1;
		j = col - 1;
		while(i >= 0 && j >= 0){
			if(chessBoard[i--][j--])
				return true;
		}
		//check for attackers coming from south east
		i = row + 1;
		j = col + 1;
		while(i < chessBoard.length && j < chessBoard.length){
			if(chessBoard[i++][j++])
				return true;
		}
		//check for attackers coming from north east
		i = row - 1;
		j = col + 1;
		while(i >= 0 && j < chessBoard.length){
			if(chessBoard[i--][j++])
				return true;
		}
		//check for attackers coming from south west
		i = row + 1;
		j = col - 1;
		while(i < chessBoard.length && j >= 0){
			if(chessBoard[i++][j--])
				return true;
		}
		return false;
	}

	public static String chessBoardToString(boolean chessBoard[][]){
		String print = "\n";
		for(int i = 0; i < chessBoard.length; i++){
			print += "|";
			for(int j = 0; j < chessBoard.length; j++){
				print += "" + (chessBoard[i][j] ? "*":" ") + "|";
			}
			print += "\n";
		}
		return print;
	}
}
