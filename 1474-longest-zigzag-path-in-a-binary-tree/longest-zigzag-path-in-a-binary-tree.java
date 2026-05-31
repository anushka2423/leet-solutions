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
    public int longestZigZag(TreeNode root) {
        int[] ans = new int[1];
        solve(root.left, 1, 1, ans);
        solve(root.right, 2, 1, ans);
        return ans[0]-1;
    }

    private void solve(TreeNode root, int nodeType, int len, int[] ans) {
        if(root == null) { 
            ans[0] = Math.max(ans[0], len);
            return;
        }

        if(nodeType == 1) {
            solve(root.right, 2, len+1, ans);
            solve(root.left, 1, 1, ans); 
        }
        if(nodeType == 2) {
           solve(root.left, 1, len+1, ans);
           solve(root.right, 2, 1, ans);
        }
    }
}