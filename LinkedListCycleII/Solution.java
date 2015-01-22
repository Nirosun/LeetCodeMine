/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode fast = head;
    ListNode slow1 = head;

    while (fast != null && fast.next != null) {
      slow1 = slow1.next;
      fast = fast.next.next;
      if (fast == slow1) break;
    }

    if (fast == null || fast.next == null) return null;

    ListNode slow2 = head;

    while (slow1 != slow2) {
      slow1 = slow1.next;
      slow2 = slow2.next;
    }

    return slow1;
  }
}
