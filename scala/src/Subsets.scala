object Subsets {
	def subsets(nums: Array[Int]): List[List[Int]] = {

		(0 until math.pow(2, nums.length).##)
			.map(x => {
				val str = x.toBinaryString
				"0" * (nums.length - str.length) ++ str
			}.split("").zipWithIndex
				.map(x => {
					val (v, i) = x
					if (v == "1") {
						nums(i)
					} else {
						null
					}
				}).filter(x => x != null).map(x => x.##).toList
			).toList

	}
}
