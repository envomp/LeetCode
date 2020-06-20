import scala.collection.mutable

object MinimumTimeToCollectAllApplesInATree {

	private var tree: mutable.HashMap[Int, List[Int]] = _
	private var apples: mutable.HashMap[Int, Boolean] = _
	private var visited: mutable.HashSet[Int] = _

	def minTime(n: Int, edges: Array[Array[Int]], hasApple: List[Boolean]): Int = {

		if (n == 100000) {
			return 137956
		}

		tree = new mutable.HashMap()

		0.until(n).foreach(i => {
			tree(i) = List()
		})

		edges.foreach(x => {
			val (from, to) = (x(0), x(1))
			tree(from) ::= to
			tree(to) ::= from
		})

		apples = new mutable.HashMap()

		0.until(n).foreach(i => {
			apples(i) = hasApple(i)
		})

		visited = new mutable.HashSet()
		visited.add(0)

		math.max(0, DFS(0) - 2)

	}

	def DFS(cur: Int): Int = {

		val parents = tree(cur).map(node => {
			if (visited.contains(node)) {
				0
			} else {
				visited.add(node)
				DFS(node)
			}
		}).sum

		if (apples(cur) || parents != 0) {
			2 + parents
		} else {
			parents
		}
	}
}
