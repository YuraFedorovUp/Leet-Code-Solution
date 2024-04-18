class Solution {
    private static final int[] DELTA_Y = {0, 1, 0, -1};
    private static final int[] DELTA_X = {1, 0, -1, 0};

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
    }

    private void test0() {
        final int[][] tickets = {{1}};
        final var result = islandPerimeter(tickets);
        System.out.println("ожидаемый   ответ - " + "4");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final int[][] tickets = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        final var result = islandPerimeter(tickets);
        System.out.println("ожидаемый   ответ - " + "16");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }


    public int islandPerimeter(int[][] grid) {
        var result = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 0) {
                    continue;
                }
                final var currentResult = getCurrentResult(y, x, grid);
                result += currentResult;
            }
        }
        return result;
    }

    private int getCurrentResult(int y, int x, int[][] grid) {
        final var yMax = grid.length;
        final var xMax = grid[0].length;
        var currentResult = 0;
        for (int i = 0; i < 4; i++) {
            final var currentY = DELTA_Y[i] + y;
            final var currentX = DELTA_X[i] + x;
            if (currentY < 0 || currentY >= yMax || currentX < 0 || currentX >= xMax) {
                currentResult++;
                continue;
            }
            if (grid[currentY][currentX] == 0) {
                currentResult++;
            }
        }
        return currentResult;
    }
}