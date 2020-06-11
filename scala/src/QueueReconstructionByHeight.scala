object QueueReconstructionByHeight {
	def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
		val answer: Array[Array[Int]] = Array.fill(people.length)(Array())

		val sorted_people = people.sortBy(xs => xs(1)).sortBy(xs => xs(0))
		var global_pointer = 0
		var global_height = -1
		var last_counter = 0

		sorted_people.foreach(x => {
			val (height, counter_copy) = (x(0), x(1))
			var counter = counter_copy - last_counter

			if (height != global_height) {
				global_pointer = 0
				global_height = height
				last_counter = 0
				counter = counter_copy + 1
			}

			while (counter != 0) {
				if (answer(global_pointer).length == 0) {
					counter -= 1
				}
				if (counter != 0) {
					global_pointer += 1
				}
			}

			last_counter = counter_copy

			answer(global_pointer) = Array(height, counter_copy)
		})

		answer
	}

	def main(args: Array[String]): Unit = {
		reconstructQueue(Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2)))
	}
}
