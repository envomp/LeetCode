object ProductOfArrayExceptSelf {
	def productExceptSelf(nums: Array[Int]): Array[Int] = {

		val answer = Array.fill(nums.length)(1)

		var right_triangle = 1

		nums.indices.foreach(i => {
			answer(i) *= right_triangle
			right_triangle *= nums(i)
		})

		var left_triangle = 1

		nums.indices.reverse.foreach(i => {
			answer(i) *= left_triangle
			left_triangle *= nums(i)
		})

		answer
	}
}
