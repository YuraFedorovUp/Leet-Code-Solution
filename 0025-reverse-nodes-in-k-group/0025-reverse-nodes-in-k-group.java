/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultHead = null;
        ListNode previos = null;
        ListNode firstStartNode = head;

        while (true) {
            int index = k;
            final List<ListNode> nodes = new ArrayList<>();
            while (index-- > 0 && firstStartNode != null) {
                nodes.add(firstStartNode);
                firstStartNode = firstStartNode.next;
            }
            if (nodes.size() != k) {
                if (resultHead==null){
                    return head;
                }
                break;
            }
            ListNode currentStartNode = nodes.get(k - 1);
            ListNode featureStartNode = nodes.get(k - 1).next;
            for (int i = k - 2; i >= 0; i--) {
                currentStartNode.next = nodes.get(i);
                currentStartNode = currentStartNode.next;
            }

            if (resultHead == null) {
                resultHead = nodes.get(k - 1);
            } else {
                previos.next = nodes.get(k - 1);
            }
            nodes.get(0).next = featureStartNode;
            previos = nodes.get(0);

            firstStartNode = featureStartNode;
        }
        return resultHead;
    }
}