import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY_SLOT = '-';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';

    private char[][] board;

    public ConnectFour() {
        board = new char[ROWS][COLUMNS];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY_SLOT;
            }
        }
    }

    private void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }

    private boolean dropPiece(int column, char player) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY_SLOT) {
                board[row][column] = player;
                return true;
            }
        }
        return false; 
    }

    private boolean checkWin(char player) {
        // Check rows
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == player &&
                    board[row][col + 1] == player &&
                    board[row][col + 2] == player &&
                    board[row][col + 3] == player) {
                    return true;
                }
            }
        }

        
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col] == player &&
                    board[row + 2][col] == player &&
                    board[row + 3][col] == player) {
                    return true;
                }
            }
        }

        
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player &&
                    board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 3; col < COLUMNS; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col - 1] == player &&
                    board[row + 2][col - 2] == player &&
                    board[row + 3][col - 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_ONE;
        boolean isGameFinished = false;

        while (!isGameFinished) {
            System.out.println("Player " + currentPlayer + "'s turn");
            printBoard();
            System.out.print("Enter column number (0-6): ");
            int column = scanner.nextInt();

            if (column < 0 || column >= COLUMNS) {
                System.out.println("Invalid column number. Try again.");
                continue;
            }

            if (!dropPiece(column, currentPlayer)) {
                System.out.println("Column is full. Try again.");
                continue;
            }

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                isGameFinished = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                isGameFinished = true;
            } else {
                currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
            }
        }
        scanner.close();
    }

    private boolean isBoardFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.playGame();
    }
}
