object FindTheDuplicateNumber {

	def findDuplicate(nums: Array[Int]): Int = {

		// Find the intersection point of the two runners.
		var tortoise = nums(0)
		var hare = nums(0)

		do {
			tortoise = nums(tortoise)
			hare = nums(nums(hare))
		} while (tortoise != hare)

		// Find the "entrance" to the cycle.
		tortoise = nums(0)
		while (tortoise != hare) {
			tortoise = nums(tortoise)
			hare = nums(hare)
		}

		hare
	}
}
