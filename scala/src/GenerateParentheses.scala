object GenerateParentheses {

	def DFS(max_depth: Int, answer: String, closed: Int, opened: Int): List[String] = {
		if (opened + closed == max_depth) {
			List(answer)
		} else {
			var _answer: List[String] = List()
			if (closed > opened && opened < max_depth / 2) {
				_answer ++= DFS(max_depth, "(" ++ answer, closed, opened + 1)
			}
			if (closed < max_depth / 2) {
				_answer ++= DFS(max_depth, ")" ++ answer, closed + 1, opened)
			}
			_answer
		}
	}

	def generateParenthesis(n: Int): List[String] = {

		DFS(n * 2, "", 0, 0)

	}

	def main(args: Array[String]): Unit = {
		println(generateParenthesis(3).size)
	}
}
