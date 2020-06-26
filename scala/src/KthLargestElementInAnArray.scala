object KthLargestElementInAnArray {
	def findKthLargest(nums: Array[Int], k: Int): Int = {

		val a = nums.sorted
		a(nums.length - k)

	}
}
