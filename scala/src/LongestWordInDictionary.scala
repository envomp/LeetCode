object LongestWordInDictionary {
	def longestWord(words: Array[String]): String = {
		val sorted_words = words.sorted

		var longest = ""
		var usable = List("")

		for (word <- sorted_words) {
			if (usable.exists(next => word.startsWith(next) && next.length + 1 == word.length)) {
				if (word.length > longest.length) {
					longest = word
				}
				usable ::= word
			}
		}
		longest
	}

	def main(args: Array[String]): Unit = {
		longestWord(Array("rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"))
	}
}
