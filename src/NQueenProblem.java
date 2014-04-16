

/**
 * @author David Kelly
 * Github username: kellydavid
 *
 */
public class NQueenProblem {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]){
		int n = 8;
		NQueenProblem nQueenSolver = new NQueenProblem(n);
		System.out.println((nQueenSolver.solve() ? "Solved":"Not solved") + " for n = " + n + "\n");
		System.out.println(nQueenSolver.toString());
	}


	/*
	 * Fields for the NQueenProblemApp class
	 */
	public int N;
	public int queens[]; // index of array is the row and value stored in array is the column
	public int solveBoardCalls = 0;

	/**
	 * Constructs an NQueenProblem object that will solve the Nqueen problem where N is the value passed
	 * into the constructor.
	 * 
	 * @param N
	 */
	public NQueenProblem(int N){
		this.N = N;
		queens = new int[N];
	}

	/**
	 * Provides a public interface to calling the solveBoard() method inside the NQueenProblem class.
	 * Returns true if the problem can be solved and false if not.
	 * 
	 * @return
	 */
	public boolean solve(){
		return solveBoard(0);
	}

	/**
	 * Recursive method that places a queen on each row of the board, checking if the rows and diagonals are clear.
	 * Pass in the row number of the queen to place on the board.
	 * Returns true if all the queens are successfully placed on the board.
	 * 
	 * @param queen
	 * @return
	 */
	private boolean solveBoard(int queen){
		solveBoardCalls++;
		for(int i = 0; i < N; i++){		// loop through all the possible columns to place the queen
			if(canPlace(queen, i)){		// find an empty column that has no attacking diagonals
				queens[queen] = i;		// store the column number in the array of rows
				if(queen == N - 1)		// if all the queens have been successfully placed return true
					return true;
				if(solveBoard(queen + 1)) // if the deeper solveBoard method returns true then return true
					return true;
			}
		}
		// if placing the queen failed return false to the calling method.
		queens[queen] = 0;
		return false;
	}

	/**
	 * Returns true if a queen can be placed at a particular row and column.
	 * All the row's before the given row will already have a queen placed in them
	 * so only check those rows' columns and diagonals.
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean canPlace(int row, int col){
		// checks all the rows preceding the current row due to the solving algorithm interating 
		// through each row in order so no need to check other rows with no queens
		for(int i = 0; i < row; i++){
			// checks if a queen is already on the same column
			// also checks if the queens absolute distance between two queens x and y coordinates are the same
			// if they are then the two queens are on the same diagonal so return false
			if(queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)){
				return false;
			}
		}
		return true;
	}

	public String toString(){
		String string = "";	
		boolean queenArray[][] = new boolean[N][N];
		for(int i = 0; i < queens.length; i++){
			queenArray[i][queens[i]] = true;
		}
		for(int i = 0; i < queenArray.length; i++){
			string += "|";
			for(int j = 0; j < queenArray[i].length; j++){
				string += (queenArray[i][j] ? "Q":"-") + "|";
			}
			string += "\n";
		}
		string += "\nQueen positions: ";
	    for(int i = 0; i < queens.length; i++){
	    	string += "(" + i + "," + queens[i] + ") ";
	    }
	    string += "\nSolve Board Method Calls: " + solveBoardCalls + "\n";
		return string;
	}
}
