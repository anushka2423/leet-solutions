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
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        solve(root, list);

        root.left = null;
        root.right = null;

        TreeNode temp = root;
        for(int i = 1; i < list.size(); i++) {
            TreeNode newNode = new TreeNode(list.get(i));
            temp.right = newNode;

            temp = temp.right;
        }
    }

    private void solve(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        solve(root.left, list);
        solve(root.right, list);
    }
}