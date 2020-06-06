object AllPathsFromSourceToTarget {

	def DFS(start: Int, goal: Int, path: List[Int], graph: Array[Array[Int]]): List[List[Int]] = {

		if (start.equals(goal)) {
			List(path)

		} else {
			var answer: List[List[Int]] = List()
			graph(start).foreach(next => answer ++= DFS(next, goal, path ++ List(next), graph))
			answer
		}
	}

	def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {

		DFS(0, graph.length - 1, List(0), graph)

	}
}
