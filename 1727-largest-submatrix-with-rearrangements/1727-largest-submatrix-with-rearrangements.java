import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int matrix[][] = new int[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(largestSubmatrix(matrix));
    }

    public int largestSubmatrix(int[][] matrix) {
        int result = 0;
        int yMax = matrix.length;
        int xMax = matrix[0].length;
        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                if (i > 0 && matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            int[] currRow = matrix[i].clone();
            Arrays.sort(currRow);
            for (int x = 0; x < xMax; x++) {
                result=Math.max(result,currRow[x]*(xMax-x));
            }
        }
        return result;
    }
}