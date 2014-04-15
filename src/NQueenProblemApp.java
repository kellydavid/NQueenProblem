
public class NQueenProblemApp {

	public int N;
	public boolean chessBoard[][]; 	// keeps track of entire chessboard
	public boolean rows[]; 			// keeps track of the rows
	public boolean columns[];		// keeps track of the columns
	public boolean minorDiagonal[]; // top right -> bottom left
	public boolean majorDiagonal[]; // top left -> bottom right

	public static void main(String args[]){
		NQueenProblemApp NQueenSolver = new NQueenProblemApp(8); // start NQueenSolver with N = 8
		NQueenSolver.solveNQueenProblem();						 // solve NQueen problem
	}

	public NQueenProblemApp(int N){
		this.N = N;
		this.chessBoard = new boolean[N][N];
		this.rows = new boolean[N];
		this.columns = new boolean[N];
		this.minorDiagonal = new boolean[N];
		this.majorDiagonal = new boolean[N];
	}
	
	public boolean solveNQueenProblem(){
		boolean chessBoard[][] = new boolean[N][N];
		int queens[][] = new int[N][2]; // array of queen positions
		int numberOfQueens = 0;
		while(numberOfQueens < N){
			for(int i = 0; i < chessBoard.length; i++){
				
			}
		}
		return true;
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
	private boolean isAttackable(int row, int col, boolean chessBoard[][]){
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

	public String chessBoardToString(){
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
