


import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int BOARD_LENGTH = 9;

    public boolean isValidSudoku(char[][] board) {
         return (isValidHorizon(board) && isValidVertical(board) && isValidSector(board));
    }

    private boolean isValidSector(char[][] board) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                char[] checkedArray = new char[BOARD_LENGTH];
                int n = 0;
                for (int i = y * 3; i < (y + 1) * 3; i++) {
                    for (int j = x * 3; j < (x + 1) * 3; j++) {
                        checkedArray[n++] = board[i][j];
                    }
                }
                if (!isValid(checkedArray)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidVertical(char[][] board) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            char[] checkedArray = new char[BOARD_LENGTH];
            for (int j = 0; j < BOARD_LENGTH; j++) {
                checkedArray[j] = board[j][i];
            }
            if (!isValid(checkedArray)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidHorizon(char[][] board) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            char[] checkedArray = new char[BOARD_LENGTH];
            for (int j = 0; j < BOARD_LENGTH; j++) {
                checkedArray[j] = board[i][j];
            }
            if (!isValid(checkedArray)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[] checkedArray) {
        final List<Character> characters = new ArrayList<>();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            char ch = checkedArray[i];
            if (ch == '.') {
                continue;
            }
            if (characters.contains(ch)) {
                return false;
            }
            characters.add(ch);
        }
        return true;
    }
}