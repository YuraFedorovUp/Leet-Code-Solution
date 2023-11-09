public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        printMy(matrix);
    }

    private void test1() {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        printMy(matrix);
    }

    private void printMy(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean isFillZero = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    columns.add(j);
                    isFillZero = true;
                    for (int q = i; q >= 0; q--) {
                        matrix[q][j] = 0;
                    }
                } else if ((columns.contains(j))) {
                    matrix[i][j] = 0;
                }
            }
            if (isFillZero) {
                Arrays.fill(matrix[i], 0);
            }
        }
    }
}