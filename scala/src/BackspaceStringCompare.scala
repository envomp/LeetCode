import scala.collection.mutable

object BackspaceStringCompare {
	def backspaceCompare(S: String, T: String): Boolean = {
		val new_S = mutable.Stack[Char]()
		val new_T = mutable.Stack[Char]()

		fill_stack(S, new_S)
		fill_stack(T, new_T)

		return new_S.toString() == new_T.toString()
	}

	private def fill_stack(T: String, new_T: mutable.Stack[Char]) = {
		T.foreach(x =>
			if (!x.equals('#')) {
				new_T.push(x)
			} else {
				try {
					new_T.pop()
				} catch {
					case e: Exception => None
				}
			}
		)
	}

	def main(args: Array[String]): Unit = {
		backspaceCompare("a#c", "b")
	}

}