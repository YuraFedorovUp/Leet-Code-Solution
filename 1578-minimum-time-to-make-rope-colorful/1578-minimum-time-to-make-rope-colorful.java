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
        System.out.println("ожидаемый ответ 3; ф-" + minCost("abaac", new int[]{1, 2, 3, 4, 5}));
    }

    private void test1() {
        System.out.println("ожидаемый ответ 0; ф-" + minCost("abc", new int[]{1, 2, 3}));
    }

    private void test2() {
        System.out.println("ожидаемый ответ 2; ф-" + minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }

    public int minCost(String colors, int[] neededTime) {
        var result = 0;
        Map<Character, Integer> colorToMaxPrice = null;
        for (int i = 0; i < colors.length(); i++) {
            int curPrice = neededTime[i];
            if (i != 0 && colors.charAt(i) == colors.charAt(i - 1)) {
                int lastPrice = colorToMaxPrice.getOrDefault(colors.charAt(i), 0);
                result += Math.min(lastPrice, curPrice);
                colorToMaxPrice.put(colors.charAt(i), Math.max(lastPrice, curPrice));
            } else {
                colorToMaxPrice = new HashMap<>();
                colorToMaxPrice.put(colors.charAt(i), curPrice);
            }

        }
        return result;
    }
}
