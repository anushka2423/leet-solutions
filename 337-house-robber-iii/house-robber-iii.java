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
    public int rob(TreeNode root) {
        if(root == null) return 0;

        Map<TreeNode, Integer> map = new HashMap<>();

        return solve(root, map);
    }

    private int solve(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int case11 = 0, case12 = 0;
        if(root.right != null)
            case11 = solve(root.right.right, map) + solve(root.right.left, map);
        if(root.left != null)
            case12 = solve(root.left.right, map) + solve(root.left.left, map);

        int case1 = root.val + case11 + case12;
        int case2 = solve(root.right, map)+solve(root.left, map);

        int ans = Math.max(case1, case2);
        map.put(root, ans);

        return ans;
    }
}