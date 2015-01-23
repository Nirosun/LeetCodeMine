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
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    ListNode mid = findMiddleNode(head);
    ListNode right = mid.next;

    if (right == null) return;
    mid.next = null;

    right = reverseList(right);

    ListNode t1 = null;
    ListNode t2 = null;

    while (head != null) {
      t1 = head.next;

      if (right == null) return;

      t2 = right.next;

      right.next = head.next;
      head.next = right;

      head = t1;
      right = t2;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;

      prev = head;
      head = next;
    }

    return prev;
  }

  public ListNode findMiddleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
