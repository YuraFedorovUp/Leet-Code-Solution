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
        final var positiveNumbers = new HashSet<Integer>();
        for (var num : nums) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }
        final var sortedPositiveNumbers = new ArrayList<Integer>(positiveNumbers);
        sortedPositiveNumbers.sort(Comparator.comparingInt(Integer::intValue));
        for (int i = 0; i < sortedPositiveNumbers.size(); i++) {
            if (sortedPositiveNumbers.get(i) != i + 1) {
                return i + 1;
            }
        }
        return sortedPositiveNumbers.size() + 1;
    }
}