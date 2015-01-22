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
  public ListNode rotateRight(ListNode head, int n) {
    if (head == null) return null;

    ListNode r1 = head;
    ListNode r2 = head;

    int length = 0;
    while (r1 != null) {
      length ++;
      r1 = r1.next;
    }

    r1 = head;
    int _n = n % length;

    for (int i = 0; i < _n; i ++) {
      r1 = r1.next;
    }

    while (r1.next != null) {
      r1 = r1.next;
      r2 = r2.next;
    }

    r1.next = head;

    ListNode headNew = r2.next;
    r2.next = null;

    return headNew;

  }
}
