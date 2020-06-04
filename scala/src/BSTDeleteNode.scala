/**
 * Definition for a binary tree node.
 */

object BSTDeleteNode {

	class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
		var value: Int = _value
		var left: TreeNode = _left
		var right: TreeNode = _right
	}

	def deleteNode(root: TreeNode, key: Int): TreeNode = {
		if (root == null) {
		} else if (root.value < key) {
			root.right = deleteNode(root.right, key)
		} else if (root.value > key) {
			root.left = deleteNode(root.left, key)
		} else {
			if (root.left == null) {
				return root.right
			} else if (root.right == null) {
				return root.left
			} else {
				root.value = getMin(root.right)
				root.right = deleteNode(root.right, root.value)
			}
		}
		root
	}

	private def getMin(_root: TreeNode) = {
		var root = _root
		while (root.left != null) {
			root = root.left
		}
		root.value
	}
}
