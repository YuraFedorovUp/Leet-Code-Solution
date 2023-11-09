import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        final Queue<Integer> queue = new ArrayDeque<>();
        if (obstacleGrid[0][0] != 1) {
            queue.add(0);
            queue.add(0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        obstacleGrid[0][0] = 1;
        while (queue.size() != 0) {
            int y = queue.remove();
            int x = queue.remove();
            addStep(y + 1, x, queue, obstacleGrid, m, n, obstacleGrid[y][x]);
            addStep(y, x + 1, queue, obstacleGrid, m, n, obstacleGrid[y][x]);
        }
        int result = obstacleGrid[m - 1][n - 1];
        return result;
    }

    private void addStep(int y, int x, Queue<Integer> queue, int[][] obstacleGrid, int m, int n, int mean) {
        if (y >= m || y < 0 || x >= n || x < 0) {
            return;
        }
        if (obstacleGrid[y][x] == -1) {
            return;
        }
        if (obstacleGrid[y][x] == 0) {
            queue.add(y);
            queue.add(x);
        }
        obstacleGrid[y][x] += mean;
    }
}