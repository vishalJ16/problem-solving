/**
 * 
 */
package leetcode;

/**
 * @author v0j008y 10 Oct 2021 13:17:00
 */
public class Minesweeper_529 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] boardString = { { "E", "E", "E", "E", "E" }, { "E", "E", "M", "E", "E" },
				{ "E", "E", "E", "E", "E" }, { "E", "E", "E", "E", "E" } };
		int[] click = { 3, 0 };

		Minesweeper_529 ob = new Minesweeper_529();
		char[][] board = ob.convertStringToChar(boardString);
		ob.updateBoard(board, click);
		System.out.println();
	}

	int[] x_delta = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] y_delta = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public char[][] updateBoard(char[][] board, int[] click) {

		int x = click[0];
		int y = click[1];

		if (board[x][y] == 'M') {
			board[x][y] = 'X';
		} else if (board[x][y] == 'E') {
			int[][] visited = new int[board.length][board[0].length];
			markAdjacents(board, x, y, visited);
		}
		return board;
	}

	void markAdjacents(char[][] board, int x, int y, int[][] visited) {
		int mines = getAdjacent8MinesCount(board, x, y);
		if (mines != 0) {
			board[x][y] = (char) (mines + '0');
		} else {
			board[x][y] = 'B';
			visited[x][y] = 1;
			for (int i = 0; i < 8; i++) {
				int dx = x_delta[i];
				int dy = y_delta[i];

				int xi = x + dx;
				int yi = y + dy;

				if (xi < 0 || yi < 0 || xi >= board.length || yi >= board[0].length) {
					continue;
				}
				if (visited[xi][yi] == 1) {
					continue;
				} else {
					markAdjacents(board, xi, yi, visited);
				}
			}
		}
	}

	int getAdjacent8MinesCount(char[][] board, int i, int j) {

		int minesCount = 0;

		for (int k = 0; k < 8; k++) {
			int dx = x_delta[k];
			int dy = y_delta[k];

			int xi = i + dx;
			int yi = j + dy;

			if (xi < 0 || yi < 0 || xi >= board.length || yi >= board[0].length) {
				continue;
			} else {
				if (board[xi][yi] == 'M') {
					minesCount++;
				}
			}
		}
		return minesCount;
	}

	char[][] convertStringToChar(String[][] board) {
		char[][] res = new char[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String s = board[i][j];
				char c = s.charAt(0);
				res[i][j] = c;
			}
		}

		return res;
	}

}
