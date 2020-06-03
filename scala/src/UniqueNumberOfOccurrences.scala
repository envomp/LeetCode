import scala.collection.mutable

object UniqueNumberOfOccurrences {

	def uniqueOccurrences(arr: Array[Int]): Boolean = {

		val repetitions: mutable.HashMap[Int, Int] = mutable.HashMap()

		for (i <- arr) {
			repetitions.put(i, repetitions.getOrElse(i, 0) + 1)
		}

		return repetitions.values.size == new mutable.HashSet[Int]().addAll(repetitions.values).size

	}

	def main(args: Array[String]): Unit = {
		println(uniqueOccurrences(Array(1, 2, 2, 1, 1, 2)))
	}

}
