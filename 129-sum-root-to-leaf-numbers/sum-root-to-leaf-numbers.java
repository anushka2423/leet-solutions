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
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        solve(root, sum, 0);

        return sum[0];
    }

    private void solve(TreeNode root, int[] sum, int num) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            System.out.println(num+"anushka num");
            sum[0] += num*10+root.val;

            System.out.println(sum[0]+"anushka sum");
            return;
        }

        solve(root.left, sum, num*10+root.val);
        solve(root.right, sum, num*10+root.val);
    }
}