import java.util.Arrays;
import java.util.stream.Collectors;

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
        final var nums = new int[]{-1, 2, -3, 3};
        final var result = findMaxK(nums);
        System.out.println("expected - " + "3");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final var nums = new int[]{-1, 10, 6, 7, -7, 1};
        final var result = findMaxK(nums);
        System.out.println("expected - " + "7");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final var nums = new int[]{-10, 8, 6, 7, -2, -3};
        final var result = findMaxK(nums);
        System.out.println("expected - " + "-1");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    public int findMaxK(int[] nums) {
        final var sortNumbers = Arrays.stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        for (int i = sortNumbers.size() - 1; i >= 0; i--) {
            final var number = sortNumbers.get(i);
            final var isReverseNumberPresent = sortNumbers.contains(-number);
            if (isReverseNumberPresent) {
                return number;
            }
        }
        return -1;
    }
}