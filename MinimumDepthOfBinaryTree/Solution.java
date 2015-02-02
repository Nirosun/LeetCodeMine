public class Solution {
    public int minDepth(TreeNode root) {
        return minDepth(root, false);
    }

    private int minDepth(TreeNode root, boolean hasBrother) {
        if (root == null)
            return hasBrother ? Integer.MAX_VALUE : 0;
        int l = minDepth(root.left, root.right != null);
        int r = minDepth(root.right, root.left != null);

        return 1 + ((l < r) ? l : r);
    }
}
