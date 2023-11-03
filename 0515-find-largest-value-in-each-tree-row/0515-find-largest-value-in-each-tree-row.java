


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        if(root==null){
            return results;
        }
        nodes.add(root);
        while (nodes.size() != 0) {
            int size = nodes.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = nodes.remove();
                if (currentNode == null) {
                    continue;
                }
                int value = currentNode.val;
                if (value >= maxValue) {
                    maxValue = value;
                }
                if(currentNode.left!=null) {
                    nodes.add(currentNode.left);
                }
                if(currentNode.right!=null) {
                    nodes.add(currentNode.right);
                }
            }
            results.add(maxValue);
        }
        return results;
    }
}