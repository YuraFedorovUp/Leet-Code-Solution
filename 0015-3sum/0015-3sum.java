class Solution {
 public List<List<Integer>> threeSum(int[] candidates) {
        Set<List<Integer>> results = new HashSet<>();
        int[] num = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(num);

        for (int i = 0; i < num.length - 1; i++) {
            int j = i + 1;

            int k = num.length - 1;
            while (j < k) {
                if (num[i] + num[j] + num[k] == 0) {
                    results.add(List.of(num[i], num[j], num[k]));
                    j++;
                    k--;
                } else if (num[i] + num[j] + num[k] > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }


        return new ArrayList<>(results);
    }
}