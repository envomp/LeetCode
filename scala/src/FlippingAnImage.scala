object FlippingAnImage {
	def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {

		A.map(x => x.reverse.map(y => if (y == 1) {0} else {1}))

	}
}
