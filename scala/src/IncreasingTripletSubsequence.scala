import java.util

object IncreasingTripletSubsequence {

	def increasingTriplet(nums: Array[Int]): Boolean = {
		lengthOfLIS(nums) > 2
	}

	def lengthOfLIS(nums: Array[Int]): Int = {
		val dp = new Array[Int](nums.length)
		var len = 0
		for (num <- nums) {
			var i = util.Arrays.binarySearch(dp, 0, len, num)
			if (i < 0) i = -(i + 1)
			dp(i) = num
			if (i == len) len += 1
		}
		len
	}
}
