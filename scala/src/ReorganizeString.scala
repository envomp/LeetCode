import scala.collection.mutable

object ReorganizeString {

	private def comparator(t2: (Char, Int)) = {
		val (_, a) = t2
		a
	}

	def reorganizeString(S: String): String = {

		val queue = mutable.PriorityQueue[(Char, Int)]()(Ordering.by(comparator))

		val repetitions = mutable.HashMap[Char, Int]()

		S.toCharArray.foreach(x => {
			repetitions.put(x, repetitions.getOrElse(x, 0) + 1)
		})

		repetitions.keys.foreach(x => {
			queue.enqueue((x, repetitions(x)))
		})

		var last = '.'
		val answer = new StringBuilder()

		while (queue.nonEmpty) {

			val (most, count) = queue.dequeue()

			if (last.equals(most)) {
				if (queue.isEmpty) {
					return ""
				} else {
					val (second_most, other_count) = queue.dequeue()
					last = second_most
					if (other_count > 1) {
						queue.enqueue((second_most, other_count - 1))
					}
					queue.enqueue((most, count))
				}
			} else {
				last = most
				if (count > 1) {
					queue.enqueue((most, count - 1))
				}
			}

			answer.append(last)
		}

		answer.toString()

	}

	def main(args: Array[String]): Unit = {
		println(reorganizeString("aabsdasd"))
	}
}
