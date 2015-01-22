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
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(head.val-1);

    dummy.next = head;
    head = dummy;

    ListNode l = dummy;
    ListNode prevNonDup = l;
    boolean isDup = false;

    while (head != null) {
      if (head.val != l.val) {
        if (isDup) {
          continue;
        }
        else {
          prevNonDup = l;
        }
        l = head;
        isDup = false;
      }
      else {
        if (head != dummy)
          isDup = true;
      }

      head = head.next;
    }

    if (isDup) {
      prevNonDup.next = null;
    }

    return dummy.next;
  }
}
