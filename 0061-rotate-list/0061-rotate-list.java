import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        ListNode l1 = createNode(0, List.of(1, 2, 3, 4, 5));
        ListNode node = rotateRight(l1, 2);
        printMy(node);
    }

    private void test1() {

        ListNode l2 = createNode(0, List.of(0, 1, 2));
        ListNode node = rotateRight(l2, 4);
        printMy(node);
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||k==0){
            return head;
        }
        int size = getSize(head);
        int threshold = k % size;
        if (threshold == 0) {
            return head;
        }
        ListNode currentHead = head;
        ListNode newHead = getNewHead(size - threshold, currentHead);
        insertInNextNode(size - threshold - 1, head, null);
        insertInNextNode(threshold - 1, newHead, currentHead);
        return newHead;
    }

    private void insertInNextNode(int index, ListNode head, ListNode nextNode) {
        ListNode currentNode = head;
        int currentIndex = 0;
        while (currentIndex++ < index) {
            currentNode = currentNode.next;
        }
        currentNode.next = nextNode;
    }

    private ListNode getNewHead(int index, ListNode node) {
        ListNode currentNode = node;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode;
    }

    private int getSize(ListNode head) {
        ListNode node = head;
        int result = 0;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    private void printMy(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private ListNode createNode(int step, List<Integer> integers) {
        if (integers.size() == step) {
            return null;
        }
        return new ListNode(integers.get(step), createNode(step + 1, integers));

    }
}
