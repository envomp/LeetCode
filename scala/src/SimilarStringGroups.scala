import scala.collection.mutable

object SimilarStringGroups {

	def numSimilarGroups(A: Array[String]): Int = {

		val graph = construct_graph(A)
		val global_visited: mutable.HashSet[String] = new mutable.HashSet()
		var groups = 0

		A.foreach(word => {
			if (!global_visited.contains(word)) {
				groups += 1
				global_visited.addAll(DFS_FindLocalVisited(graph, new mutable.HashSet(), word))
			}
		})

		groups

	}

	private def DFS_FindLocalVisited(graph: mutable.HashMap[String, Array[String]], visited: mutable.HashSet[String], node: String): mutable.HashSet[String] = {
		visited.add(node)
		graph(node).foreach(x => {
			if (!visited.contains(x)) {
				DFS_FindLocalVisited(graph, visited, x)
			}
		})
		visited
	}

	private def construct_graph(A: Array[String]) = {
		val graph = new mutable.HashMap[String, Array[String]]()

		A.foreach(from => {

			var to_list: List[String] = List()
			A.foreach(to => {
				if (buddyStrings(from, to)) {
					to_list ::= to
				}
			})

			graph(from) = to_list.distinct.toArray

		})

		graph
	}

	private def buddyStrings(A: String, B: String): Boolean = {

		if (A.equals(B)) {
			true

		} else {
			var diff = 0
			val queue: mutable.Queue[(Char, Char)] = new mutable.Queue()

			for (i <- 0 until A.length) {
				if (A.charAt(i) != B.charAt(i)) {

					if (diff == 2) {
						return false
					}
					diff += 1
					queue.enqueue((A.charAt(i), B.charAt(i)))
				}
			}

			if (diff != 2) {
				false

			} else {
				val (l1, r1) = queue.dequeue()
				val (l2, r2) = queue.dequeue()

				r1 == l2 && l1 == r2

			}
		}
	}

}
