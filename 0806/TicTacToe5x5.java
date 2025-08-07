import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    /**
     * 初始化 5x5 棋盤
     * 時間複雜度：O(n^2)，其中 n = SIZE = 5
     */
    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    /**
     * 列印棋盤，含行列索引
     * 時間複雜度：O(n^2)
     */
    static void printBoard(char[][] board) {
        System.out.println("\n  0 1 2 3 4");
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < SIZE - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 嘗試在指定位置放置玩家棋子
     * 時間複雜度：O(1)
     */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }

        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }

        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    /**
     * 檢查是否有玩家在某一行、列、對角線上連成5個
     * 時間複雜度：O(n)，n=SIZE (掃每一行、列、對角線)
     */
    static char checkWinner(char[][] board) {
        // 檢查每一行
        for (int row = 0; row < SIZE; row++) {
            boolean win = true;
            char symbol = board[row][0];
            if (symbol == EMPTY) continue;
            for (int col = 1; col < SIZE; col++) {
                if (board[row][col] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return symbol;
        }

        // 檢查每一列
        for (int col = 0; col < SIZE; col++) {
            boolean win = true;
            char symbol = board[0][col];
            if (symbol == EMPTY) continue;
            for (int row = 1; row < SIZE; row++) {
                if (board[row][col] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return symbol;
        }

        // 檢查主對角線
        boolean win = true;
        char symbol = board[0][0];
        if (symbol != EMPTY) {
            for (int i = 1; i < SIZE; i++) {
                if (board[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return symbol;
        }

        // 檢查反對角線
        win = true;
        symbol = board[0][SIZE - 1];
        if (symbol != EMPTY) {
            for (int i = 1; i < SIZE; i++) {
                if (board[i][SIZE - 1 - i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return symbol;
        }

        return EMPTY; // 尚無勝者
    }

    /**
     * 檢查棋盤是否已滿
     * 時間複雜度：O(n^2)
     */
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }

    /**
     * 主程式執行入口，控制遊戲流程
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard(board);

        while (true) {
            System.out.printf("輪到玩家 %c，請輸入 row col (0-4)：", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);

                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("🎉 玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("🤝 平手！");
                    break;
                }

                // 換下一位玩家
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }

        scanner.close();
    }
}
