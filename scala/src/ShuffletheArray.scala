object ShuffletheArray {
	def shuffle(nums: Array[Int], n: Int): Array[Int] = {

		val left = nums.slice(0, n)
		val right = nums.slice(n, nums.length)

		for (i <- left.indices) {
			nums(2 * i) = left(i)
			nums(2 * i + 1) = right(i)
		}

		nums
	}
}
