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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        solveinorder(inorder, root);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 1; i < inorder.size(); i++) {
            minDiff = Math.min(minDiff, inorder.get(i)-inorder.get(i-1));
        }

        return minDiff;
    }

    private void solveinorder(List<Integer> inorder, TreeNode root) {
        if(root == null) return;

        solveinorder(inorder, root.left);
        inorder.add(root.val);
        solveinorder(inorder, root.right);
    }
}