
object CreateTargetArrayInTheGivenOrder {
	def createTargetArray(nums: Array[Int], index: Array[Int]): Array[Int] = {
		var target: List[Int] = List()
		nums.indices.foreach(x => {
			val i = index(x)
			target = target.slice(0, i) ++ List(nums(x)) ++ target.slice(i, target.size)
		})
		target.toArray
	}

	def main(args: Array[String]): Unit = {
		println(createTargetArray(Array(0, 1, 2, 3, 4), Array(0, 1, 2, 2, 1)))
	}
}
