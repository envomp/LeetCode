object ArrayPartitionI {
	def arrayPairSum(nums: Array[Int]): Int = {

		val sorted = nums.sorted
		(sorted.indices by 2).map(x => {
			sorted(x)
		}).sum
	}
}
