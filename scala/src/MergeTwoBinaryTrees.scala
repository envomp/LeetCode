/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */

object MergeTwoBinaryTrees {
	def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {

		if (t1 == null) {
			t2
		} else if (t2 == null) {
			t1
		} else {
			t1.value += t2.value
			t1.left = mergeTrees(t1.left, t2.left)
			t1.right = mergeTrees(t1.right, t2.right)
			t1
		}
	}
}
