import java.util

import scala.collection.mutable

object WordLadder {
	def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
		val steps: mutable.HashMap[String, util.ArrayList[String]] = new mutable.HashMap()
		constructMap(wordList ++ List(beginWord), steps)

		val queue: mutable.Queue[(String, Int)] = new mutable.Queue()
		queue.enqueue((beginWord, 1))

		while (queue.nonEmpty) {
			val (word, used) = queue.dequeue()
			if (steps.contains(word)) {
				steps(word).forEach(step => {
					if (step.equals(endWord)) {
						return used + 1
					} else {
						steps.remove(word)
						queue.enqueue((step, used + 1))
					}
				})
			}
		}

		0
	}

	private def constructMap(wordList: List[String], steps: mutable.HashMap[String, util.ArrayList[String]]) = {
		for (from <- wordList) {
			val step: util.ArrayList[String] = new util.ArrayList()

			for (to <- wordList) {

				var diff = 0
				for (i <- 0 until from.length) {
					if (!from.charAt(i).equals(to.charAt(i))) {
						diff += 1
					}
				}

				if (diff == 1) {
					step.add(to)
				}

			}

			steps(from) = step
		}
	}
}
