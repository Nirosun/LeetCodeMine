/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) return;

    final TreeLinkNode dummy = new TreeLinkNode(-1);

    // n points to the nodes in the next level
    for (TreeLinkNode cur = root, n = dummy; cur != null; cur = cur.next) {
      if (cur.left != null) {
        n.next = cur.left;
        n = n.next;
      }
      if (cur.right != null) {
        n.next = cur.right;
        n = n.next;
      }
    }

    connect(dummy.next);
  }


}
