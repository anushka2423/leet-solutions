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
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        index = postorder.length-1;
        return buildTree(0, inorder.length-1, postorder, inMap);
    }

    private TreeNode buildTree(int left, int right, int[] postorder, Map<Integer, Integer> map) {
        int node = postorder[index];
        index--;
        TreeNode newNode = new TreeNode(node);
        int ind = map.get(node);
        if(ind+1 <= right)
            newNode.right = buildTree(ind+1, right, postorder, map);
        if(left <= ind-1)
            newNode.left = buildTree(left, ind-1, postorder, map);

        return newNode;
    }
}