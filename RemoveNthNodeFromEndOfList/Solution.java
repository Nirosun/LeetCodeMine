/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode r1 = dummy;
    ListNode r2 = dummy;

    for (int i = 0; i < n; i ++) {
      r1 = r1.next;
    }

    while (r1.next != null) {
      r1 = r1.next;
      r2 = r2.next;
    }

    r2.next = r2.next.next;
    return dummy.next;
  }
}
