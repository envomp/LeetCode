object NumberOf1Bits {
	// you need treat n as an unsigned value
	def hammingWeight(n: Int): Int = {

		n.toBinaryString.split("").map(x => x.toInt).sum

	}
}
