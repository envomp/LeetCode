object GameOfLife {
	def gameOfLife(board: Array[Array[Int]]): Unit = {

		if (board.length == 0) {
			return
		}

		val copy = board.clone().map(x => x.clone())

		for (y0 <- board.indices) {
			for (x0 <- board(y0).indices) {
				val alive = getAliveNeighbours(copy, y0, x0)
				board(y0)(x0) = getNewState(board, y0, x0, alive)
			}
		}

	}

	private def getNewState(board: Array[Array[Int]], y0: Int, x0: Int, alive: Int) = {
		board(y0)(x0) match {
			case 0 => alive match {
				case 3 => 1
				case _ => 0
			}
			case 1 => alive match {
				case 2 => 1
				case 3 => 1
				case _ => 0
			}
		}
	}

	private def getAliveNeighbours(board: Array[Array[Int]], y0: Int, x0: Int) = {
		var sum = 0
		for (j <- -1 until 2) {
			for (i <- -1 until 2) {

				val y = y0 + j
				val x = x0 + i
				if (y >= 0 && x >= 0 && y < board.length && x < board(y).length) {
					sum += board(y)(x)
				}
			}
		}

		sum - board(y0)(x0)
	}

	def main(args: Array[String]): Unit = {
		gameOfLife(Array(Array(0, 1, 0), Array(0, 0, 1), Array(1, 1, 1), Array(0, 0, 0)))
	}
}
