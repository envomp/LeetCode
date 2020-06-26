import scala.collection.mutable

object GroupAnagrams {
	def groupAnagrams(strs: Array[String]): List[List[String]] = {

		val table: mutable.HashMap[String, List[String]] = new mutable.HashMap()

		strs.map(x => {
			val sorted = x.toSeq.sorted.toString()
			table.put(sorted, x :: table.getOrElse(sorted, List()))
		})

		table.values.toList

	}
}
