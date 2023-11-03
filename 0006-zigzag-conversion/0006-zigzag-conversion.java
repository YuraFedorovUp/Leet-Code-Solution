
public class Solution {
    DIRECTION direction = DIRECTION.DOWN;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        int x = 0;
        int y = 0;
        String[][] arr = new String[numRows][s.length() / numRows + 1000];
        int tresholder = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[y][x] = "" + s.charAt(i);
            if (i % (numRows - 1) == 0 && i != 0) {
                changeDirection();
                tresholder = 0;
            }
            if (direction == DIRECTION.DOWN) {
                y++;
            } else {
                y--;
                x++;
            }
            tresholder++;
        }
        String res = getResult(arr);
        return res;
    }

    private String getResult(String[][] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == null) {
                    continue;
                }
                result += arr[i][j];
            }
        }
        return result;
    }

    private void changeDirection() {
        direction = direction == DIRECTION.DOWN ? DIRECTION.RIGHT : DIRECTION.DOWN;
    }

    static enum DIRECTION {
        DOWN, RIGHT
    }
}