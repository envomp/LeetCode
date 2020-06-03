object LongestUncommonSubsequenceII {
	def findLUSlength(strs: Array[String]): Int = {
		var maxLength = -1
		for (i <- strs.indices) {
			if (!anySubsequence(strs, i)) {
				maxLength = Math.max(strs(i).length, maxLength)
			}
		}
		maxLength
	}

	private def anySubsequence(strs: Array[String], i: Int): Boolean = {
		for (j <- strs.indices) {
			if (i != j) {
				if (isSubSeq(strs(i), strs(j))) {
					return true
				}
			}
		}
		false
	}

	private def isSubSeq(s1: String, s2: String) = {
		var i = 0
		var j = 0
		while ( {
			j < s2.length && i < s1.length
		}) if (s1.charAt(i) == s2.charAt(j)) {
			i += 1
			j += 1
		}
		else j += 1
		i == s1.length
	}

	def main(args: Array[String]): Unit = {
		findLUSlength(Array("aabbcc", "aabbcc", "cb", "abc"))
	}
}
