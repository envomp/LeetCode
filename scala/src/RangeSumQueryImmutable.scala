class NumArray(_nums: Array[Int]) {

	def sumRange(i: Int, j: Int): Int = {

		_nums.slice(math.min(i, j), math.max(i, j) + 1).sum

	}

}
