class Solution {
  public int uniquePaths(int m, int n) {
        final int[][] grid = new int[m][n];
        grid[0][0] = 1;
        final Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        queue.add(0);
        while (queue.size() != 0) {
            int y = queue.remove();
            int x = queue.remove();
            addStep(y + 1, x, queue, grid, m, n, grid[y][x]);
            addStep(y, x + 1, queue, grid, m, n, grid[y][x]);
        }
        return grid[m - 1][n - 1];
    }

    private void addStep(int y, int x, Queue<Integer> queue, int[][] grid, int m, int n, int mean) {
        if (y >= m || y < 0 || x >= n || x < 0) {
            return;
        }
        if (grid[y][x] == 0) {
            queue.add(y);
            queue.add(x);
        }
        grid[y][x] += mean;
    }
}