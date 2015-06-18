/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            while (curr != null && curr.val == val) {
                curr = curr.next;
            }
            prev.next = curr;
            if (curr != null) {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}