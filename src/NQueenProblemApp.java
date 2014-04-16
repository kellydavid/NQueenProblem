import java.util.Arrays;


public class NQueenProblemApp {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]){
		NQueenProblemApp nQueenSolver = new NQueenProblemApp(8);
		System.out.println((nQueenSolver.solve() ? "Solved":"Not solved"));
		System.out.println(nQueenSolver.toString());
	}

	
	/*
	 * Fields for the NQueenProblemApp class
	 */
	public int N;
	public int queens[]; // index of array is the row and value stored in array is the column

	public NQueenProblemApp(int N){
		queens = new int[N];
		Arrays.fill(queens, -1); // fills the queens array with default -1 value
	}
	
	public boolean solve(){
		return solveBoard(0);
	}

	private boolean solveBoard(int queen){
		for(int i = 0; i < N; i++){		// loop through all the possible columns to place the queen
			if(canPlace(queen, i)){		// find an empty column that has no attacking diagonals
				queens[queen] = i;		// store the column number in the array of rows
				if(queen == N - 1)		// if all the queens have been looped through return true
					return true;
				else{						//otherwise continue onto the next row
					if(solveBoard(queen + 1))
						return true;
					else{
						solveBoard(queen - 1);
						return false;
					}
				}
			}
		}
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
		for(int i = 0; i < row; i++){
			if(queens[i] == col || queens[i] - col == i - row){
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
				string += (queenArray[i][j] ? "Q":" ") + "|";
			}
			string += "\n";
		}
		return string;
	}
}
