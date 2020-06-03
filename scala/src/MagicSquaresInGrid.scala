import scala.collection.mutable
// Array(1, 2, 3).fold(List[Int]())((x, y) => y :: x.asInstanceOf[List[Int]])
// Scala has fold ^^

object MagicSquaresInGrid {
	def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
		var magic_squares_count = 0
		for (y0 <- 0 until grid.length - 2) {
			for (x0 <- 0 until grid(0).length - 2) {
				if (isMagicSquare(grid.slice(y0, y0 + 3).map(x => x.slice(x0, x0 + 3)))) {
					magic_squares_count += 1
				}
			}
		}
		magic_squares_count
	}

	def isMagicSquare(grid: Array[Array[Int]]): Boolean = {
		if (mutable.HashSet().addAll(grid.flatten.array).size != 9 || grid.flatten.max > 9 || grid.flatten.min == 0) {
			return false
		}

		val desiredSum = getColumn(grid, 0)

		for (y <- 0 until 3) {
			if (getColumn(grid, y) != desiredSum) {
				return false
			}
		}

		for (x <- 0 until 3) {
			if (getRow(grid, x) != desiredSum) {
				return false
			}
		}

		if (getDiagonal(grid) != desiredSum) {
			return false
		}

		if (getOtherDiagonal(grid) != desiredSum) {
			return false
		}

		true
	}

	private def getColumn(grid: Array[Array[Int]], y: Int): Int = {
		var validationSum = 0
		for (x <- 0 until 3) {
			validationSum += grid(y)(x)
		}
		validationSum
	}

	private def getRow(grid: Array[Array[Int]], x: Int) = {
		var validationSum = 0
		for (y <- 0 until 3) {

			validationSum += grid(y)(x)
		}
		validationSum
	}

	private def getOtherDiagonal(grid: Array[Array[Int]]) = {
		var validationSum2 = 0
		for (i <- 0 until 3) {
			validationSum2 += grid(2 - i)(i)
		}
		validationSum2
	}

	private def getDiagonal(grid: Array[Array[Int]]) = {
		var validationSum = 0
		for (i <- 0 until 3) {
			validationSum += grid(i)(i)
		}
		validationSum
	}

	def main(args: Array[String]): Unit = {
		println(numMagicSquaresInside(Array(Array(5, 5, 5), Array(5, 5, 5), Array(5, 5, 5))))
	}
}
