

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        test1();
    }

    private void test1() {

        ListNode l1 = createNode(0, List.of(1, 1, 10, 100, 2));
        ListNode l2 = createNode(0, List.of(99, 9));
        ListNode node = mergeKLists(new ListNode[]{l1, l2});
        printMy(node);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        final List<ListNode> nodes = new ArrayList<>();
        for (ListNode listNode : lists) {
            ListNode currentNode = listNode;
            while (currentNode != null) {
                nodes.add(currentNode);
                currentNode = currentNode.next;
            }
        }
        final List<ListNode> sortedNodes = nodes.stream()
                .sorted((new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return Integer.valueOf(o1.val).compareTo(Integer.valueOf(o2.val));
                    }
                }))
                .collect(Collectors.toList());
                        if (sortedNodes.size() == 0) {
            return null;
        }
        ListNode result = sortedNodes.get(0);
        ListNode previos = result;
        for (int i = 1; i < sortedNodes.size(); i++) {
            sortedNodes.get(i).next = null;
            previos.next = sortedNodes.get(i);
            previos = previos.next;
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
