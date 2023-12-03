import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Map<Character, Integer> charToQuantity;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int xDelta = Math.abs(Math.max(points[i][0], points[i + 1][0]) - Math.min(points[i][0], points[i + 1][0]));
            int yDelta = Math.abs(Math.max(points[i][1], points[i + 1][1]) - Math.min(points[i][1], points[i + 1][1]));
            final int diagonalTime = Math.abs(Math.min(xDelta, yDelta));
            final int lineTime = Math.abs(xDelta - yDelta);
            result += diagonalTime + lineTime;
        }
        return result;
    }
}