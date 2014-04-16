import java.util.Arrays;


public class NQueenProblem {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]){
		NQueenProblem nQueenSolver = new NQueenProblem(6);
		System.out.println((nQueenSolver.solve() ? "Solved":"Not solved"));
		System.out.println(nQueenSolver.toString());
	}


	/*
	 * Fields for the NQueenProblemApp class
	 */
	public int N;
	public int queens[]; // index of array is the row and value stored in array is the column
	public int solveBoardCalls = 0;

	public NQueenProblem(int N){
		this.N = N;
		queens = new int[N];
	}

	public boolean solve(){
		return solveBoard(0);
	}

	private boolean solveBoard(int queen){
		solveBoardCalls++;
		if(solveBoardCalls == 46)
			System.out.println("break");
		for(int i = 0; i < N; i++){		// loop through all the possible columns to place the queen
			if(canPlace(queen, i)){		// find an empty column that has no attacking diagonals
				queens[queen] = i;		// store the column number in the array of rows
				if(queen == N - 1)		// if all the queens have been looped through return true
					return true;
				if(solveBoard(queen + 1)) // if the deeper solveBoard method returns true then return true
					return true;
			}
		}
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
		for(int i = 0; i < row; i++){
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
				string += (queenArray[i][j] ? "Q":" ") + "|";
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
