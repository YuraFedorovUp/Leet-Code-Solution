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
        final ListNode result = reverseList(nodes);

        System.out.println("expected - 5,4,3,2,1");
        System.out.println("actual - ");
        printMy(result);
        System.out.println("/////////////////////");
    }

    private void test1() {
        final ListNode nodes = createNode(0, List.of(1));
        final ListNode result = reverseList(nodes);

        System.out.println("expected - 5,4,3,2,1");
        System.out.println("actual - ");
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
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        var currentNode = head;
        final var nodes = new ArrayList<ListNode>();
        while (currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        nodes.add(0, null);
        currentNode = nodes.get(nodes.size() - 1);
        var result = currentNode;
        for (int i = nodes.size() - 2; i >= 0; i--) {
            final var node = nodes.get(i);
            currentNode.next = node;
            currentNode = node;

        }
        return result;
    }

}