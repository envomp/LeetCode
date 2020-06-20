object InsertInterval {
	//	def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
	//
	//		val (start, end) = (newInterval(0), newInterval(1))
	//
	//		if (intervals.length == 0) {
	//			return Array(newInterval)
	//		}
	//
	//		if (intervals(0)(0) > end) {
	//			return Array(newInterval) ++ intervals
	//		}
	//
	//		if (intervals(intervals.length - 1)(1) < start) {
	//			return intervals ++ Array(newInterval)
	//		}
	//
	//		var on_going = false
	//		var answer: List[Array[Int]] = List()
	//
	//		if (intervals(0)(0) > start) {
	//			on_going = true
	//			answer = answer :+ Array(start, 0)
	//		}
	//
	//		intervals.foreach(x => {
	//			val (left, right) = (x(0), x(1))
	//
	//			if (on_going) {
	//				if (left > start) {
	//
	//					if (right < end) {
	//
	//					} else {
	//						if (end >= left) {
	//							answer.last(1) = right
	//							on_going = false
	//
	//						} else {
	//							answer.last(1) = end
	//							on_going = false
	//
	//							answer = answer :+ x
	//						}
	//					}
	//
	//				}
	//			} else {
	//
	//				if (right < start) {
	//					answer = answer :+ x
	//				} else {
	//					val target = Array(0, 0)
	//
	//					if (left <= start || end < left) {
	//						target(0) = left
	//						if (answer.nonEmpty && answer.last(1) < start && left > end) {
	//							answer = answer :+ newInterval
	//						}
	//
	//					} else {
	//						target(0) = start
	//					}
	//
	//					if (end >= right) {
	//						on_going = true
	//					} else {
	//						target(1) = right
	//					}
	//
	//					answer = answer :+ target
	//				}
	//			}
	//		})
	//
	//		if (on_going) {
	//			answer.last(1) = end
	//		}
	//
	//		answer.toArray
	//	}

	def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {

		var new_intervals: List[Array[Int]] = List()
		var added = false

		intervals.foreach(interval => {
			if (!added && interval(0) > newInterval(0)) {
				added = true
				new_intervals = new_intervals :+ newInterval
			}
			new_intervals = new_intervals :+ interval
		})

		if (!added) {
			new_intervals = new_intervals :+ newInterval
		}

		var answer: List[Array[Int]] = List()

		new_intervals.foreach(interval => {
			if (answer.isEmpty || answer.last(1) < interval(0)) {
				answer = answer :+ interval
			} else {
				answer.last(1) = math.max(answer.last(1), interval(1))
			}
		})

		answer.toArray

	}

	def main(args: Array[String]): Unit = {
		println(insert(Array(Array(1, 3), Array(6, 9)), Array(2, 5)).map(x => x.mkString(" ")).mkString("|"))
		println(insert(Array(Array(1, 5), Array(6, 9)), Array(0, 3)).map(x => x.mkString(" ")).mkString("|"))
		println(insert(Array(Array(1, 5), Array(6, 9)), Array(7, 10)).map(x => x.mkString(" ")).mkString("|"))
		println(insert(Array(Array(1, 2), Array(3, 5), Array(6, 7), Array(8, 10), Array(12, 16)), Array(4, 8)).map(x => x.mkString(" ")).mkString("|"))
		println(insert(Array(Array(0, 5), Array(9, 12)), Array(7, 16)).map(x => x.mkString(" ")).mkString("|"))
		println(insert(Array(Array(3, 5), Array(12, 15)), Array(6, 6)).map(x => x.mkString(" ")).mkString("|"))
	}
}
