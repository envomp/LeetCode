object CombinationSum {

	def DFS(sum: Int, values: List[Int], candidates: Array[Int], target: Int, last: Int): List[List[Int]] = {

		if (sum == target) {
			List(values)
		} else if (sum > target) {
			List()
		} else {
			var pointer = last
			var answer: List[List[Int]] = List()

			while (pointer < candidates.length && candidates(pointer) + sum <= target) {
				answer ++= DFS(sum + candidates(pointer), candidates(pointer) :: values, candidates, target, pointer)
				pointer += 1
			}

			answer
		}

	}

	def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
		if (candidates == null) {
			List()
		} else {
			DFS(0, List(), candidates.sorted, target, 0)
		}

	}
}
