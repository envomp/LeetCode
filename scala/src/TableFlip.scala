import scala.collection.mutable

object TableFlip {

	protected var visited: mutable.HashSet[Int] = _
	protected var m: Int = _
	protected var n: Int = _

	def swap(mat: Array[Array[Int]], i: Int, j: Int) = {

		if (i >= 0 && i < m && j >= 0 && j < n) {
			if (mat(i)(j) == 1) {
				mat(i)(j) = 0
			} else {
				mat(i)(j) = 1
			}
		}

	}

	private def make_swaps(mat: Array[Array[Int]], i: Int, j: Int) = {
		swap(mat, i, j)
		swap(mat, i + 1, j)
		swap(mat, i, j + 1)
		swap(mat, i - 1, j)
		swap(mat, i, j - 1)
	}

	def minFlips(mat: Array[Array[Int]]): Int = {
		this.visited = mutable.HashSet()
		this.m = mat.length
		this.n = mat(0).length

		val score: Int = getScore(mat)

		visited.add(score)

		if (score == 0) {
			return 0
		}

		val queue = mutable.Queue((mat.clone().map(x => x.clone()), 0))

		while (queue.nonEmpty) {
			val (map, depth) = queue.dequeue
//			println(map.map(_.mkString(" ")).mkString("\n"))
//			println()

			for (i <- 0 until m) {
				for (j <- 0 until n) {
					make_swaps(map, i, j)
					val score = getScore(map)

					if (score == 0) {
						return depth + 1
					} else {
						if (!visited.contains(score)) {
							visited.add(score)
							queue.enqueue((map.clone().map(x => x.clone()), depth + 1))
						}
					}
					make_swaps(map, i, j)
				}
			}

		}

		return -1

	}

	private def getScore(mat: Array[Array[Int]]) = {
		var score = 0

		for (i <- 0 until m) {
			for (j <- 0 until n) {
				score += math.pow(2, m * i + j + 1).## * mat(i)(j)
			}
		}
		score
	}

	def main(args: Array[String]): Unit = {
		val test1 = Array(Array(1, 1, 0), Array(1, 0, 1), Array(0, 1, 1))
		val test2 = Array(Array(1, 1, 1), Array(1, 0, 1), Array(0, 0, 0))
		println(minFlips(test2))
	}
}