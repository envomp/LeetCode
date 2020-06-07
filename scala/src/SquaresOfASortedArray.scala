object SquaresOfASortedArray {
	def sortedSquares(A: Array[Int]): Array[Int] = {
		A.map(x => math.pow(x, 2).##).sorted
	}
}
