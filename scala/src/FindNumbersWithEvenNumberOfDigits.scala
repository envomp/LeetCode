object FindNumbersWithEvenNumberOfDigits {

	def findNumbers(nums: Array[Int]): Int = {
		nums.map(x => x.toString).count(x => x.length % 2 == 0)
	}

}
