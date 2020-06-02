package java;

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

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        this.traverse(root);
        return sorted;

    }

     private void traverse(TreeNode root) {

        if (root.left != null) {
            this.traverse(root.left);
        }


        if (root.right != null) {
            this.traverse(root.right);
        }

        this.sorted.add(root.val);

    }

}
