import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        final int nums[] = new int[]{4, 6, 5, 9, 3, 7};
        final int l[] = new int[]{0, 0, 2};
        final int r[] = new int[]{2, 3, 5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    private void test1() {
        final int nums[] = new int[]{1, 4, 6, 2};
        final int l[] = new int[]{0, 2, 0, 1};
        final int r[] = new int[]{1, 3, 3, 3};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    private void test2() {
        final int nums[] = new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        final int l[] = new int[]{0, 1, 6, 4, 8, 7};
        final int r[] = new int[]{4, 4, 9, 7, 9, 10};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            final boolean result = getResult(nums, l[i], r[i]);
            results.add(result);
        }
        return results;
    }

    private boolean getResult(int[] nums, int l, int r) {
        if (l == r) {
            return false;
        }
        if (l + 1 == r) {
            return true;
        }
        int[] newArr = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            newArr[i - l] = nums[i];
        }
        Arrays.sort(newArr);
        int dif = newArr[1] - newArr[0];
        for (int i = 1; i < newArr.length; i++) {
            if (dif != newArr[i] - newArr[i - 1]) {
                return false;
            }
        }
        return true;
    }

}