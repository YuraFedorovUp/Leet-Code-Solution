

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

    public ListNode swapPairs(ListNode head) {
        ListNode result = null;
        ListNode oldFirst = head;
        while (true) {
            if (oldFirst == null) {
                break;
            }
            ListNode oldSecond = oldFirst.next;
            if (oldSecond == null) {
                if (result == null) {
                    return head;
                }
                break;
            }
            ListNode oldThird = oldSecond.next;
            oldSecond.next = oldFirst;
            if (result == null) {
                result = oldSecond;
            }
            if (oldThird != null && oldThird.next != null) {

                oldFirst.next = oldThird.next;
            } else {
                oldFirst.next = oldThird;
            }
            oldFirst = oldThird;
        }
        return result;
    }    
}
