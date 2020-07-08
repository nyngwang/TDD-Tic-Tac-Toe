public class TicTacToe {
    public static final int NONE = -1;
    public static final int CIRCLE = 1;
    public static final int CROSS = 2;
    private int[][] board = new int[3][3];
    private int currentPlayer = CIRCLE;

    public void startGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = NONE;
            }
        }
        setCurrentPlayer(CIRCLE);
    }

    public int[][] getBoard() {
        return board;
    }

    public long getCurrentPlayer() {
        return currentPlayer;
    }

    public void play(int row, int col) {
        if (!blockIsPlaced(row, col))
            throw new BlockInvalidException();

        board[row][col] = currentPlayer;
        currentPlayer = currentPlayer == CROSS? CIRCLE: CROSS;
    }

    private boolean blockIsPlaced(int row, int col) {
        return board[row][col] != NONE;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getWinner() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2])
                return board[row][0];
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col])
                return board[0][col];
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
            || board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[1][1];

        return NONE;
    }
}
