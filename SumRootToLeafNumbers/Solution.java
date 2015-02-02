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
    public int sumNumbers(TreeNode root) {

        return search(root, 0);
    }

    int search(TreeNode root, int sum) {
        if (root == null)	return 0;

        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        return search(root.left, sum * 10 + root.val) + search(root.right, sum * 10 + root.val);
    }
}
