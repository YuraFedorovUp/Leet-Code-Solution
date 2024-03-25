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
        final var duplicatesNums = new int[nums.length + 1];
        for (var num : nums) {
            if (duplicatesNums[num] == 1) {
                result.add(num);
            } else {
                duplicatesNums[num] = 1;
            }
        }
        return result;
    }
}