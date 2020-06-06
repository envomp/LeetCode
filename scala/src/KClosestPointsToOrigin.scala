import scala.collection.mutable

object KClosestPointsToOrigin {

	private def comparator(t2: (Int, Int)) = {
		val (a, b) = t2
		-(math.pow(a, 2) + math.pow(b, 2))
	}

	def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = {

		val queue = mutable.PriorityQueue[(Int, Int)]()(Ordering.by(comparator))

		points.foreach(x => {
			queue.enqueue((x(0), x(1)))
		})

		(0 until K).map(_ => {
			val (a, b) = queue.dequeue()
			Array(a, b)
		}).toArray
	}

	def main(args: Array[String]): Unit = {
		println(kClosest(Array(Array(3, 3), Array(5, -1), Array(-2, 4), Array(100, 100), Array(1000, 1000)), 2))
	}
}
