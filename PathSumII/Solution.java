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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)    return result;

        List<Integer> cur = new ArrayList<Integer>();
        search(root, sum, cur, result);

        return result;
    }


    void search(TreeNode root, int gap, List<Integer> cur, List<List<Integer>> result) {
        if (root == null)    return;

        cur.add(root.val);

        if (root.left == null && root.right == null) {
            if (gap == root.val) {
                result.add(new ArrayList<Integer>(cur));
            }
        }

        search(root.left, gap - root.val, cur, result);
        search(root.right, gap - root.val, cur, result);

        cur.remove(cur.size() - 1);
    }

}
