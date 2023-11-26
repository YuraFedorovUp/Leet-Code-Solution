import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        //   test();
        test1();
    }

    private void test() {
        int nums0[] = new int[]{1, 2, 3, 4, 5};
        rotate(nums0, 2);
        System.out.println(Arrays.toString(nums0));
    }

    private void test1() {
        int nums0[] = new int[]{-1};
        rotate(nums0, 2);
        System.out.println(Arrays.toString(nums0));
    }

    public void rotate(int[] nums, int k) {
        final int length = nums.length;
        if (length == 1) {
            return;
        }
        final int threshold = k % length;
        reverse(0, length - 1, nums);
        reverse(0, threshold - 1, nums);
        reverse(threshold, length - 1, nums);
    }

    private void reverse(int left, int right, int[] nums) {
        while (left < right) {
            swap(left++, right--, nums);
        }
    }

    private void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}