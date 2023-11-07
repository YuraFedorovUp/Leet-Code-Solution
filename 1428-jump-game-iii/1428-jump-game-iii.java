import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        final boolean[] used = new boolean[arr.length];
        while (deque.size() != 0) {
            int currentIndex = deque.remove();
            int curJump = arr[currentIndex];
            if (curJump == 0) {
                return true;
            }
            jamp(arr, deque, currentIndex + curJump, used);
            jamp(arr, deque, currentIndex - curJump, used);
        }

        return false;
    }

    private void jamp(int[] arr, Queue<Integer> deque, int pretedent, boolean[] used) {
        if (pretedent >= arr.length || pretedent < 0 || used[pretedent]) {
            return;
        }
        used[pretedent] = true;
        deque.add(pretedent);
    }
}