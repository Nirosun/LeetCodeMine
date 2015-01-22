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

    final ListNode _head = head;
    ListNode l = head;
    //ListNode prev = head;

    while (head != null) {
      if (head.val != l.val) {
        l.next = head;
        l = head;
      }
      head = head.next;
    }

    l.next = null;

    return _head;
  }
}
