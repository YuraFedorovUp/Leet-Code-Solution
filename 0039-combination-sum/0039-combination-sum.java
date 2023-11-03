class Solution {
 public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int[] num = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(num);
        combinationSum(0, num, results, new ArrayList<Integer>(), 0, target);
        return results;
    }

    private void combinationSum(int lastIndex, int[] num, List<List<Integer>> results, ArrayList<Integer> tempResults, int currentSum, int target) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            results.add(new ArrayList<>(tempResults));
            return;
        }
        for (int i = lastIndex; i < num.length; i++) {
            int number = num[i];
            if (currentSum + number > target) {
                return;
            }
            tempResults.add(number);
            combinationSum(i, num, results, tempResults, currentSum + number, target);
            tempResults.remove(tempResults.size() - 1);
        }
        return;
    }
}