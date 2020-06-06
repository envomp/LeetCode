object BulbSwitcher {
//	def bulbSwitch(n: Int): Int = {
//		for (i <- 0 until 100000) {
//			if (math.pow(i.longValue, 2) > n) {
//				return i - 1
//			}
//		}
//		-1
//	}

	def bulbSwitch(n: Int): Int = {
		math.sqrt(n).floor.##
	}

	def main(args: Array[String]): Unit = {
		println(bulbSwitch(99999999))
	}
}
