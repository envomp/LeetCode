/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */

object IncreasingOrderSearchTree {

	def increasingBST(root: TreeNode): TreeNode = {
		val answer = new TreeNode(_value = Int.MinValue)
		inorder(root).foldLeft[TreeNode](answer)((last, step) => {
			last.value match {
				case Int.MinValue =>
					last.value = step
					last
				case _ =>
					val node = new TreeNode(_value = step)
					last.right = node
					node
			}
		})
		answer
	}

	def inorder(root: TreeNode): List[Int] = {
		if (root != null) {
			inorder(root.left) ++ List(root.value) ++ inorder(root.right)
		} else {
			List()
		}
	}

}
