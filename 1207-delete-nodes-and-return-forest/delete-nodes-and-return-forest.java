/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delete_node = new HashSet<>();
        for(int node : to_delete) {
            delete_node.add(node);
        }

        List<TreeNode> ans = new ArrayList<>();
        if(root == null) return ans;

        if(!delete_node.contains(root.val))
            ans.add(root);

        solve(root, delete_node, ans, null);

        return ans;
    }

    private void solve(TreeNode root, Set<Integer> delete_node, List<TreeNode> ans, TreeNode parent) {
        if(root == null) return;

        if(delete_node.contains(root.val)) {

            if(parent != null) {
                if(parent.left == root)
                    parent.left = null;
                else 
                    parent.right = null;
            }

            if(root.left != null && !delete_node.contains(root.left.val))
                ans.add(root.left);
            if(root.right != null && !delete_node.contains(root.right.val))
                ans.add(root.right);
        }

        solve(root.left, delete_node, ans, root);
        solve(root.right, delete_node, ans, root);
    }
}