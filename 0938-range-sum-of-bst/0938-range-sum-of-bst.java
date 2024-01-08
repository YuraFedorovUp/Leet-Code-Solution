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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        int result = getValue(node.val, low, high);
        return result + dfs(node.left, low, high) + dfs(node.right, low, high);
    }

    private int getValue(int val, int low, int high) {
        return (val >= low && val <= high) ? val : 0;
    }
}