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
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode r1 = head;
    ListNode r2 = head;
    //boolean isEven = true;

    while (r2 != null && r2.next != null) {
      r1 = r1.next;
      r2 = r2.next.next;
      if (r1 == r2) return true;
    }

    return false;
  }
}
