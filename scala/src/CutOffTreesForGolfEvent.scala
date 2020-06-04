import scala.collection.mutable

object CutOffTreesForGolfEvent {

	private def comparator(t2: (Int, (Int, Int))) = {
		val (a, _) = t2
		-a
	}

	private def makeStep(forest: List[List[Int]], y: Int, x: Int, steps: Int, queue: mutable.Queue[((Int, Int), Int)], visited: mutable.HashSet[(Int, Int)]) = {
		val pos = (y, x)
		if (!visited.contains(pos) && y >= 0 && x >= 0 && y < forest.length && x < forest(y).length && forest(y)(x) != 0) {
			visited.add(pos)
			val new_step = (pos, steps + 1)
			queue.addOne(new_step)
		}
	}

	private def pathFindGetSteps(forest: List[List[Int]], start: (Int, Int), goal: (Int, Int)): Either[Int, Int] = {
		val queue = mutable.Queue[((Int, Int), Int)]((start, 0))
		val visited = mutable.HashSet[(Int, Int)](start)

		while (queue.nonEmpty) {

			val ((y0, x0), steps) = queue.dequeue()
			if ((y0, x0).equals(goal)) {
				return Left(steps)
			}

			makeStep(forest, y0 + 1, x0, steps, queue, visited)
			makeStep(forest, y0, x0 + 1, steps, queue, visited)
			makeStep(forest, y0 - 1, x0, steps, queue, visited)
			makeStep(forest, y0, x0 - 1, steps, queue, visited)

		}

		Right(-1)
	}

	def cutOffTree(forest: List[List[Int]]): Int = {

		val queue = mutable.PriorityQueue[(Int, (Int, Int))]()(Ordering.by(comparator))

		for (y <- forest.indices) {
			for (x <- forest(y).indices) {
				if (forest(y)(x) > 1) {
					queue.addOne((forest(y)(x), (y, x)))
				}
			}
		}

		var totalSteps = 0
		var start = (0, 0)

		while (queue.nonEmpty) {
			val (_, goal) = queue.dequeue()

			pathFindGetSteps(forest, start, goal) match {
				case Right(x) => return x
				case Left(x) => totalSteps += x
			}

			start = goal
		}

		totalSteps

	}

	def main(args: Array[String]): Unit = {
		println(cutOffTree(List(List(1, 2, 3), List(0, 0, 0), List(5, 7, 6))))
	}
}
