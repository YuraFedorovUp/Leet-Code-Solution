

import java.util.ArrayList;
import java.util.List;

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
//        test();
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private void test() {
        final ListNode node = createNode(0, List.of(1, 2, -3, 3, 1));
        final ListNode result = removeZeroSumSublists(node);
        printMy(result);
        System.out.println("expected - 1,2,1");
        System.out.println("/////////////////////");
        System.out.println();
    }

    private void test1() {
        final ListNode node = createNode(0, List.of(1, 2, 3, -3, 4));
        final ListNode result = removeZeroSumSublists(node);
        printMy(result);
        System.out.println("expected - 1,2,4");
        System.out.println("/////////////////////");
        System.out.println();
    }

    private void test2() {
        final ListNode node = createNode(0, List.of(1, 2, 3, -3, -2));
        final ListNode result = removeZeroSumSublists(node);
        printMy(result);
        System.out.println("expected - 1");
        System.out.println("/////////////////////");
        System.out.println();
    }

    private void test3() {
        final ListNode node = createNode(0, List.of(2, 3, -3, -2));
        final ListNode result = removeZeroSumSublists(node);
        printMy(result);
        System.out.println("expected - null");
        System.out.println("/////////////////////");
        System.out.println();
    }

    private void test4() {
        final ListNode node = createNode(0, List.of(2, 3, -3, -2, 1, 2));
        final ListNode result = removeZeroSumSublists(node);
        printMy(result);
        System.out.println("expected - 1,2");
        System.out.println("/////////////////////");
        System.out.println();
    }

    private void test5() {
        final ListNode node = createNode(0, List.of(2, 3, -3, 4, -4, -2));
        final ListNode result = removeZeroSumSublists(node);
        printMy(result);
        System.out.println("expected - null");
        System.out.println("/////////////////////");
        System.out.println();
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

        public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode current = front;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        prefixSumToNode.put(0, front);

        while (current != null) {
            prefixSum += current.val;
            prefixSumToNode.put(prefixSum, current);
            current = current.next;
        }

        prefixSum = 0;
        current = front;
        while (current != null) {
            prefixSum += current.val;
            current.next = prefixSumToNode.get(prefixSum).next;
            current = current.next;
        }
        return front.next; 
    }
}