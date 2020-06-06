import java.util

import scala.collection.mutable

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */

object RecoverATreeFromPreorderTraversal {

	def generateBSTfromQueue(root: TreeNode, queue: mutable.Queue[String]): TreeNode = {
		if (queue.isEmpty) {
			return root
		}

		var step = queue.dequeue()

		var node = root

		while (step.equals("-")) {
			step = queue.dequeue()

			if (step.equals("-")) {
				if (node.right != null) {
					node = node.right
				} else {
					node = node.left
				}
			} else {
				if (node.left == null) {
					node.left = new TreeNode(_value = Integer.valueOf(step))
				} else {
					node.right = new TreeNode(_value = Integer.valueOf(step))
				}
			}
		}

		generateBSTfromQueue(root, queue)

	}

	def recoverFromPreorder(S: String): TreeNode = {

		if (S.isEmpty) {
			return null
		}

		val input: util.ArrayList[String] = new util.ArrayList()

		var last = "-"

		S.split("").foreach {
			case "-" =>
				last = "-"
				input.add("-")

			case x =>
				if (last.equals("-")) {
					input.add(x)
				} else {
					input.add(input.remove(input.size() - 1) + x)
				}
				last = x
		}

		val queue: mutable.Queue[String] = new mutable.Queue()
		input.forEach(x => queue.addOne(x))

		val head = queue.dequeue()

		generateBSTfromQueue(new TreeNode(_value = Integer.valueOf(head)), queue)

	}

	def main(args: Array[String]): Unit = {
		println(recoverFromPreorder("1-401--349---90--88"))
	}
}
