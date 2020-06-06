
abstract class EquationTreeNode {

	def evaluate: Long

	def stringify: String

	def isLeaf: Boolean

	def insertMultiplication(node: EquationTreeNode): EquationTreeNode

	def updateRight(shift: Long): EquationTreeNode
}

class Number(_value: Long) extends EquationTreeNode {

	private var value = _value

	override def evaluate: Long = value

	override def stringify: String = value.toString

	override def isLeaf: Boolean = true

	override def insertMultiplication(node: EquationTreeNode): EquationTreeNode = new Multiply(this, node)

	override def updateRight(shift: Long): EquationTreeNode = {
		value = value * 10 + shift
		this
	}
}

abstract class EquationTreeOperator(left: EquationTreeNode, right: EquationTreeNode) extends EquationTreeNode {

	def reInvoke(left: EquationTreeNode, right: EquationTreeNode): EquationTreeNode

	override def isLeaf: Boolean = false

	override def insertMultiplication(node: EquationTreeNode): EquationTreeNode = {

		if (right.isLeaf) {
			reInvoke(left, new Multiply(right, node))
		} else {
			reInvoke(left, right.insertMultiplication(node))
		}
	}

	override def updateRight(shift: Long): EquationTreeNode = {
		right.updateRight(shift)
		this
	}
}

class Add(left: EquationTreeNode, right: EquationTreeNode) extends EquationTreeOperator(left: EquationTreeNode, right: EquationTreeNode) {

	override def evaluate: Long = left.evaluate + right.evaluate

	override def stringify: String = left.stringify + "+" + right.stringify

	override def reInvoke(left: EquationTreeNode, right: EquationTreeNode): EquationTreeNode = new Add(left, right)
}

class Subtract(left: EquationTreeNode, right: EquationTreeNode) extends EquationTreeOperator(left: EquationTreeNode, right: EquationTreeNode) {

	override def evaluate: Long = left.evaluate - right.evaluate

	override def stringify: String = left.stringify + "-" + right.stringify

	override def reInvoke(left: EquationTreeNode, right: EquationTreeNode): EquationTreeNode = new Subtract(left, right)
}

class Multiply(left: EquationTreeNode, right: EquationTreeNode) extends EquationTreeOperator(left: EquationTreeNode, right: EquationTreeNode) {

	override def evaluate: Long = left.evaluate * right.evaluate

	override def stringify: String = left.stringify + "*" + right.stringify

	override def reInvoke(left: EquationTreeNode, right: EquationTreeNode): EquationTreeNode = new Multiply(left, right)
}


object ExpressionAddOperators {

	def addOperators(num: String, target: Int): List[String] = {

		if (num.isEmpty) {
			return List()
		}

		val nums = num.split("").map(x => Integer.valueOf(x).longValue())
		DFS(nums, 1, new Number(nums(0).longValue()), target, nums(0) == 0)

	}

	def DFS(can_be_used: Array[Long], pointer: Int, current_answer: EquationTreeNode, target: Int, leading_zero: Boolean): List[String] = {

		if (pointer == can_be_used.length) {
			if (current_answer.evaluate.equals(target.toLong)) {
				List(current_answer.stringify)
			} else {
				List()
			}
		} else {
			val new_leading_zero = can_be_used(pointer) == 0
			var answer: List[String] = List()

			answer ++= DFS(can_be_used, pointer + 1, current_answer.insertMultiplication(new Number(can_be_used(pointer).longValue())), target, new_leading_zero)
			answer ++= DFS(can_be_used, pointer + 1, new Add(current_answer, new Number(can_be_used(pointer).longValue())), target, new_leading_zero)
			answer ++= DFS(can_be_used, pointer + 1, new Subtract(current_answer, new Number(can_be_used(pointer).longValue())), target, new_leading_zero)

			if (!leading_zero) {
				answer ++= DFS(can_be_used, pointer + 1, current_answer.updateRight(can_be_used(pointer)), target, leading_zero)
			}

			answer
		}
	}

	def main(args: Array[String]): Unit = {
		println(addOperators("2147483648", -2147483648))
	}
}
