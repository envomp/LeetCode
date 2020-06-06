import scala.collection.mutable

object Solution {
	private def comparator(t2: (Double, (Int, Int))) = {
		val (a, _) = t2
		-a
	}

	def kthSmallestPrimeFraction(A: Array[Int], K: Int): Array[Int] = {

		val queue = mutable.PriorityQueue[(Double, (Int, Int))]()(Ordering.by(comparator))

		for (i <- A.indices) {
			queue.enqueue((A(i).toDouble / A(A.length - 1), (i, A.length - 1)))
		}

		var k = K
		while (true) {
			val (div, (a, b)) = queue.dequeue()
			k -= 1

			if (k == 0) {
				return Array(A(a), A(b))
			} else {
				queue.enqueue((A(a).toDouble / A(b - 1), (a, b - 1)))
			}
		}

		Array()

	}

	def main(args: Array[String]): Unit = {
		println(kthSmallestPrimeFraction(Array(1, 2, 3, 5), 3))
	}

}