import java.util.HashSet;
import java.util.Map;

class Solution {
    private Map<Character, Integer> taskToQuantities;
    private Map<Character, Integer> taskToRemovedLastTimes;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
//        test1();
//        test2();
//        test3();
//        test4();
    }

    private void test0() {
        final int[] nums = {1, 3, 4, 2, 2};
        final int result = findDuplicate(nums);
        System.out.println("ожидаемый   ответ - " + 2);
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }


    public int findDuplicate(int[] nums) {
        final var uniqNums = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            uniqNums.add(nums[i]);
            if (uniqNums.size() != i + 1) {
                return nums[i];
            }
        }
        throw new RuntimeException();
    }
}