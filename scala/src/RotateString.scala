
object RotateString {

	def rotateString(A: String, B: String): Boolean = {
		return A.length == B.length && (A + A).contains(B)
	}

	def main(args: Array[String]): Unit = {
		println(rotateString("abcde", "cdeab"))
	}
}
