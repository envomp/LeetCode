object RunningSumOf1dArray {
	def runningSum(nums: Array[Int]): Array[Int] = {

		var running = 0

		nums.map(x => {
			running += +x; running
		})

	}
}
