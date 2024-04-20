import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        test4();
    }

    private void test0() {
        final int[][] lands = {{'0'}};
        final var result = findFarmland(lands);
        System.out.println("ожидаемый   ответ - " + "пусто");
        System.out.println("фактический ответ - ");
        printMy(result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final int[][] lands = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        final var result = findFarmland(lands);
        System.out.println("ожидаемый   ответ - " + "[[0,0,0,0],[1,1,2,2]]");
        System.out.println("фактический ответ - ");
        printMy(result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final int[][] lands = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        final var result = findFarmland(lands);
        System.out.println("ожидаемый   ответ - " + "пусто");
        System.out.println("фактический ответ - ");
        printMy(result);
        System.out.println("//////////////////////");
    }

    private void test3() {
        final int[][] lands = {{1, 1}, {1, 1}};
        final var result = findFarmland(lands);
        System.out.println("ожидаемый   ответ - " + "0,0,1,1");
        System.out.println("фактический ответ - ");
        printMy(result);
        System.out.println("//////////////////////");
    }


    private void test4() {
        final int[][] lands = {{1, 1}, {0,0}};
        final var result = findFarmland(lands);
        System.out.println("ожидаемый   ответ - " + "0,0,0,1");
        System.out.println("фактический ответ - ");
        printMy(result);
        System.out.println("//////////////////////");
    }

    private void printMy(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] findFarmland(int[][] land) {
        final List<List<Integer>> cornerPoints = new ArrayList<>();
        init(land);
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if (land[y][x] == 0 || inUse[y][x]) {
                    continue;
                }
                final var cornerPoint = getCornerPoint(y, x, land);
                cornerPoints.add(cornerPoint);
            }
        }
        return mapResult(cornerPoints);
    }

    private void init(int[][] grid) {
        yMax = grid.length;
        xMax = grid[0].length;
        inUse = new boolean[yMax][xMax];
    }


    private List<Integer> getCornerPoint(int y, int x, int[][] grid) {
        final var cornerPoint = new ArrayList<Integer>();
        final var queue = new LinkedList<Integer>();
        queue.add(y);
        queue.add(x);
        cornerPoint.add(y);
        cornerPoint.add(x);
        var lastY = y;
        var lastX = x;
        inUse[y][x] = true;
        while (queue.size() != 0) {
            final var yy = queue.remove(0);
            final var xx = queue.remove(0);
            for (int i = 0; i < 4; i++) {
                final var currentY = DELTA_Y[i] + yy;
                final var currentX = DELTA_X[i] + xx;
                if (currentY < 0
                        || currentY >= yMax
                        || currentX < 0
                        || currentX >= xMax
                        || grid[currentY][currentX] == 0
                        || inUse[currentY][currentX]) {
                    continue;
                }

                inUse[currentY][currentX] = true;
                queue.add(currentY);
                queue.add(currentX);
                lastY = currentY;
                lastX = currentX;

            }
        }
        cornerPoint.add(lastY);
        cornerPoint.add(lastX);
        return cornerPoint;
    }

    private int[][] mapResult(List<List<Integer>> cornerPoints) {
        int[][] result = new int[cornerPoints.size()][4];
        for (int i = 0; i < cornerPoints.size(); i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = cornerPoints.get(i).get(j);
            }
        }
        return result;
    }
}