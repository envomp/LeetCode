import scala.collection.mutable

object TopKFrequentElements {
	private def comparator(t2: (Int, Int)) = {
		val (_, rep) = t2
		-rep
	}

	def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {

		val repetitions: mutable.HashMap[Int, Int] = new mutable.HashMap()

		nums.foreach(x => repetitions.put(x, repetitions.getOrElse(x, 0) + 1))

		val top = mutable.PriorityQueue[(Int, Int)]()(Ordering.by(comparator))

		repetitions.iterator.foreach(x => {
			top.enqueue(x)
			if (top.size == k + 1) {
				top.dequeue()
			}
		})

		top.dequeueAll[(Int, Int)].map(x => x._1).toArray

	}
}
