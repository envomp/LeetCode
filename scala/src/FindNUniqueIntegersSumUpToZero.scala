object FindNUniqueIntegersSumUpToZero {
	def sumZero(n: Int): Array[Int] = {

		val answer = (0 until n).toArray
		answer(n - 1) = -(((n - 1) * (n - 2)) / 2)

		answer
	}
}
