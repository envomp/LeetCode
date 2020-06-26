import scala.collection.mutable

object FindAllNumbersDisappearedInAnArray {
	def findDisappearedNumbers(nums: Array[Int]): List[Int] = {

		val answer: mutable.HashSet[Int] = new mutable.HashSet()
		(1 to nums.length).foreach(x => answer.add(x))
		nums.foreach(x => answer.remove(x))
		answer.toList.sorted

	}
}
