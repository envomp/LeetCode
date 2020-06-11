import scala.collection.mutable

object SubstringWithConcatenationOfAllWords {

	private var global_cache: mutable.HashMap[Int, String] = new mutable.HashMap()

	def findSubstring(s: String, words: Array[String]): List[Int] = {

		global_cache = new mutable.HashMap()

		if (words.length < 1) {
			return List()
		}

		var answer: List[Int] = List()
		var i = 0
		val word_length = words(0).length
		val words_step = word_length * words.length
		val hashed_words: mutable.HashMap[String, Int] = new mutable.HashMap()
		words.foreach(x => hashed_words.put(x, hashed_words.getOrElse(x, 0) + 1))

		for (i <- 0 to s.length - word_length) {
			global_cache(i) = s.substring(i, i + word_length)
		}

		while (i < s.length - words_step + 1) {

			if (containsConsecutiveStrings(i, hashed_words, word_length, words.length)) {
				answer ::= i
			}
			i += 1
		}

		answer
	}

	private def containsConsecutiveStrings(start: Int, hashed_words: mutable.HashMap[String, Int], word_length: Int, words_length: Int): Boolean = {
		val distinct: mutable.HashMap[String, Int] = new mutable.HashMap()

		for (i <- 0 until word_length * words_length by word_length) {
			val sub_string = global_cache(start + i)
			if (hashed_words.contains(sub_string) && distinct.getOrElse(sub_string, 0) + 1 <= hashed_words(sub_string)) {
				distinct.put(sub_string, distinct.getOrElse(sub_string, 0) + 1)
			} else {
				return false
			}
		}
		true
	}

	def main(args: Array[String]): Unit = {
		//		println(findSubstring("wordgoodgoodgoodbestword", Array("word","good","best","good")))
		//		println(findSubstring("wordgoodgoodgoodbestword", Array("word","good","best","word")))
		//		println(findSubstring("barfoothefoobarman", Array("foo","bar")))
		//		println(findSubstring("aaaaaaaa", Array("aa","aa","aa")))
		println(findSubstring("a", Array("a")))
	}
}
