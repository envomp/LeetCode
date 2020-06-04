object MaximumProductOfTwoElementsInAnArray {
	def maxProduct(nums: Array[Int]): Int = {
		var maximum1 = 0
		var maximum2 = 0

		for (i <- nums) {
			if (i > maximum2) {
				if (i > maximum1) {
					maximum2 = maximum1
					maximum1 = i
				} else {
					maximum2 = i
				}
			}
		}

		(maximum1 - 1) * (maximum2 - 1)
	}

	def main(args: Array[String]): Unit = {
		println(maxProduct(Array(3, 4, 5, 2)))
	}
}
