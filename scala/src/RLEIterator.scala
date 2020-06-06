import scala.collection.mutable

class RLEIterator(_A: Array[Int]) {

	var iterable: mutable.Queue[(Int, Int)] = {
		val answer: mutable.Queue[(Int, Int)] = new mutable.Queue[(Int, Int)]()
		(_A.indices by 2).foreach(x => {
			if (_A(x) != 0) {
				answer.enqueue((_A(x + 1), _A(x)))
			}
		})
		answer
	}

	def next(n: Int): Int = {

		var last = -1
		var i = n
		while (i > 0) {
			if (iterable.isEmpty) {
				return -1
			}
			var (target, count) = iterable.dequeue()

			if (count >= i) {
				count -= i
				i = 0
				last = target

				if (count != 0) {
					iterable.prepend((target, count))
				}

			} else {
				i -= count
			}
		}

		last
	}

}

object Main {
	def main(args: Array[String]): Unit = {
		val obj = new RLEIterator(Array(3, 8, 0, 9, 2, 5))
		println(obj.next(2))
		println(obj.next(1))
		println(obj.next(1))
		println(obj.next(2))

	}
}
