import scala.collection.mutable

object MergeSortedArray {

	private def comparator(t2: Int) = {
		-t2
	}

	def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
		val queue = mutable.PriorityQueue[Int]()(Ordering.by(comparator))

		nums1.slice(0, m).foreach(x => queue.enqueue(x))
		nums2.slice(0, n).foreach(x => queue.enqueue(x))

		var i = 0
		queue.dequeueAll[Int].foreach(x => {
			nums1(i) = x
			i += 1
		})
	}

	def main(args: Array[String]): Unit = {
		merge(Array(1, 2, 3, 0, 0, 0), 3, Array(2, 5, 6), 3)
	}
}
