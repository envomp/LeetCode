object RemoveDuplicatesFromSortedArray {
	def removeDuplicates(nums: Array[Int]): Int = {

		if (nums.length < 2) {
			return nums.length
		}

		var pointer = 1

		(1 until nums.length).foreach(x => {

			if (!nums(x).equals(nums(x - 1))) {
				nums(pointer) = nums(x)
				pointer += 1
			}

		})

		pointer
	}
}
