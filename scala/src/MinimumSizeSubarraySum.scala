object MinimumSizeSubarraySum {
	def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
		var sum = 0
		var left = 0
		var right = 0

		var answer = Int.MaxValue

		while (right + 1 <= nums.length) {
			sum += nums(right)

			while (sum >= s) {
				answer = math.min(answer, right - left + 1)
				sum -= nums(left)
				left += 1
			}
			right += 1
		}

		if (answer == Int.MaxValue) {
			0
		} else {
			answer
		}
	}

	def main(args: Array[String]): Unit = {
		println(minSubArrayLen(7, Array(2, 3, 1, 2, 4, 3)))
	}
}
