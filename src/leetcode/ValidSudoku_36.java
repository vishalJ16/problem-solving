/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author v0j008y 15 Sept 2021 00:51:20
 */
public class ValidSudoku_36 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] board = { { "5", "3", ".", ".", "7", ".", ".", ".", "." },
				{ "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
				{ "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
				{ "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
				{ ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
		isValidSudoku(board);
	}

	static boolean isValidSudoku(String[][] board) {

		int m = board.length;
		int n = board[0].length;

		boolean ans = checkRow(board, m, n) && checkColumn(board, m, n) && checkBox(board, m, n);
		System.out.println();
		return ans;

	}

	static boolean checkRow(String[][] board, int m, int n) {
		for (int i = 0; i < m; i++) {
			Set<String> set = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (!board[i][j].equals(".")) {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}
		return true;
	}

	static boolean checkColumn(String[][] board, int m, int n) {
		for (int i = 0; i < n; i++) {
			Set<String> set = new HashSet<>();
			for (int j = 0; j < m; j++) {
				if (!board[j][i].equals(".")) {
					if (set.contains(board[j][i])) {
						return false;
					}
					set.add(board[j][i]);
				}
			}
		}
		return true;
	}

	static boolean checkBox(String[][] board, int m, int n) {
		int count = 0;
		for (int i = 0; i < m; i = i + 3) {
			for (int j = 0; j < n; j = j + 3) {
				Set<String> set = new HashSet<>();
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						count++;
						if (!board[i + x][j + y].equals(".")) {
							if (set.contains(board[i + x][j + y])) {
								return false;
							}
							set.add(board[i + x][j + y]);
						}
					}
				}
			}
		}
		System.out.println(count);
		return true;
	}

}
