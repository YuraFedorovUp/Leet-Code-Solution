import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
//        test();
//        test1();
//        test2();
        test3();
    }

    private void test() {
        final int matrix[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final List<List<Integer>> nums = getNums(matrix);
        printMy(findDiagonalOrder(nums));
        System.out.println("truly");
        printMy(new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9});
    }

    private void test1() {
        final int matrix[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        final List<List<Integer>> nums = getNums(matrix);
        printMy(findDiagonalOrder(nums));
        System.out.println("truly");
        printMy(new int[]{1, 5, 2, 9, 6, 3, 13, 10, 7, 4, 17, 14, 11, 8, 18, 15, 12, 19, 16, 20});
    }

    private void test2() {
        final int matrix[][] = new int[][]{{1, 2, 3, 4, 5}, {6, 7}, {8}, {9, 10, 11}, {12, 13, 14, 15, 16}};
        final List<List<Integer>> nums = getNums(matrix);
        printMy(findDiagonalOrder(nums));
        System.out.println("truly");
        printMy(new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16});
    }

    private void test3() {
        final int matrix[][] = new int[][]{{5, 6, 3, 10}, {9}, {1, 19}, {9, 9, 2}};
        final List<List<Integer>> nums = getNums(matrix);
        printMy(findDiagonalOrder(nums));
        System.out.println("truly");
        printMy(new int[]{5, 9, 6, 1, 3, 9, 19, 10, 9, 2});
    }

    private List<List<Integer>> getNums(int[][] matrix) {
        final List<List<Integer>> nums = new ArrayList<>();
        for (int[] m : matrix) {
            final List<Integer> rowsNumbers = new ArrayList<>();
            for (int number : m) {
                rowsNumbers.add(number);
            }
            nums.add(rowsNumbers);
        }
        return nums;
    }

    private void printMy(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        final Map<Integer, List<Integer>> hints = new HashMap<>();
        for (int y = 0; y < nums.size(); y++) {
            final List<Integer> rows = nums.get(y);
            for (int x = 0; x < rows.size(); x++) {
                int sum = x + y;
                List<Integer> value = hints.getOrDefault(sum, new ArrayList<>());
                value.add(rows.get(x));
                hints.put(sum, value);
                n++;
            }
        }
        int result[] = new int[n];
        int x = 0;
        int key = 0;
        while (hints.get(key) != null) {
            final List<Integer> values = hints.get(key++);
            for (int i = values.size() - 1; i >= 0; i--) {
                result[x++] = values.get(i);
            }
        }
        return result;
    }
}