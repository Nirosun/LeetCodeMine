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
    if (root == null || root.left == null) return;

    final TreeLinkNode dummy = new TreeLinkNode(-1);

    for (TreeLinkNode cur = root, n = dummy; cur != null; cur = cur.next) {
      n.next = cur.left;
      n = n.next;
      n.next = cur.right;
      n= n.next;
    }

    connect(dummy.next);
  }

  
}
