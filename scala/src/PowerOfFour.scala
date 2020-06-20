object PowerOfFour {
	def isPowerOfFour(num: Int): Boolean = {
		(math.log(num) / math.log(4)).isValidInt
	}

	def main(args: Array[String]): Unit = {
		isPowerOfFour(-2147483648)
	}
}
