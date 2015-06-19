/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * Iterative
     */
    // public ListNode reverseList(ListNode head) {

    //     ListNode prev = null;
    //     ListNode curr = head;
    //     ListNode next;
        
    //     while (curr != null) {
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
        
    //     return prev;
    // }
    
    /**
     * Recursive
     */
     public ListNode reverseList(ListNode head) {
         if (head == null) return head;
         
         return reverseListHelper(head, null);
     }
     
     private ListNode reverseListHelper(ListNode curr, ListNode prev) {
         ListNode next = curr.next;
         curr.next = prev;
         
         if (next == null)  return curr;
         
         return reverseListHelper(next, curr);
     }
}