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
        int product = getProduct(nums);
        if (product == 0) {
            product = getProductWithotOneZero(nums);
            if (product != 0) {
                for (int i = 0; i < length; i++) {
                    if (nums[i] == 0) {
                        results[i] = product;
                        return results;
                    }
                }
            }
            return results;
        }
        for (int i = 0; i < length; i++) {
            results[i] = product / nums[i];
        }
        return results;
    }

    private int getProductWithotOneZero(int[] nums) {
        boolean isZeroPresent = false;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!isZeroPresent && nums[i] == 0) {
                isZeroPresent = true;
                continue;
            }
            product *= nums[i];
        }
        return product;
    }

    private int getProduct(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        return product;
    }
}