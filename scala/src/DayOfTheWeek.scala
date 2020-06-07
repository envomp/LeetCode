import java.time.LocalDateTime

object DayOfTheWeek {
	def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
		val someDate = LocalDateTime.of(year, month, day, 0, 0)
		someDate.getDayOfWeek.toString.toLowerCase.capitalize
	}
}
