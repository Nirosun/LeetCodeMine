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
    public ListNode insertionSortList(ListNode head) {
        final ListNode dummy = new ListNode(Integer.MIN_VALUE);
        //dummy.next = head;    // dummy.next should be null, construct a new list

        ListNode cur = head;

        while (cur != null) {
            ListNode prev = getInsertPrevNode(dummy, cur.val);
            ListNode n = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = n;
        }

        return dummy.next;
    }

    private ListNode getInsertPrevNode(ListNode head, int x) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null && cur.val <= x) {
            pre = cur;
            cur = cur.next;
        }

        return pre;
    }
}
