object ToeplitzMatrix {
	def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {

		for (y <- 0 until matrix.length - 1) {
			for (x <- 0 until matrix(y).length - 1) {
				if (matrix(y)(x) != matrix(y + 1)(x + 1)) {
					return false
				}
			}
		}

		return true
	}

	def main(args: Array[String]): Unit = {
		println(isToeplitzMatrix(Array(Array(0, 33, 98), Array(34, 0, 33))))
	}
}