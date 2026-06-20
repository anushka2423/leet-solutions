/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> inorder = new ArrayList<>();
        List<TreeNode> preorder = new ArrayList<>();

        solveInorder(inorder, root);
        solvePreorder(preorder, root);

        Map<TreeNode, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }

        int pind = map.get(p);
        int qind = map.get(q);

        for(int i = 0; i < preorder.size(); i++) {
            int index = map.get(preorder.get(i));
            if((pind <= index && qind >= index) || (pind >= index && qind <= index)) return preorder.get(i);
        }

        return null;
    }

    private void solveInorder(List<TreeNode> inorder, TreeNode root) {
        if(root == null) return;

        solveInorder(inorder, root.left);
        inorder.add(root);
        solveInorder(inorder, root.right);
    }

    private void solvePreorder(List<TreeNode> preorder, TreeNode root) {
        if(root == null) return;

        preorder.add(root);
        solvePreorder(preorder, root.left);
        solvePreorder(preorder, root.right);
    }
}