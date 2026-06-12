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
    public int minDepth(TreeNode root) {
        return solve(root);
    }

    private int solve(TreeNode root) {
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 1;

        int left = solve(root.left);
        int right = solve(root.right);
        if(root.right == null) {
            return 1+left;
        }
        if(root.left == null) {
            return 1+right;
        }

        return 1+Math.min(left, right);
    }
}