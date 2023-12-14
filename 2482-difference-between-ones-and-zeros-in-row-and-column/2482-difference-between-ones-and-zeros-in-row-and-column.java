import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int matrix[][] = new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        int result[][] = onesMinusZeros(matrix);
        printMy(result);
    }

    private void printMy(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        int[] xOnes = new int[x];
        int[] yOnes = new int[y];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xOnes[j]++;
                    yOnes[i]++;
                }
            }
        }
        int result[][] = new int[y][x];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = getMeans(i, j, xOnes, yOnes, y, x);

            }
        }
        return result;
    }

    private int getMeans(int i, int j, int[] xOnes, int[] yOnes, int y, int x) {
        return xOnes[j] + yOnes[i]-(y - yOnes[i]) - (x - xOnes[j]);
    }
}