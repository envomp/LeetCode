object SumOfSubsequenceWidths {

	def sumSubseqWidths(A: Array[Int]): Int = {
		import java.util
		util.Arrays.sort(A)
		var c: Long = 1
		var res: Long = 0
		val mod: Long = 1_000_000_007
		var i = 0
		val n = A.length
		while (i < n) {
			res = (res + A(i) * c - A(n - i - 1) * c) % mod
			i += 1
			c = c * 2 % mod
		}
		((res + mod) % mod).toInt
	}
}
