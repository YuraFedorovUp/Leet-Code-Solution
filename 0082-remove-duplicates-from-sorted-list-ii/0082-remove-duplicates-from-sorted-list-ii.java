

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;



public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
    }

    private void test() {
        final ListNode node = createNode(0, List.of(1, 2, 3, 3, 4, 4, 5));
        final ListNode result = deleteDuplicates(node);
        printMy(result);
    }

    private void test1() {
        final ListNode node = createNode(0, List.of(1, 2, 3, 4));
        final ListNode result = deleteDuplicates(node);
        printMy(result);
    }

    private void test2() {
        final ListNode node = createNode(0, List.of(1));
        final ListNode result = deleteDuplicates(node);
        printMy(result);
    }

    private void test3() {
        final ListNode node = createNode(0, List.of(1,2));
        final ListNode result = deleteDuplicates(node);
        printMy(result);
    }

    private void printMy(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
        System.out.println();
    }

    private ListNode createNode(int step, List<Integer> integers) {
        if (integers.size() == step) {
            return null;
        }
        return new ListNode(integers.get(step), createNode(step + 1, integers));
    }

    public ListNode deleteDuplicates(ListNode head) {
        final ListNode nextNodeIsResult = new ListNode();
        nextNodeIsResult.next = head;
        ListNode previous = nextNodeIsResult;
        while (previous.next != null) {
            ListNode node = previous.next;
            final int value = node.val;
            if (node.next == null) {
               // previous.next = null;
                break;
            } else if (node.next.val != value) {
                previous = node;
            } else {
                while (node!= null && value == node.val) {
                    node = node.next;
                }
                previous.next = node;
            }
        }
        return nextNodeIsResult.next;
    }
}