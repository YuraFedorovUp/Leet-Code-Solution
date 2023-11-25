import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        //  test1();
        // test2();
        test3();
    }

    private void test() {
        final int nums[] = new int[]{2, 3, 5};
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    private void test1() {
        final int nums[] = new int[]{4, 7, 7, 7, 10};
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    private void test2() {
        final int nums[] = new int[]{7, 7, 7, 8, 9, 10};
        System.out.println("массив           " + Arrays.toString((nums)));
        System.out.println("ожидаемый ответ  [6, 6, 6, 6, 8, 12]");
        System.out.println("ответ            " + Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    private void test3() {
        final int nums[] = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 7};
        System.out.println("массив           " + Arrays.toString((nums)));
        System.out.println("ожидаемый ответ  [15, 15, 15, 11, 11, 11, 13, 13, 13, 45]");
        System.out.println("ответ            " + Arrays.toString(getSumAbsoluteDifferences(nums)));
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int length = nums.length;
        final int[] results = new int[length];
        final int prefix[] = new int[length];
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < length; i++) {
            final int leftCount = i == 0 ? 0 : i ;
            final int rightCount = i == length - 1 ? 0 : length - 1 - i;

            final int leftSum = i == 0 ? 0 : prefix[i - 1];
            final int rightSum = i == length - 1 ? 0 : prefix[length - 1] - prefix[i];

            final int resultLeft = leftCount * nums[i] - leftSum;
            final int resultRight =rightSum- rightCount * nums[i] ;
            final int result = resultLeft + resultRight;
            results[i] = result;


        }


        return results;
    }
}