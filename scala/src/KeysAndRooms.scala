import scala.collection.mutable

object KeysAndRooms {
	def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {

		val visited: mutable.HashSet[Int] = mutable.HashSet()
		val queue = mutable.Queue(0)

		while (queue.nonEmpty) {
			val cur_room = queue.dequeue()

			visited.add(cur_room)
			for (room <- rooms(cur_room)) {
				if (!visited.contains(room)) {
					queue.addOne(room)
				}
			}
		}

		visited.size == rooms.length

	}
}
