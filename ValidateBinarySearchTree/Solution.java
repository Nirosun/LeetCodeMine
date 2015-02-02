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


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null)   return true;

        return (lower < root.val && root.val < upper &&
                isValidBST(root.left, lower, root.val) &&
                isValidBST(root.right, root.val, upper));
    }

    // inorder method, BST must follow a ascending way

    /*private boolean failed;
    private long last;

    void inorder(TreeNode root) {
        if (root == null) return;
        if (failed) return;

        inorder(root.left);

        if (last >= root.val)   failed = true;
        last = root.val;

        inorder(root.right);

    }

    public boolean isValidBST(TreeNode root) {

        last = Long.MIN_VALUE;
        failed = false;
        inorder(root);
        return !failed;
    }*/
}
