import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
    }

    private void test0() {
        final int[] nums = {1, 3, 4, 2, 2, 3};
        final var result = firstMissingPositive(nums);
        System.out.println("ожидаемый   ответ - " + "5");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

     public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }
}