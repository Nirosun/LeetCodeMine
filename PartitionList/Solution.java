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
  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    if (head.next == null) return head;

    final ListNode h_small = new ListNode(0);
    final ListNode h_great = new ListNode(0);

    ListNode p_small = h_small;
    ListNode p_great = h_great;

    final ListNode _head = head;

    while (head != null) {
      //ListNode t = head;
      //head = head.next;

      if (head.val < x) {
        p_small.next = head;
        p_small = p_small.next;
      }
      else {
        p_great.next = head;
        p_great = p_great.next;
      }

      head = head.next;
    }

    p_great.next = null;

    p_small.next = h_great.next;
    return h_small.next;

  }
}
