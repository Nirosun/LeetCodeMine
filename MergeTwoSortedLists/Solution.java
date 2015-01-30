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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0);
    ListNode dummy = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        l.next = l1;
        l1 = l1.next;
      }
      else {
        l.next = l2;
        l2 = l2.next;
      }
      l = l.next;
    }

    if (l1 != null) l.next = l1;
    else  l.next = l2;

    return dummy.next;
  }

  /*
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(-1);
    dummy.next = l1;
    l1 = dummy;

    while (l1.next != null && l2 != null) {
      ListNode n1 = l1.next;
      ListNode n2 = l2.next;
      if (l1.next.val > l2.val) {
        l1.next = l2;
        l2.next = n1;
        l2 = n2;
      }
      else {
        l1 = n1;
      }
    }

    if (l2 != null) {
      l1.next = l2;
    }

    return dummy.next;
  }*/
}
