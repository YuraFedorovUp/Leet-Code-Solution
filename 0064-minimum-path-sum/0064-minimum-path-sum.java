import java.util.ArrayDeque;
import java.util.Arrays;
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
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] pathSum = new int[m][n];
        for (int[] ps : pathSum) {
            Arrays.fill(ps, Integer.MAX_VALUE);
        }
        pathSum[0][0] = grid[0][0];
        final Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);
        queue.add(0);

        while (queue.size() != 0) {
            int y = queue.remove();
            int x = queue.remove();
            addStep(y + 1, x, queue, grid, m, n, pathSum[y][x], pathSum);
            addStep(y, x + 1, queue, grid, m, n, pathSum[y][x], pathSum);
        }
        return pathSum[m - 1][n - 1];
    }

    private void addStep(int y, int x, Queue<Integer> queue, int[][] obstacleGrid, int m, int n, int oldSum, int[][] pathSum) {
        if (y >= m || y < 0 || x >= n || x < 0) {
            return;
        }
        if (pathSum[y][x] != Integer.MAX_VALUE) {
            pathSum[y][x] = Math.min(oldSum + obstacleGrid[y][x], pathSum[y][x]);
            return;
        }
        queue.add(y);
        queue.add(x);
        pathSum[y][x] = oldSum + obstacleGrid[y][x];
    }
}