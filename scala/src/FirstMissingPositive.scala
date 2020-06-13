object FirstMissingPositive {
	def firstMissingPositive(nums: Array[Int]): Int = {

		var last = 0
		nums.sortInPlace.foreach(x => {
			if (x > last) {
				if (x - 1 != last) {
					return last + 1
				}
				last = x
			}
		})

		last + 1

	}
}
