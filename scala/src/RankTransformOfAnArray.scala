import scala.collection.mutable

object RankTransformOfAnArray {
	def arrayRankTransform(arr: Array[Int]): Array[Int] = {

		val ranks = arr.distinct.sorted
		arr.map(x => ranks.indexOf(x) + 1)


	}

	def main(args: Array[String]): Unit = {
		arrayRankTransform(Array(37,12,28,9,100,56,80,5,12))
	}
}
