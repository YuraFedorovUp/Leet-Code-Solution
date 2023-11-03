

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// public class ListNode {
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
        test1();
    }

    private void test1() {

        ListNode l1 = createNode(0, List.of(9, 9, 9, 9, 9, 9, 9));
        ListNode l2 = createNode(0, List.of(9, 9, 9, 9));
        ListNode node = addTwoNumbers(l1, l2);
        printMy(node);
    }

    private void printMy(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger firstNumber = new BigInteger(getStringNumber(l1));
        BigInteger secondNumber = new BigInteger(getStringNumber(l2));
        String result = String.valueOf(firstNumber.add(secondNumber));
        char[] results = result.toCharArray();
        StringBuilder sb = new StringBuilder(result).reverse();
        result = sb.toString();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            ans.add(Integer.valueOf("" + ch));
        }

        return createNode(0, ans);
    }

    private String getStringNumber(ListNode node) {
        String val = String.valueOf(node.val);
        return node.next == null ? val : getStringNumber(node.next) + node.val;
    }

    private ListNode createNode(int step, List<Integer> integers) {
        if (integers.size() == step) {
            return null;
        }
        return new ListNode(integers.get(step), createNode(step + 1, integers));

    }
}
