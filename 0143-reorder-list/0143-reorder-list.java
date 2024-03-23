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
    }

    private void test0() {
        final ListNode nodes = createNode(0, List.of(1, 2, 3, 4, 5));
        reorderList(nodes);

        System.out.println("expected - 1,5,2,4,3");
        System.out.println("actual - ");
        printMy(nodes);
        System.out.println("/////////////////////");
    }

    private void test1() {
        final ListNode nodes = createNode(0, List.of(1, 2, 3, 4));
        reorderList(nodes);

        System.out.println("expected - 1,4,2,3");
        System.out.println("actual - ");
        printMy(nodes);
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        final var nodes = new ArrayList<ListNode>();
        var node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        var nodesSize = nodes.size();
        ListNode last = null;
        final var lastIndex = nodesSize % 2 == 0 ? nodesSize / 2 : nodesSize / 2 + 1;
        for (int i = 0; i < lastIndex; i++) {
            var right = nodesSize - 1 - i;
            var left = i;
            final var rightNode = nodes.get(right);
            final var leftNode = nodes.get(left);
            leftNode.next = rightNode;
            if (last != null) {
                last.next = leftNode;
            }
            last = rightNode;
            if (i == nodesSize / 2 - 1 || left == right) {
                last.next = null;
            }

        }

    }
}