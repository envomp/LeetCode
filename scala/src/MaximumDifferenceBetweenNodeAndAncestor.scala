/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

object Solution {

	def DFS(root: TreeNode, minimum: Int, maximum: Int): Int = {
		if (root == null) {
			maximum - minimum
		} else {
			math.max(
				DFS(root.left, math.min(minimum, root.value), math.max(maximum, root.value)),
				DFS(root.right, math.min(minimum, root.value), math.max(maximum, root.value))
			)
		}
	}

	def maxAncestorDiff(root: TreeNode): Int = {

		DFS(root, root.value, root.value)

	}

}