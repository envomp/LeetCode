
object CombinationSumIV {

	def combinationSum4(nums: Array[Int], target: Int): Int = {
		val dp = new Array[Int](target + 1)
		dp(0) = 1

		for (i <- 1 until target + 1) {
			for (j <- nums.indices) {
				if (i - nums(j) >= 0) {
					dp(i) += dp(i - nums(j))
				}
			}
		}

		dp(target)
	}

	def main(args: Array[String]): Unit = {
		println(combinationSum4(Array(2, 1, 3), 35))
	}
}
