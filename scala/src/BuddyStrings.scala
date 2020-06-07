import scala.collection.mutable

object BuddyStrings {
	def buddyStrings(A: String, B: String): Boolean = {

		var diff = 0
		val queue: mutable.Queue[(Char, Char)] = new mutable.Queue()

		for (i <- 0 until A.length) {
			if (A.charAt(i) != B.charAt(i)) {

				if (diff == 2) {
					return false
				}
				diff += 1
				queue.enqueue((A.charAt(i), B.charAt(i)))
			}
		}

		if (diff == 0) {
			val words: mutable.HashSet[Char] = new mutable.HashSet[Char]()
			for (letter <- A.toCharArray) {
				words.add(letter)
			}
			return words.size != A.length
		}

		if (diff != 2) {
			return false
		}

		val (l1, r1) = queue.dequeue()
		val (l2, r2) = queue.dequeue()

		r1 == l2 && l1 == r2

	}
}
