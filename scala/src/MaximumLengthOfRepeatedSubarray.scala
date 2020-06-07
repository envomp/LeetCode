object MaximumLengthOfRepeatedSubarray {
	def findLength(A: Array[Int], B: Array[Int]): Int = {

		val dp = Array.fill(A.length + 1)(Array.fill(B.length + 1)(0))

		for (i <- A.length - 1 until -1 by -1) {
			for (j <- B.length - 1 until -1 by -1) {
				if (A(i) == B(j)) {
					dp(i)(j) = dp(i + 1)(j + 1) + 1
				}
			}
		}
		dp.map(x => x.max).max
	}

	def main(args: Array[String]): Unit = {
		findLength(Array(1, 2, 3, 2, 1), Array(3, 2, 1, 4, 7))
	}
}
