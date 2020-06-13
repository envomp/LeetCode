import scala.collection.mutable

object SudokuSolver {

	private var board: Array[Array[Int]] = _
	private var moves: mutable.HashMap[(Int, Int), List[Int]] = _
	private var rows: mutable.HashMap[Int, mutable.HashSet[Int]] = _
	private var columns: mutable.HashMap[Int, mutable.HashSet[Int]] = _
	private var squares: mutable.HashMap[Int, mutable.HashSet[Int]] = _

	private def getCorresponding3x3Square(y: Int, x: Int): Int = {
		x / 3 + (y / 3) * 3
	}

	def DFS_solver(stack: mutable.Stack[(Int, Int)]): Option[Array[Array[Int]]] = {

		if (stack.isEmpty) {
			Option(board)

		} else {
			val (y, x) = stack.pop()

			moves(y, x).foreach(v => {

				if (!rows(y).contains(v) && !columns(x).contains(v) && !squares(getCorresponding3x3Square(y, x)).contains(v)) {

					board(y)(x) = v
					rows(y).add(v)
					columns(x).add(v)
					squares(getCorresponding3x3Square(y, x)).add(v)

					val answer = DFS_solver(stack.clone())

					if (answer.isDefined) {
						return answer
					}

					board(y)(x) = 0
					rows(y).remove(v)
					columns(x).remove(v)
					squares(getCorresponding3x3Square(y, x)).remove(v)

				}
			})

			Option.empty
		}
	}

	def solveSudoku(_board: Array[Array[Char]]): Unit = {

		board = _board.map(x => x.map(z => if (z.equals('.')) '0' else z).map(y => y.asDigit))
		moves = new mutable.HashMap()
		rows = new mutable.HashMap()
		columns = new mutable.HashMap()
		squares = new mutable.HashMap()
		var stack: mutable.Stack[(Int, Int)] = new mutable.Stack()

		(0 until 9).foreach(i => {
			rows.put(i, new mutable.HashSet[Int]())
			columns.put(i, new mutable.HashSet[Int]())
			squares.put(i, new mutable.HashSet[Int]())
		})

		(0 until 9).foreach(y => {
			(0 until 9).foreach(x => {
				val value = board(y)(x)
				if (value != 0) {
					rows(y).add(value)
					columns(x).add(value)
					squares(getCorresponding3x3Square(y, x)).add(value)
				}
			})
		})

		(0 until 9).foreach(y => {
			(0 until 9).foreach(x => {
				val value = board(y)(x)
				if (value == 0) {
					moves((y, x)) = List()
					(1 to 9).foreach(v => {
						if (!rows(y).contains(v) && !columns(x).contains(v) && !squares(getCorresponding3x3Square(y, x)).contains(v)) {
							moves((y, x)) ::= v
						}
					})
					stack.addOne((y, x))
				}
			})
		})

		stack = stack.sortWith((l, r) => moves(l).size < moves(r).size)
		val int_board = DFS_solver(stack).get

		(0 until 9).foreach(y => {
			(0 until 9).foreach(x => {
				val value = (int_board(y)(x) + 48).toChar
				_board(y)(x) = value
			})
		})
	}

	def main(args: Array[String]): Unit = {
		val board = Array(
			Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
			Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
			Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
			Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
			Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
			Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
			Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
			Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
			Array('.', '.', '.', '.', '8', '.', '.', '7', '9'),
		)
		solveSudoku(board)
		println(board.map(_.mkString(" ")).mkString("\n"))

	}
}
