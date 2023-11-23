import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
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