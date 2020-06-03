import scala.collection.mutable

object ReverseOnlyLetters {
	def reverseOnlyLetters(S: String): String = {
		val chars = S.toCharArray
		val stack: mutable.Stack[Char] = mutable.Stack()

		chars.foreach(ch => if (ch.isLetter) {
			stack.addOne(ch)
		})

		chars.indices.foreach(i => if (chars(i).isLetter) {
			chars(i) = stack.removeLast()
		})

		String.valueOf(chars)
	}

	def main(args: Array[String]): Unit = {
		reverseOnlyLetters("ab-cd")
	}
}
