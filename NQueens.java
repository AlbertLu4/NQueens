import java.util.*;

public class NQueens {

	private static int possible;

	public static boolean validate(int boardSize, int board[][], int currentQueen, int locI, int locJ) {
		int i = 0;
		int j = 0;

		for (j = 0; j < boardSize; j++) {
			if (board[locI][j] != 0 && j != locJ) {
				return false;
			}
		}
		for (i = 0; i < boardSize; i++) {
			if (board[i][locJ] != 0 && i != locI) {
				return false;
			}
		}

		i = locI - 1;
		j = locJ - 1;

		while (i >= 0 && j >= 0) {
			if (board[i][j] != 0) {
				return false;
			}
			i--;
			j--;
		}

		i = locI + 1;
		j = locJ + 1;

		while (i < boardSize && j < boardSize) {
			if (board[i][j] != 0) {
				return false;
			}
			i++;
			j++;
		}

		i = locI - 1;
		j = locJ + 1;

		while (i >= 0 && j < boardSize) {
			if (board[i][j] != 0) {
				return false;
			}
			i--;
			j++;
		}
		i = locI + 1;
		j = locJ - 1;

		while (i < boardSize && j >= 0) {
			if (board[i][j] != 0) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static boolean placeQueens(int queens, int boardSize, int board[][], int currentQueen) {
		int i = 0;
		int j = 0;
		if (queens + 1 == currentQueen) {
			printBoard(boardSize, board);
			return true;
		}
		for (i = 0; i < boardSize; i++) {
			for (j = 0; j < boardSize; j++) {
				if (board[i][j] != 0) {
					continue;
				} else {
					if (validate(boardSize, board, currentQueen, i, j)) {
						board[i][j] = currentQueen;
						boolean ret = placeQueens(queens, boardSize, board, currentQueen + 1);
						if (ret) {
							return ret;
						}
						board[i][j] = 0;
					}
				}
			}
		}
		return false;
	}

	public static void printBoard(int boardSize, int board[][]) {
		int i = 0;
		int j = 0;
		for (i = 0; i < boardSize; i++) {
			for (j = 0; j < boardSize; j++) {
				String s = board[i][j] == 0 ? "_" : "" + board[i][j];
				System.out.print("" + s + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s;
		String s1;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of Queens");
		s = input.nextLine();
		System.out.println("Enter the board Size");
		s1 = input.nextLine();

		int queens = Integer.parseInt(s);
		int boardSize = Integer.parseInt(s);
		int board[][] = new int[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = 0;
			}
		}
		possible = 0;
		if (!placeQueens(queens, queens, board, 1) && possible == 0) {
			System.out.println("No Solution");
		}
		input.close();
	}
}
