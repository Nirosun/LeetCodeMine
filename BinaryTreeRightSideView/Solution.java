/**
 * Solution 1: Recursion
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        
        if (root == null)   return results;
        
        results.add(root.val);
        
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        
        results.addAll(right);
        
        if (left.size() > right.size()) {
            results.addAll(left.subList(right.size(), left.size()));
        }
        
        return results;
        
    }
}

/**
 * Solution 2: Level order traversal
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();

        if (root == null)   return results;
        
        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        
        curr.add(root);
        
        while (!curr.isEmpty()) {
            TreeNode n = null;
            while (!curr.isEmpty()) {
                n = curr.poll();
                if (n.left != null) next.add(n.left);
                if (n.right != null)    next.add(n.right);
            }
            results.add(n.val); // add the rightmost node in this level to results
            
            LinkedList<TreeNode> tmp = next;
            next = curr;
            curr = tmp;
        }
        
        return results;
    }
}