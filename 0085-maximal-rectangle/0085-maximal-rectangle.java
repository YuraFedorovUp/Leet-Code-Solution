import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
//        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test10();
//        test11();
//        test12();
        test13();
    }

    private void test() {
        final int nums[] = new int[]{1, 2, 2, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }

    private void test1() {
        final int nums[] = new int[]{1, 3, 3, 3, 5, 2};
        System.out.println(largestRectangleArea(nums));
    }

    private void test2() {
        final int nums[] = new int[]{1, 2, 1, 0, 1, 2, 1, 1};
        System.out.println(largestRectangleArea(nums));
    }

    private void test3() {
        final int nums[] = new int[]{1, 2, 1, 0};
        System.out.println(largestRectangleArea(nums));
    }

    private void test4() {
        final int nums[] = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }

    private void test5() {
        final int nums[] = new int[]{5, 6, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }

    private void test6() {
        final int nums[] = new int[]{2, 1, 2};
        System.out.println(largestRectangleArea(nums));
    }

    private void test10() {
        final char nums[][] = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(nums));
    }

    private void test11() {
        final char nums[][] = new char[][]{{'1'}};
        System.out.println(maximalRectangle(nums));
    }


    private void test12() {
        final char nums[][] = new char[][]{{'0'}};
        System.out.println(maximalRectangle(nums));
    }

    private void test13() {
        final char nums[][] = new char[][]{{'1', '0'}, {'1', '0'}};
        System.out.println(maximalRectangle(nums));
    }

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        final int[][] gird = getGird(matrix);
        int[] heights = new int[matrix[0].length];
        for (int[] rowNumbers : gird) {
            fillHeights(heights, rowNumbers);
            int curAns = largestRectangleArea(Arrays.copyOf(heights, heights.length));
            if (curAns > ans) {
                ans = curAns;
            }
        }
        return ans;
    }

    private void fillHeights(int[] heights, int[] rowNumbers) {
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rowNumbers[i] == 0 ? 0 : heights[i] + 1;
        }
    }

    private int[][] getGird(char[][] matrix) {
        final int[][] gird = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                gird[i][j] = matrix[i][j] == '0' ? 0 : 1;
            }
        }
        return gird;
    }

    public int largestRectangleArea(int[] heights) {
        int result[] = new int[]{heights[0]};
        final Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            int currentHeight = heights[i];
            if (currentHeight == heights[stack.peek()]) {
                continue;
            }
            if (currentHeight > heights[stack.peek()]) {
                stack.add(i);
                if (currentHeight > result[0]) {
                    result[0] = currentHeight;
                }
            } else {
                countStack(stack, result, heights, i);
                stack.push(i);
            }
        }
        countStack(stack, result, heights);
        return result[0];
    }

    private void countStack(Stack<Integer> stack, int[] result, int[] heights, int i) {
        int index = -1;
        while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
            index = stack.pop();
            int square = (i - index) * heights[index];
            if (square > result[0]) {
                result[0] = square;
            }
        }
        if (index != -1) {
            stack.push(index);
            heights[index] = heights[i];
        }
    }

    private void countStack(Stack<Integer> stack, int[] result, int[] heights) {
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int square = (heights.length - index) * heights[index];
            if (square > result[0]) {
                result[0] = square;
            }
        }
    }
}