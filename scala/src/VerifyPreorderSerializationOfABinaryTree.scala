

object VerifyPreorderSerializationOfABinaryTree {

	def isValidSerialization(preorder: String): Boolean = {
		val nodes = preorder.split(",")
		var l = 1

		for (i <- 0 until nodes.length) {
			if (l == 0) {
				return false
			}
			if (nodes(i) == "#") {
				l -= 1
			} else {
				l += 1
			}


		}
		l == 0
	}
}
