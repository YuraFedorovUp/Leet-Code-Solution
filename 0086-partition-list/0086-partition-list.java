import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
        test2();
        test3();
    }

    private void test1() {
        ListNode l1 = createNode(0, List.of(1, 4, 3, 2, 5, 2));
        ListNode l2 = createNode(0, List.of(9, 9, 9, 9));
        ListNode node = partition(l1, 3);
        printMy(node);
    }

    private void test2() {
        ListNode l1 = createNode(0, List.of(1, 4, 2));
        ListNode l2 = createNode(0, List.of(9, 9, 9, 9));
        ListNode node = partition(l1, 3);
        printMy(node);
    }

    private void test3() {
        ListNode l1 = createNode(0, List.of(2, 1));
        ListNode l2 = createNode(0, List.of(9, 9, 9, 9));
        ListNode node = partition(l1, 2);
        printMy(node);
    }

    private void printMy(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode ans = head;
        while (true) {
            final MovedNodeDescription nodeDescription = getMovedNodeDescription(ans, x);
            if (nodeDescription.node == null) {
                break;
            }
            if (nodeDescription.node == head) {
                return head;
            }
            ans = removedNode(ans, nodeDescription);
            printMy(ans);
        }
        return ans;
    }

    private ListNode removedNode(ListNode head, MovedNodeDescription nodeDescription) {
        final ListNode removedNode = nodeDescription.node;
        deleteNode(head, nodeDescription.node);
        if (nodeDescription.insertIndex == 0) {
            removedNode.next = head;
            return removedNode;
        }
        final ListNode prev = getPrev(head, nodeDescription.insertIndex);
        final ListNode temp = prev.next;
        prev.next = removedNode;
        removedNode.next = temp;
        return head;
    }

    private ListNode getPrev(ListNode head, int insertIndex) {
        ListNode cur = head;
        for (int i = 0; i < insertIndex - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private void deleteNode(ListNode head, ListNode node) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur == node) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        prev.next = node.next;
    }

    private MovedNodeDescription getMovedNodeDescription(ListNode head, int x) {
        int index = -1;
        int insertIndex = -1;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            if (insertIndex == -1 && cur.val >= x) {
                insertIndex = size;
            }
            if (insertIndex != -1 && cur.val < x) {
                break;
            }
            size++;
            cur = cur.next;
        }
        return new MovedNodeDescription(size, insertIndex, cur);

    }


    private ListNode createNode(int step, List<Integer> integers) {
        if (integers.size() == step) {
            return null;
        }
        return new ListNode(integers.get(step), createNode(step + 1, integers));

    }

    class MovedNodeDescription {
        private int index = -1;
        private int insertIndex = -1;
        private ListNode node;

        public MovedNodeDescription(int index, int insertIndex, ListNode node) {
            this.index = index;
            this.insertIndex = insertIndex;
            this.node = node;
        }
    }
}
