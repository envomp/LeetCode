object SubtractTheProductAndSumOfDigitsOfAnInteger {
	def subtractProductAndSum(n: Int): Int = {
		val nums = n.toString.toCharArray.map(x => x.## - 48)
		nums.product - nums.sum
	}

	def main(args: Array[String]): Unit = {
		subtractProductAndSum(234)
	}
}
