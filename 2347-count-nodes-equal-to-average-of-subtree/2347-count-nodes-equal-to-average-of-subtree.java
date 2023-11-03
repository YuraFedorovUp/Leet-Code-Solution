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
     private static int result;
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        doResult(root);
        return result;
    }

    private int[] doResult(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int val = root.val;
        int[] resultLeft = doResult(root.left);
        int[] resultRight = doResult(root.right);
        int nodeNumber = resultLeft[0] + resultRight[0] + 1;
        int sumOfSubtree = resultLeft[1] + resultRight[1] + val;
        int average = sumOfSubtree / nodeNumber;
        if (average == val) {
            result++;
        }
        return new int[]{nodeNumber, sumOfSubtree};
    }    
}