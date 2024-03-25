import java.util.ArrayList;
import java.util.List;

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
        final var result = findDuplicates(nums);
        System.out.println("ожидаемый   ответ - " + "2,3");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    public List<Integer> findDuplicates(int[] nums) {
        final var result = new ArrayList<Integer>();
        for (var num : nums) {
            final var index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(index+1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}