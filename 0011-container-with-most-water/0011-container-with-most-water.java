


public class Solution {
    private int[] maxAreas;
    private int arrLength;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = getArea(height, left, right);
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    private int getArea(int[] height, int left, int right) {
        int high = height[left] > height[right] ? height[right] : height[left];
        return high * (right - left);
    }
}