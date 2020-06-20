object AddToArrayFormOfInteger {
	def addToArrayForm(A: Array[Int], K: Int): List[Int] = {

		var k = K
		var pointer = A.length - 1
		var answer: List[Int] = List()

		var to_add_parent = 0
		var to_add = 0


		while (k != 0 || pointer >= 0) {

			to_add = k % 10

			var from_arr = 0
			if (pointer >= 0) {
				from_arr = A(pointer)
			}
			var total = to_add + from_arr + to_add_parent

			k = k / 10
			to_add_parent = 0
			pointer -= 1

			to_add_parent = total / 10
			total = total % 10

			answer ::= total

		}

		if (to_add_parent != 0) {
			answer ::= to_add_parent
		}

		answer

	}

	def main(args: Array[String]): Unit = {
		println(addToArrayForm(Array(1, 1, 1, 9), 11134))
	}
}
