import java.util.HashSet;

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
        int ans = -1;
        final var seen = new HashSet<>();
        for (int num : nums) {
            int absNum = Math.abs(num);
            if (absNum > ans && seen.contains(-num))
                ans = absNum;
            seen.add(num);
        }
        return ans;
    }
}