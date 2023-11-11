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
        System.out.println(combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> results = new ArrayList<>();
        combine(0, n, k, results, -1, new ArrayList<>());
        return results;
    }

    private void combine(int step, int maxNumber, int maxStep, List<List<Integer>> results, int lastIndex, List<Integer> intermediaResult) {
        if (step >= maxStep) {
            results.add(new ArrayList<>(intermediaResult));
            return;
        }
        for (int i = lastIndex + 1; i < maxNumber; i++) {
            intermediaResult.add(i+1);
            combine(step + 1, maxNumber, maxStep, results, i, intermediaResult);
            intermediaResult.remove(intermediaResult.size() - 1);
        }
    }


}