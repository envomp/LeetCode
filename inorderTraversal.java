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

    List<Integer> sorted = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        this.traverse(TreeNode root);
        return sorted;
    }

    private void traverse(TreeNode root) {
        if (root.left != null) {
            this.traverse(root.left);
        }

        this.sorted.append(root.val);

        if (root.right != null) {
            this.traverse(root.right);
        }

    }
}
