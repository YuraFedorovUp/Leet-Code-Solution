import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> results = new ArrayList<>();
        permute(0, new boolean[nums.length], new LinkedList<Integer>(), results, nums);
        return results;
    }

    private void permute(int step, boolean[] used, LinkedList<Integer> currentResults, List<List<Integer>> results, int[] nums) {
        if (step == nums.length) {
            results.add(new ArrayList<>(currentResults));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            currentResults.add(nums[i]);
            permute(step + 1, used, currentResults, results, nums);
            currentResults.remove(currentResults.size() - 1);
            used[i] = false;
        }
    }
}