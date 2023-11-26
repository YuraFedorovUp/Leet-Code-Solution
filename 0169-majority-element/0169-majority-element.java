import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int nums[] = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        final Map<Integer, Integer> numberToQuantity = new HashMap<>();
        for (int number : nums) {
            numberToQuantity.put(number, numberToQuantity.getOrDefault(number, 0) + 1);
        }
        int number = 0;
        int maxQuantity = 0;
        for (Map.Entry<Integer, Integer> entry : numberToQuantity.entrySet()) {
            if (maxQuantity < entry.getValue()) {
                maxQuantity = entry.getValue();
                number = entry.getKey();
            }
        }
        return number;
    }
}