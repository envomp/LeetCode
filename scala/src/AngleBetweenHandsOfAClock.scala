object AngleBetweenHandsOfAClock {
	def angleClock(hour: Int, minutes: Int): Double = {
		val first: Double = (minutes % 60) * 6
		val second: Double = (hour % 12) * 30 + first / 12
		math.min(math.abs(first - second), 360 - math.abs(first - second))
	}

	def main(args: Array[String]): Unit = {
		println(angleClock(3, 15))
	}
}
