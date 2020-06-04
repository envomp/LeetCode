object SplitAStringInBalancedStrings {
	def balancedStringSplit(s: String): Int = {

		val (answer: Int, _) = s.toCharArray.fold((0, 0))((last, b) => {
			val (left: Int, cur: Int) = last
			b match {
				case 'R' => cur + 1 match {
					case 0 => (left + 1, 0)
					case x => (left, x)
				}
				case 'L' => cur - 1 match {
					case 0 => (left + 1, 0)
					case x => (left, x)
				}
			}
		})
		answer
	}

	def main(args: Array[String]): Unit = {
		println(balancedStringSplit("RLRRLLRL"))
	}
}
