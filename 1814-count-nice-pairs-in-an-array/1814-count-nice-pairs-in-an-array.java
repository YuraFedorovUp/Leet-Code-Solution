import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int MODULO = 1_000_000_000 + 7;
    private static Map<Integer, Integer> diferentsToQuantity;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        int nums[] = new int[]{42, 11, 1, 97};
        System.out.println(countNicePairs(nums));
    }

    private void test1() {
        int nums[] = new int[]{13, 10, 35, 24, 76};
        System.out.println(countNicePairs(nums));
    }

    public int countNicePairs(int[] nums) {
        diferentsToQuantity = getDiferentsToQuantity(nums);
        final int[] result = new int[1];
        final Map<Integer, Integer> quantityToResultDiffes = new HashMap<>();
        for (int quantity : diferentsToQuantity.values()) {
            int currentResult = quantityToResultDiffes.getOrDefault(quantity, getCurrentResult(quantity));
            result[0] = (result[0] + currentResult) % MODULO;

        }
        return result[0];
    }

    private Integer getCurrentResult(int quantity) {
        if (quantity < 2) {
            return 0;
        }
        if (quantity == 2) {
            return 1;
        }
        int curResult = 0;
        return ((quantity - 1) + getCurrentResult(quantity - 1))%MODULO;

    }

    private Map<Integer, Integer> getDiferentsToQuantity(int[] nums) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int reverseNum = getReverseNum(nums[i]);
            int different = nums[i] - reverseNum;
            int value = result.getOrDefault(different, 0) + 1;
            value %= MODULO;
            result.put(different, value);
        }
        return result;
    }
//    public int countNicePairs(int[] nums) {
//        int result = 0;
//        final List<Integer> reverseNums = getReverseNums(nums);
//        System.out.println(reverseNums);
//        return result;
//    }
//
//    private List<Integer> getReverseNums(int[] nums) {
//        final List<Integer> reverseNums = new ArrayList<>();
//        for (int number : nums) {
//            final int reverseNum = getReverseNum(number);
//            reverseNums.add(reverseNum);
//        }
//        return reverseNums;
//    }

    private int getReverseNum(int number) {
        int cur = number;
        int result = 0;
        while (cur != 0) {
            result = result * 10 + cur % 10;
            cur /= 10;
        }
        return result;
    }
}