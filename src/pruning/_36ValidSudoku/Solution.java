package pruning._36ValidSudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!isValidTry(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidTry(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == board[row][col]) {
                if (i != col) {
                    return false;
                }
            }
            if (board[i][col] != '.' && board[i][col] == board[row][col]) {
                if (i != row) {
                    return false;
                }
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == board[row][col]) {
                if ((3 * (row / 3) + i / 3) != row && (3 * (col / 3) + i % 3) != col) {
                    return false;
                }
            }
        }
        return true;
    }
}
