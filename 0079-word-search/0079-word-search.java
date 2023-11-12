import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final int[] X_MOVING = new int[]{1, 0, -1, 0};
    private static final int[] Y_MOVING = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test2();
        test3();
        test4();
    }

    private void test() {
        final char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }

    private void test2() {
        final char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "SEE"));
    }

    private void test3() {
        final char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCB"));
    }


    private void test4() {
        final char[][] board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        System.out.println(exist(board, "abcdefg"));
    }

    public boolean exist(char[][] board, String word) {
        if (!isBoardValid(board, word)) {
            return false;
        }
        int yMax = board.length;
        int xMax = board[0].length;
        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                final boolean used[][] = new boolean[yMax][xMax];
                used[i][j] = true;
                final boolean result = exist(i, j, 0, board, word, used);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardValid(char[][] board, String word) {
        final Set<Character> characters = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                characters.add(board[i][j]);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (!characters.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean exist(int y, int x, int step, char[][] board, String word, boolean used[][]) {
        if (step == word.length() - 1) {
            return word.charAt(step) == board[y][x];
        }
        if (word.charAt(step) != board[y][x]) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int yCur = y + Y_MOVING[i];
            int xCur = x + X_MOVING[i];
            if (isNotValidate(yCur, xCur, board.length, board[0].length)) {
                continue;
            }
            if (used[yCur][xCur]) {
                continue;
            }
            used[yCur][xCur] = true;
            final boolean result = exist(yCur, xCur, step + 1, board, word, used);
            if (result) {
                return true;
            }
            used[yCur][xCur] = false;
        }
        return false;
    }

    private boolean isNotValidate(int yCur, int xCur, int yMax, int xMax) {
        return yCur < 0 || yCur >= yMax || xCur < 0 || xCur >= xMax;
    }
}