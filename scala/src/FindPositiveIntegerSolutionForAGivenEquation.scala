/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     def f(x: Int, y: Int): Int = {}
 * };
 */

class CustomFunction {

	def f(x: Int, y: Int): Int = x + y

}

object FindPositiveIntegerSolutionForAGivenEquation {
	def findSolution(customFunction: CustomFunction, z: Int): List[List[Int]] = {
		var answer: List[List[Int]] = List()
		var l = 1
		var r = z

		while (l <= z && r > 0) {

			val res = customFunction.f(l, r)

			if (res == z) {
				answer ::= List(l, r)
				l += 1
				r -= 1

			} else if (res > z) {
				r -= 1
			} else {
				l += 1
			}
		}

		answer
	}

	def main(args: Array[String]): Unit = {
		println(findSolution(new CustomFunction(), 5))
	}
}
