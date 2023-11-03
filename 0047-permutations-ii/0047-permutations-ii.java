

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(permuteUnique(new int[]{0, 1, 1}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        final Set<List<Integer>> results = new HashSet<>();
        permute(0, new boolean[nums.length], new LinkedList<Integer>(), results, nums);
        return new ArrayList<>(results);
    }

    private void permute(int step, boolean[] used, LinkedList<Integer> currentResults, Set<List<Integer>> results, int[] nums) {
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