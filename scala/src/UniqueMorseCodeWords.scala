import scala.collection.mutable

object UniqueMorseCodeWords {

	def uniqueMorseRepresentations(words: Array[String]): Int = {

		val map = mutable.HashMap("a" -> ".-", "b" -> "-...", "c" -> "-.-.", "d" -> "-..", "e" -> ".", "f" -> "..-.", "g" -> "--.", "h" -> "....", "i" -> "..", "j" -> ".---", "k" -> "-.-", "l" -> ".-..", "m" -> "--", "n" -> "-.", "o" -> "---", "p" -> ".--.", "q" -> "--.-", "r" -> ".-.", "s" -> "...", "t" -> "-", "u" -> "..-", "v" -> "...-", "w" -> ".--", "x" -> "-..-", "y" -> "-.--", "z" -> "--..")
		new mutable.HashSet().addAll(
			words.map(x => {
				x.fold("")((l, r) => l + map(String.valueOf(r)))
			})
		).size

	}

}
