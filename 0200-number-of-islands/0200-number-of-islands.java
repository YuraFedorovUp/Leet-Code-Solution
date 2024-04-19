import java.util.LinkedList;

class Solution {
    private static final int[] DELTA_Y = {0, 1, 0, -1};
    private static final int[] DELTA_X = {1, 0, -1, 0};
    private static boolean[][] inUse = null;
    private static int yMax = 0;
    private static int xMax = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
        test2();
        test3();
    }

    private void test0() {
        final char[][] tickets = {{'1'}};
        final var result = numIslands(tickets);
        System.out.println("ожидаемый   ответ - " + "1");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final char[][] tickets = {{'0'}};
        final var result = numIslands(tickets);
        System.out.println("ожидаемый   ответ - " + "0");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final char[][] tickets = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        final var result = numIslands(tickets);
        System.out.println("ожидаемый   ответ - " + "1");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }


    private void test3() {
        final char[][] tickets = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        final var result = numIslands(tickets);
        System.out.println("ожидаемый   ответ - " + "3");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    public int numIslands(char[][] grid) {
        var islandQuantity = 0;
        init(grid);
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if (grid[y][x] == '0' || inUse[y][x]) {
                    continue;
                }
                islandQuantity++;
                markIsland(y, x, grid);
                //printInUse();
            }

        }
        return islandQuantity;
    }

    private void init(char[][] grid) {
        yMax = grid.length;
        xMax = grid[0].length;
        inUse = new boolean[yMax][xMax];
    }


    private void markIsland(int y, int x, char[][] grid) {
        final var queue = new LinkedList<Integer>();
        queue.add(y);
        queue.add(x);
        while (queue.size() != 0) {
            final var yy = queue.remove(0);
            final var xx = queue.remove(0);
            for (int i = 0; i < 4; i++) {
                final var currentY = DELTA_Y[i] + yy;
                final var currentX = DELTA_X[i] + xx;
                if (currentY < 0 || currentY >= yMax || currentX < 0 || currentX >= xMax) {
                    continue;
                }
                if (grid[currentY][currentX] == '0' || inUse[currentY][currentX]) {
                    continue;
                }
                inUse[currentY][currentX] = true;
                queue.add(currentY);
                queue.add(currentX);
            }
        }
    }

    private void printInUse() {
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                System.out.print( inUse[y][x] + "  ");
            }
            System.out.println();
        }
        System.out.println("////////////////////");
    }
}