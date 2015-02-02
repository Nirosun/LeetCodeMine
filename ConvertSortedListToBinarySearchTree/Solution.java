/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)   return null;
        if (head.next == null)  return new TreeNode(head.val);

        ListNode fast = head, slow = head, prev = null;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow = slow.next;
        ListNode h2 = slow.next;
        slow.next = null;
        //prev.next = null;

        if (prev != null)
            prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBST((prev == null) ? prev : head);
        root.right = sortedListToBST(h2);

        return root;
    }
}
