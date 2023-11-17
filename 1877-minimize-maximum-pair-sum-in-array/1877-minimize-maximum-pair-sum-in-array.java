import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int heights[] = new int[]{3, 5, 4, 2, 4, 6};
        System.out.println(minPairSum(heights));
    }

    private void printMy(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            if (nums[left] + nums[right] > ans) {
                ans = nums[left] + nums[right];
            }
            left++;
            right--;
        }
        return ans;
    }
}