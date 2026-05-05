package org.example;

public class TicTacToe {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'X', 'O'},
        {'O', 'X', 'O'}
    };

    /**
     * UC10 checks whether the game has ended in a draw
     * by ensuring no empty cells remain on the board.
     */
    static boolean isDraw() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                // If any cell is still empty, it's not a draw yet
                if (board[r][c] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Entry point to test draw detection logic
        System.out.println("Is the game a draw? " + isDraw());
    }

    /**
     * UC9 Winning Logic (kept for context)
     */
    public static boolean hasWon(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }
}