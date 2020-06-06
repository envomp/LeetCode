import scala.collection.mutable

object StickersToSpellWord {
	def minStickers(stickers: Array[String], tar: String): Int = {

		val target: mutable.HashMap[Char, Int] = new mutable.HashMap()
		for (letter <- tar) {
			target.put(letter, target.getOrElse(letter, 0) + 1)
		}

		var words: List[mutable.HashMap[Char, Int]] = List()

		for (sticker <- stickers) {
			val word: mutable.HashMap[Char, Int] = new mutable.HashMap()
			var contains = false
			for (letter <- sticker.toCharArray) {
				if (target.contains(letter)) {
					contains = true
				}
				word.put(letter, word.getOrElse(letter, 0) + 1)
			}

			if (contains) {
				words ::= word
			}
		}

		for (find <- target.keys) {
			var found = false
			var word_count = words.length - 1

			while (!found && word_count >= 0) {

				if (words(word_count).contains(find)) {
					found = true
				}

				word_count -= 1
			}

			if (!found) {
				return -1
			}
		}

		val queue = mutable.Queue((0, target))
		val levels = mutable.HashMap(0 -> mutable.HashSet(target))

		for (i <- 1 until 15) {
			levels.put(i, mutable.HashSet())
		}

		while (queue.nonEmpty) {
			val (depth, cur_target) = queue.dequeue()

			for (word <- words) {
				val next_target: mutable.HashMap[Char, Int] = cur_target.clone()
				val last_sum = next_target.values.sum

				for (letter <- word.keys) {
					if (next_target.contains(letter)) {
						if (next_target(letter) - word(letter) <= 0) {
							next_target -= letter
						} else {
							next_target.put(letter, next_target(letter) - word(letter))
						}
					}
				}

				val new_sum = next_target.values.sum
				if (new_sum == 0) {
					return depth + 1
				}

				if (new_sum < last_sum && !levels(depth + 1).contains(next_target)) {
					levels(depth + 1).add(next_target)
					queue.addOne((depth + 1, next_target))
				}
			}
		}

		-1
	}

	def main(args: Array[String]): Unit = {
		println(minStickers(Array("final", "figure", "danger", "fish", "some", "product", "son", "seed", "crease", "rail", "even", "death", "end", "sit", "live", "behind", "start", "enough", "much", "between", "test", "is", "happy", "we", "north", "complete", "month", "reach", "excite", "stay", "job", "fell", "letter", "noun", "seat", "exact", "than", "ago", "protect", "kept", "this", "plain", "flow", "face", "bird", "sand", "rock", "roll", "root", "fact"), "lakeblue"))
	}
}
