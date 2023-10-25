package lab5;

public class task2 {
	private static final char EMPTY = ' ';
	private char[][] board;

	public boolean checkRows() {
		for (int row = 0; row < 3; row++) {

			char cell1 = board[row][0];
			char cell2 = board[row][1];
			char cell3 = board[row][2];

			if (cell1 != EMPTY && cell1 == cell2 && cell2 == cell3) {
				return true;
			}
		}

		return false;
	}

	public boolean checkColumns() {
		for (int col = 0; col < 3; col++) {
			char cell1 = board[0][col];
			char cell2 = board[1][col];
			char cell3 = board[2][col];

			if (cell1 != EMPTY && cell1 == cell2 && cell2 == cell3) {
				return true;
			}
		}

		return false;
	}

	public boolean checkDiagonals() {
		char cell1 = board[0][0];
		char cell2 = board[1][1];
		char cell3 = board[2][2];

		if (cell1 != EMPTY && cell1 == cell2 && cell2 == cell3) {
			return true;
		}

		char cell4 = board[2][0];
		char cell5 = board[1][1];
		char cell6 = board[0][2];

		if (cell4 != EMPTY && cell4 == cell5 && cell5 == cell6) {
			return true; // A player has won in the bottom-left to top-right diagonal
		}

		return false;
	}

}
