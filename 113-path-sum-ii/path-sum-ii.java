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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, targetSum, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void solve(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> list, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(sum+root.val == targetSum){
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }

            return;
        }

        list.add(root.val);
        solve(root.left, targetSum, ans, list, sum+root.val);
        solve(root.right, targetSum, ans, list, sum+root.val);
        list.remove(list.size()-1);
    }
}