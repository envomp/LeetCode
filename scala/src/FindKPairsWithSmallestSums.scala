import scala.collection.mutable

object FindKPairsWithSmallestSums {

	private def comparator(t2: (Int, (Int, Int))) = {
		val (a, _) = t2
		-a
	}

	def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {

		if (nums1.length == 0 || nums2.length == 0) {
			return List()
		}

		val queue = mutable.PriorityQueue[(Int, (Int, Int))]()(Ordering.by(comparator))
		val used: mutable.HashSet[(Int, Int)] = new mutable.HashSet()

		queue.enqueue((nums1(0) + nums2(0), (0, 0)))
		used.add((0, 0))

		var answer: List[List[Int]] = List()

		for (i <- 0 until math.min(k, nums1.length * nums2.length)) {

			val (_, (pointer1, pointer2)) = queue.dequeue()
			answer ::= List(nums1(pointer1), nums2(pointer2))

			if (pointer1 < nums1.length - 1) {
				if (!used.contains((pointer1 + 1, pointer2))) {
					queue.enqueue((nums1(pointer1 + 1) + nums2(pointer2) ,(pointer1 + 1, pointer2)))
					used.add((pointer1 + 1, pointer2))
				}
			}

			if (pointer2 < nums2.length - 1) {
				if (!used.contains((pointer1, pointer2 + 1))) {
					queue.enqueue((nums1(pointer1) + nums2(pointer2 + 1) ,(pointer1, pointer2 + 1)))
					used.add((pointer1, pointer2 + 1))
				}
			}
		}

		answer.reverse

	}
}
