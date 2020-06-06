object MinimumNumberOfTapsToOpenToWaterAGarden {
	def minTaps(n: Int, _ranges: Array[Int]): Int = {

		val ranges = _ranges.indices
			.map(x => {
				(math.max(0, x - _ranges(x)), math.min(n, x + _ranges(x) - 1))
			})
			.filter(f => {
				val (f1, f2) = f
				f1 != f2 + 1
			})
			.sortWith((a, b) => {
				val (l1, _) = a
				val (l2, _) = b
				l2 > l1
			}).toList

		val dp = Array.fill(n + 1)(0)

		for (range <- ranges) {
			val (from, to) = range
			var start = dp(from)

			if (start == 0) {
				if (from > 0) {
					start = dp(from - 1)
				} else {
					start = 1
				}
			}

			if (dp(to) != start || start == 0) {
				for (i <- from to to) {
					if (dp(i) != start) {
						if (from == 0 || dp(from - 1) != start) {
							dp(i) = start
						} else {
							dp(i) = start + 1
						}
					}
				}
			}

		}

		if (dp.slice(0, n).min == 0) {
			-1
		} else {
			dp(n - 1)
		}
	}

	def main(args: Array[String]): Unit = {
//		println(minTaps(35, Array(1, 0, 4, 0, 4, 1, 4, 3, 1, 1, 1, 2, 1, 4, 0, 3, 0, 3, 0, 3, 0, 5, 3, 0, 0, 1, 2, 1, 2, 4, 3, 0, 1, 0, 5, 2)))
//		println(minTaps(5, Array(3, 4, 1, 1, 0, 0)))
//		println(minTaps(3, Array(0, 0, 0, 0)))
		println(minTaps(7, Array(1, 2, 1, 0, 2, 1, 0, 1)))
	}
}
