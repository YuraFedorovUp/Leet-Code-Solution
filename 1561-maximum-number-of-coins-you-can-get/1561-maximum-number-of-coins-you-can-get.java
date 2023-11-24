
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        final int nums[] = new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println(maxCoins(nums));
    }

    public int maxCoins(int[] piles) {
        int result = 0;
        Arrays.sort(piles);
        int left = 0;
        int right = piles.length - 2;
        while (left < right) {
            result += piles[right];
            right -= 2;
            left++;
        }
        return result;
    }
}