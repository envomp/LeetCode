object MaximumLengthOfPairChain {

	def findLongestChain(pairs: Array[Array[Int]]): Int = {
		val sorted = pairs.map(arr => {
			(arr(0), arr(1))
		}).sortWith((a, b) => {
			val (a1, b1) = a
			val (a2, b2) = b

			if (a1 == a2) {
				b1 < b2
			} else {
				a1 < a2
			}
		})

		val mem = Array.fill(pairs.length)(1)

		for (j <- 1 until pairs.length) {
			for (i <- 0 until j) {
				if (sorted(i)._2 < sorted(j)._1) {
					mem(j) = Math.max(mem(j), mem(i) + 1)
				}
			}
		}

		mem.max
	}

	def main(args: Array[String]): Unit = {
		findLongestChain(Array(Array(1, 2), Array(3, 4), Array(2, 3)))
	}
}
