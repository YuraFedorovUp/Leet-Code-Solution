import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] rowNumbers : matrix) {
            fillHeights(heights, rowNumbers);
            int curAns = largestRectangleArea(Arrays.copyOf(heights, heights.length));
            if (curAns > ans) {
                ans = curAns;
            }
        }
        return ans;
    }

    private void fillHeights(int[] heights, char[] rowNumbers) {
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rowNumbers[i] == '0' ? 0 : heights[i] + 1;
        }
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