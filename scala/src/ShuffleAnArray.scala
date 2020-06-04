/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */

class ShuffleAnArray(_nums: Array[Int]) {

	val nums = _nums.clone();

	/** Resets the array to its original configuration and return it. */
	def reset(): Array[Int] = {
		nums
	}

	/** Returns a random shuffling of the array. */
	def shuffle(): Array[Int] = {
		util.Random.shuffle(nums).array.map(x => x.##)
	}
}