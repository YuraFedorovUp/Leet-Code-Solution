/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public  int[] findMode(TreeNode root) {
        Map<Integer, Integer> results = new HashMap<>();
        if (root == null) {
            return new int[]{};
        }
        if (root.right == null && root.left == null) {
            return new int[]{root.val};
        }
        fillResults(root, results);
        int[] ans = getAns(results);
        return ans;
    }

    private  void fillResults(TreeNode root, Map<Integer, Integer> results) {
        if (root == null) {
            return;
        }
        int val = root.val;
        results.put(val, results.getOrDefault(val, 0) + 1);
        fillResults(root.left, results);
        fillResults(root.right, results);

    }

    private  int[] getAns(Map<Integer, Integer> results) {
        final List<Integer> values = new ArrayList<>(results.values());
        Collections.sort(values);
        final Integer maxResult = values.get(values.size() - 1);
        final List<Integer> currentResults = results.entrySet().stream()
                .filter(e -> e.getValue().equals(maxResult))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        final int[] ans = new int[currentResults.size()];
        for (int i = 0; i < currentResults.size(); i++) {
            ans[i] = currentResults.get(i);
        }
        return ans;
    }
}