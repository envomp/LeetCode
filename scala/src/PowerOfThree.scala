object PowerOfThree {
	def isPowerOfThree(n: Int): Boolean = {
		if (n <= 0) {
			false
		} else {
			val ans = math.log(n) / math.log(3)
			println(ans)
			BigDecimal(ans).setScale(10, BigDecimal.RoundingMode.HALF_UP).toDouble.isValidInt
		}
	}

	def main(args: Array[String]): Unit = {
		isPowerOfThree(-3)
	}
}
