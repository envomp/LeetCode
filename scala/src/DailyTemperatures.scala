import scala.collection.mutable

object DailyTemperatures {
	def dailyTemperatures(T: Array[Int]): Array[Int] = {

		val temp_per_day: mutable.HashMap[Int, Int] = new mutable.HashMap()

		T.reverse.zipWithIndex.map(j => {
			val (v, i) = j
			temp_per_day(v) = i
			val a = (v + 1 to 101).map(x =>
				if (temp_per_day.contains(x)) {
					i - temp_per_day(x)
				} else {
					Int.MaxValue
				}
			).min
			if (a == Int.MaxValue) {
				0
			} else {
				a
			}
		}).reverse

	}

	def main(args: Array[String]): Unit = {
		println(dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).mkString(","))
	}
}
