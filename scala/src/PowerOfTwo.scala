object PowerOfTwo {
	def isPowerOfTwo(n: Int): Boolean = {
		if (n <= 0) {
			false
		} else {
			val ans = math.log(n) / math.log(2)
			println(ans)
			BigDecimal(ans).setScale(10, BigDecimal.RoundingMode.HALF_UP).toDouble.isValidInt
		}
	}
}
