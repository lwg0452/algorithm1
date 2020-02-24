package pruning._37SudokuSolver;

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char fill = '1'; fill <= '9'; fill++) {
                    if (isValidTry(board, i, j, fill)) {
                        board[i][j] = fill;
                        if (solve(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidTry(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
