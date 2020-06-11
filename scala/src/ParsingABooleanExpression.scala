object ParsingABooleanExpression {
	def parseBoolExpr(expression: String): Boolean = {
		if (expression.length <= 1) {
			expression.startsWith("t")
		} else {

			expression.substring(0, 1) match {
				case "!" => !parseBoolExpr(expression.substring(2, expression.length - 1))
				case "|" =>
					var base = false
					val sub_expression = expression.substring(2, expression.length - 1)
					if (sub_expression.contains("(")) {
						splitToSubstrings(sub_expression).foreach(x => {
							base |= parseBoolExpr(x)
						})
					} else {
						sub_expression.split(",").foreach(x => {
							base |= parseBoolExpr(x)
						})
					}
					base

				case "&" =>
					var base = true
					val sub_expression = expression.substring(2, expression.length - 1)
					if (sub_expression.contains("(")) {
						splitToSubstrings(sub_expression).foreach(x => {
							base &= parseBoolExpr(x)
						})
					} else {
						sub_expression.split(",").foreach(x => {
							base &= parseBoolExpr(x)
						})
					}
					base
				case x =>
					println(x)
					false
			}

		}
	}

	def splitToSubstrings(expression: String): List[String] = {
		var subs: List[String] = List()
		var stack_size = 0
		var start = 0

		for (end <- 0 until expression.length) {
			if (expression.charAt(end).equals(',') && stack_size == 0) {
				subs ::= expression.substring(start, end)
				start = end + 1
			} else if (expression.charAt(end).equals('(')) {
				stack_size += 1
			} else if (expression.charAt(end).equals(')')) {
				stack_size -= 1
			}
		}
		subs ::= expression.substring(start, expression.length)
		subs
	}

	def main(args: Array[String]): Unit = {
		println(parseBoolExpr("|(f,&(t,t))"))
//		println(parseBoolExpr("!(&(!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))))"))
		//		println(parseBoolExpr("|(&(t,f,t),!(t))"))
		//		println(parseBoolExpr("|(f,t)"))
	}
}
