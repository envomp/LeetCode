object MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
	def maxSideLength(mat: Array[Array[Int]], threshold: Int): Int = {

		var res = 0
		var l = 0

		val row = mat.length
		val col = mat(0).length

		val dp: Array[Array[Int]] = Array.fill(row + 1)(Array.fill(col + 1)(0))

		(1 to row).foreach(i => {
			(1 to col).foreach(j => {
				dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1) - dp(i - 1)(j - 1) + mat(i - 1)(j - 1)
			})
		})

		(0 to row).foreach(i => {
			(0 to col).foreach(j => {
				while (i + l <= row && j + l <= col && dp(i + l)(j + l) - dp(i + l)(j) - dp(i)(j + l) + dp(i)(j) <= threshold) {
					res = l
					l += 1
				}
			})
		})

		res
	}

	def main(args: Array[String]): Unit = {
		maxSideLength(Array(Array(2, 2, 2, 2, 2), Array(2, 2, 2, 2, 2), Array(2, 2, 2, 2, 2), Array(2, 2, 2, 2, 2), Array(2, 2, 2, 2, 2)), 1)
	}

}
