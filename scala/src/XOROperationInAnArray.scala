object XOROperationInAnArray {
	def xorOperation(n: Int, start: Int): Int = {

		(0 until n).map(x => x*2 + start).reduce((a, b) => a ^ b)

	}
}
