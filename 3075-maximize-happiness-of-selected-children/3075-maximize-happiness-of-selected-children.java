import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
        test2();
    }

    private void test0() {
        final var happiness = new int[]{1, 2, 3};
        final var result = maximumHappinessSum(happiness, 2);
        System.out.println("expected - " + "4");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final var happiness = new int[]{1, 1, 1, 1};
        final var result = maximumHappinessSum(happiness, 2);
        System.out.println("expected - " + "1");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final var happiness = new int[]{2, 3, 4, 5};
        final var result = maximumHappinessSum(happiness, 1);
        System.out.println("expected - " + "5");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }
    
    public long maximumHappinessSum(int[] happiness, int k) {
        var result = 0L;
        Arrays.sort(happiness);
        for (int i = 0; i < k && i < happiness.length; i++) {
            final var index = happiness.length - i - 1;
            final var curHappy = Math.max(0, happiness[index] - i);
            result += curHappy;
        }
        return result;
    }
}