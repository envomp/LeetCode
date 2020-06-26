object Permutations {

	def permute(nums: Array[Int]): List[List[Int]] = {
		nums.permutations.map(x => x.toList).toList
	}
}
