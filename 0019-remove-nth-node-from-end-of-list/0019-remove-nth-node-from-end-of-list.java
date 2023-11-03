

import java.util.List;



public class Solution {


    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        ListNode l1 = createNode(0, List.of(0, 1, 2));
        ListNode node = removeNthFromEnd(l1, 3);
        printMy(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        final int length = getLengthMy(head);
        int currentLength = 0;
        ListNode currentNode = head;
        while (true) {
            if (n == length) {
                return n == 1 ? null : head.next;
            }
            if (currentLength + n + 1 == length) {
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
            currentLength++;
        }
        return head;
    }

    private int getLengthMy(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode createNode(int step, List<Integer> integers) {
        if (integers.size() == step) {
            return null;
        }
        return new ListNode(integers.get(step), createNode(step + 1, integers));

    }

    private void printMy(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}