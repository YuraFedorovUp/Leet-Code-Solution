import java.util.HashMap;
import java.util.Map;

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
        System.out.println("ожидаемый ответ 4; ф-" + minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
    }

    private void test1() {
        System.out.println("ожидаемый ответ -1; ф-" + minOperations(new int[]{2, 1, 2, 2, 3, 3}));
    }

    private void test2() {
        System.out.println("ожидаемый ответ 2; ф-" + minOperations(new int[]{2, 2, 2, 2, 2}));
    }


    public int minOperations(int[] nums) {
        final Map<Integer, Integer> numberToQuantity = getNumberToQuantity(nums);
        if (isPresentSingleValue(numberToQuantity)) {
            return -1;
        }
        int result = 0;
        for (int quantity : numberToQuantity.values()) {
            int operationsNumbers = getOperationsNumbers(quantity);
            result += operationsNumbers;
        }
        return result;
    }

    private Map<Integer, Integer> getNumberToQuantity(int[] nums) {
        final Map<Integer, Integer> numberToQuantity = new HashMap<>();
        for (int num : nums) {
            int quantity = numberToQuantity.getOrDefault(num, 0) + 1;
            numberToQuantity.put(num, quantity);
        }
        return numberToQuantity;
    }

    private boolean isPresentSingleValue(Map<Integer, Integer> numberToQuantity) {
        return numberToQuantity.values().stream()
                .anyMatch(it -> it.equals(1));
    }


    private int getOperationsNumbers(int quantity) {
        if (quantity == 2 || quantity == 3) {
            return 1;
        }
        if (quantity % 3 == 0) {
            return quantity / 3;
        }
        return quantity / 3 + 1;
    }

}
