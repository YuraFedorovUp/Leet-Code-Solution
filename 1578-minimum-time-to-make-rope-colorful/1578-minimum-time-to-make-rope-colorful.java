public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
//        test();
//        test1();
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
        final int[] restNeededTime = new int[neededTime.length];
        for (int i = 0; i < colors.length() - 1; i++) {
            char color = colors.charAt(i);
            if (color == colors.charAt(i + 1)) {
                int curPrice = Math.max(restNeededTime[i], neededTime[i]);
                restNeededTime[i + 1] = Math.max(curPrice, neededTime[i + 1]);
                result += Math.min(curPrice, neededTime[i + 1]);
            }
        }
        return result;
    }
}
