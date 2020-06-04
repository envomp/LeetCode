import scala.collection.mutable

object LongestArithmeticSubsequenceOfGivenDifference {

	def longestSubsequence(arr: Array[Int], difference: Int): Int = {
		var globalMaximum = 0
		val nums: mutable.HashMap[Int, Int] = mutable.HashMap()

		for (elem <- arr) {
			nums.put(elem, nums.getOrElse(elem - difference, 0) + 1)
			globalMaximum = math.max(globalMaximum, nums(elem))
		}

		globalMaximum
	}

	def main(args: Array[String]): Unit = {
		println(longestSubsequence(Array(3, 0, -3, 4, -4, 7, 6), 3))
	}
}
