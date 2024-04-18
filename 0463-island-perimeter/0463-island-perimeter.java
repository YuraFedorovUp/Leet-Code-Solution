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
            int perimeter = 0;
            int yMax = grid.length;
            int xMax = grid[0].length;
            for (int y = 0; y < yMax; y++) {
                for (int x = 0; x < xMax; x++) {
                    if (grid[y][x] == 1) {
                        perimeter += 4;
                        if (y > 0 && grid[y -1][x] == 1) {
                            perimeter -= 2;
                        }
                        if (x > 0 && grid[y][x-1] == 1) {
                            perimeter -= 2;
                        }
                    }
                }
            }
            return perimeter;
        }
}