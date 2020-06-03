object SuperWashingMachines {
	def findMinMoves(machines: Array[Int]): Int = {
		if (machines.sum % machines.length != 0) {
			return -1
		}

		val targetDresses = machines.sum / machines.length
		var totalMoves = 0
		var offset = 0
		for (i <- machines.indices) {
			offset += machines(i) - targetDresses
			totalMoves = math.max(totalMoves, math.max(machines(i) - targetDresses, math.abs(offset)))
		}

		return totalMoves
	}

	def main(args: Array[String]): Unit = {
		println(findMinMoves(Array(0, 0, 11, 5)))
	}
}
