public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)   return result;

        List<Integer> level = new ArrayList<Integer>();
        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();

        cur.addFirst(root);

        while (!cur.isEmpty()) {
            while (!cur.isEmpty()) {
                TreeNode n = cur.pollLast();
                if (n.left != null)	next.addFirst(n.left);
                if (n.right != null)	next.addFirst(n.right);
                level.add(n.val);
            }
            result.add(new ArrayList<Integer>(level));
            level.clear();

            LinkedList<TreeNode> tmp = cur;
            cur = next;
            next = tmp;
        }
        return result;
    }
}
