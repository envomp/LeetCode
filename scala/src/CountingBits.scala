object CountingBits {
	def countBits(num: Int): Array[Int] = {

		(0 to num).map(x => {
			var biggest_pow = 1
			var current = x
			while (biggest_pow <= current) {
				biggest_pow *= 2
			}
			biggest_pow /= 2
			var counter = 0

			while (current != 0){
				if (biggest_pow <= current) {
					counter += 1
					current -= biggest_pow
				}
				biggest_pow /= 2
			}
			println()
			counter
		}).toArray

	}

	def main(args: Array[String]): Unit = {
		countBits(5)
	}

}
