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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return solve(root);
    }
    private int solve(TreeNode root) {
        if (root == null) return -1;

        int left = solve(root.left);
        if(left != -1) return left;
        
        k--;
        if (k == 0) return root.val;

        return solve(root.right);
    }
}