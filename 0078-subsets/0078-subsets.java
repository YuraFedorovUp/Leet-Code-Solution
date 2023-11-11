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
    }

    private void test() {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> results = new ArrayList<>();
        combine(0, nums, results, -1, new ArrayList<>());
        return results;
    }

    private void combine(int step, int[] nums, List<List<Integer>> results, int lastIndex, List<Integer> intermediaResult) {
        results.add(new ArrayList<>(intermediaResult));
        if (step >= nums.length) {
            return;
        }
        for (int i = lastIndex + 1; i < nums.length; i++) {
            intermediaResult.add(nums[i]);
            combine(step + 1, nums, results, i, intermediaResult);
            intermediaResult.remove(intermediaResult.size() - 1);
        }
    }


}