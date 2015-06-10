/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    TreeNode cur;
    LinkedList<TreeNode> stack;
    boolean isInit = true;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        cur = root;
        if (cur == null)   return;
        while (cur.left != null) {  // find the leftmost node in the tree
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (isInit && cur != null) return true;
        if (cur == null)    return false;   // empty tree
        if (stack.size() == 0 && cur.right == null) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        if (isInit) {
            isInit = false;
            return cur.val;
        }
        
        // find the left-most node in the right subtree
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        else {
            cur = stack.pop();
        }
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */