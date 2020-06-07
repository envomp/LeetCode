object MaximumSubarraySumWithOneDeletion {
	def maximumSum(arr: Array[Int]): Int = {
		var maxSumWith = arr(0) // max subarray sum with the current element.
		var maxSumWithout = arr(0) // max subarray sum with or without current element.
		var maxSum = arr(0) // max subarray sum so far.
		for (i <- 1 until arr.length) {
			val n = arr(i)
			maxSumWithout = Math.max(maxSumWith, maxSumWithout + n)
			maxSumWith = Math.max(maxSumWith + n, n)
			maxSum = Math.max(maxSum, Math.max(maxSumWith, maxSumWithout))
		}
		maxSum
	}

	def main(args: Array[String]): Unit = {
		println(maximumSum(Array(2, 1, -2, -5, -2)))
		println(maximumSum(Array(1, -2, -2, 3)))
		println(maximumSum(Array(1, -2, 0, 3)))
		println(maximumSum(Array(-1, -1, -1, -1)))
	}
}
