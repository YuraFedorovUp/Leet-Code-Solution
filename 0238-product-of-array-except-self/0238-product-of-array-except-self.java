import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
    }

    private void test() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    private void test1() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    private void test2() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 0})));
    }

    public int[] productExceptSelf(int[] nums) {
        final int length = nums.length;
        final int[] results = new int[length];
        results[0] = 1;
        results[length - 1] = 1;
        int prefix = 1;
        for (int i = 0; i < length - 1; i++) {
            prefix *= nums[i];
            results[i + 1] = prefix;
        }
        int postfix = 1;
        for (int i = length - 1; i > 0; i--) {
            postfix *= nums[i];
            results[i - 1] *= postfix;
        }
        return results;
    }
}