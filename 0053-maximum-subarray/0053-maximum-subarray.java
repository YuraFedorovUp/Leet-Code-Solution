public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(maxSubArray(new int[]{-2, -1}));
        System.out.println(maxSubArray(new int[]{-1}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}