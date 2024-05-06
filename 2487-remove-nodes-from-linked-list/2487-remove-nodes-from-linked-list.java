import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test0();
        test1();
        test2();
        test3();
    }

    private void test0() {
        final ListNode nodes = createNode(0, List.of(5, 2, 13, 3, 8));
        final var result = removeNodes(nodes);

        System.out.println("expected - 13,8");
        System.out.print("actual - ");
        printMy(result);
        System.out.println("/////////////////////");
    }

    private void test1() {
        final ListNode nodes = createNode(0, List.of(2, 1));
        final var result = removeNodes(nodes);

        System.out.println("expected - 2,1");
        System.out.print("actual - ");
        printMy(result);
        System.out.println("/////////////////////");
    }

    private void test2() {
        final ListNode nodes = createNode(0, List.of(1, 2));
        final var result = removeNodes(nodes);

        System.out.println("expected - 2");
        System.out.print("actual - ");
        printMy(result);
        System.out.println("/////////////////////");
    }

    private void test3() {
        final ListNode nodes = createNode(0, List.of(1));
        final var result = removeNodes(nodes);

        System.out.println("expected - 1");
        System.out.print("actual - ");
        printMy(result);
        System.out.println("/////////////////////");
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

    public ListNode removeNodes(ListNode head) {
        var reverseHead = getReverseHead(head);
        var prev = reverseHead;
        var prevVal = 0;
        var cur = reverseHead.next;
        var curVal = 0;
        while (cur != null) {
            prevVal = prev.val;
            curVal = cur.val;
            if (prevVal > curVal) {
                prev.next = null;
            } else {
                prev.next = cur;
                prev = cur;
            }
            cur = cur.next;
        }
        return getReverseHead(reverseHead);
    }

    private ListNode getReverseHead(ListNode head) {
        final var nodes = new ArrayList<ListNode>();
        var cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        for (int i = nodes.size() - 1; i > 0; i--) {
            final var node = nodes.get(i);
            final var nextNode = nodes.get(i - 1);
            node.next = nextNode;
            if (i == 1) {
                nextNode.next = null;
            }
        }
        return nodes.size() == 0 ? null : nodes.get(nodes.size() - 1);
    }


}