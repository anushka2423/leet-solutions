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
    public int pathSum(TreeNode root, int targetSum) {
        int[] ans = new int[1];
        solve(root, targetSum, 0, ans, true);

        return ans[0];
    }

    private void solve(TreeNode root, int targetSum, long sum, int[] ans, boolean flag) {
        if(root == null) return;
        if(sum+root.val == targetSum) {
            ans[0]++;
        }

        solve(root.left, targetSum, sum+root.val, ans, false);
        solve(root.right, targetSum, sum+root.val, ans, false);

        if(flag) {
            solve(root.left, targetSum, 0, ans, true);
            solve(root.right, targetSum, 0, ans, true);
        }
    }
}