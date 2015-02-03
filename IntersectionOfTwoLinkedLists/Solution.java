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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != null && pB != null) {
            pA = pA.next;
            pB = pB.next;
        }

        int diff = 0;
        ListNode pLong, pShort, r;
        r = (pA == null) ? pB : pA;
        pLong = (pA == null) ? headB : headA;
        pShort = (pA == null) ? headA : headB;

        while (r != null) {
            r = r.next;
            diff ++;
        }

        for (int i = 0; i < diff; i ++) {
            pLong = pLong.next;
        }

        while (pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }

        return pLong;
    }
}
