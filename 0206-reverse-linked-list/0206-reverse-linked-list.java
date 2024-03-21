public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test0();
        //   test1();
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
        if (head == null || head.next == null) {
            return head;
        }
        var cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}