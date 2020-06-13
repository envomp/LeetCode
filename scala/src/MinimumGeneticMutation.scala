import scala.collection.mutable

object MinimumGeneticMutation {
	def minMutation(start: String, end: String, bank: Array[String]): Int = {

		val jumps: mutable.HashMap[String, List[String]] = new mutable.HashMap()
		fillJumps(start, bank, jumps)

		val queue: mutable.Queue[(String, Int)] = new mutable.Queue()
		val used_words: mutable.HashSet[String] = new mutable.HashSet()

		def addToQueue(word: String, depth: Int) = {
			queue.addOne((word, depth))
			used_words.add(word)
		}

		addToQueue(start, 1)

		while (queue.nonEmpty) {
			val (from, depth) = queue.dequeue()

			for (to <- jumps(from)) {
				if (to.equals(end)) {
					return depth
				}

				if (!used_words.contains(to)) {
					addToQueue(to, depth + 1)
				}
			}

		}

		-1
	}

	private def fillJumps(start: String, bank: Array[String], jumps: mutable.HashMap[String, List[String]]) = {
		for (from <- start :: bank.toList) {
			var _jumps: List[String] = List()
			for (to <- bank.toList) {

				if (from.length == to.length) {
					var diff = 0
					for (i <- 0 until from.length) {
						if (!from.charAt(i).equals(to.charAt(i))) {
							diff += 1
						}
					}

					if (diff == 1) {
						_jumps ::= to
					}
				}

			}
			jumps(from) = _jumps
		}
	}

	def main(args: Array[String]): Unit = {
		minMutation("AAAAACCC", "AACCCCCC", Array("AAAACCCC", "AAACCCCC", "AACCCCCC"))
	}
}
