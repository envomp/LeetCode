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

    private int k = -1;

    public int kthSmallest(TreeNode root, int k) {

        this.k = k;
        return this.traverse(root);

    }


    private int traverse(TreeNode root) {
        if (root.left != null) {
            int a = traverse(root.left);
            if (a != -1) {
                return a;
            }
        }

        this.k = this.k - 1;
        if (this.k == 0) {
            return root.val;
        }

        if (root.right != null) {
            int a = traverse(root.right);
            if (a != -1) {
                return a;
            }
        }

        return -1;
    }
}