object BinarySearch {
	def search(nums: Array[Int], target: Int): Int = {
		var pivot = 0
		var left = 0
		var right = nums.length - 1

		while (left <= right) {
			pivot = left + (right - left) / 2

			if (nums(pivot).equals(target)) {
				return pivot
			} else if (target < nums(pivot)) {
				right = pivot - 1
			} else {
				left = pivot + 1
			}
		}

		-1
	}
}
