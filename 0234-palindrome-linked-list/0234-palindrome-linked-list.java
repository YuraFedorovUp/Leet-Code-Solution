import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        //test0();
        //test1();
        test2();
    }

    private void test0() {
        final ListNode nodes = createNode(0, List.of(1, 2, 2, 1));
        final var result = isPalindrome(nodes);

        System.out.println("expected - true");
        System.out.println("actual - " + result);
        System.out.println("/////////////////////");
    }

    private void test1() {
        final ListNode nodes = createNode(0, List.of(1, 2));
        final var result = isPalindrome(nodes);

        System.out.println("expected - false");
        System.out.println("actual - " + result);
        System.out.println("/////////////////////");
    }

    private void test2() {
        final ListNode nodes = createNode(0, List.of(1, 0, 0));
        final var result = isPalindrome(nodes);

        System.out.println("expected - false");
        System.out.println("actual - " + result);
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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        final var values = new ArrayList<Integer>();
        var node = head;
        while (node != null) {
            values.add(node.val);
            node = node.next;

        }
        return isPalindrome(values);
    }

    private boolean isPalindrome(ArrayList<Integer> values) {
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            if (values.get(left++) != values.get(right--)) {
                return false;
            }
        }
        return true;
    }
}