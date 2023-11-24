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
        final Deque<Integer> deque = getDeque(piles);
        while (!deque.isEmpty()) {
            deque.pollFirst();
            result += deque.pollFirst();
            deque.pollLast();
        }
        return result;
    }

    private Deque<Integer> getDeque(int[] piles) {
        final Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < piles.length; i++) {
            deque.addFirst(piles[i]);
        }
        System.out.println(deque);
        return deque;
    }
}