package a92_反转链表2.b站视频题解;

// O(n) O(1)
public class Solution {
    public class ReverseLinkedListII {

        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            for (int i = 1; i < m; i++) {
                cur = cur.next;
                pre = pre.next;
            }

            for (int i = 0; i < n - m; i++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            return dummy.next;
        }
    }
}
