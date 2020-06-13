import scala.collection.mutable

object PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
	def peopleIndexes(favoriteCompanies: List[List[String]]): List[Int] = {

		val sets: Array[mutable.HashSet[String]] = Array.fill(favoriteCompanies.size)(new mutable.HashSet())

		var i = 0
		favoriteCompanies.foreach(x => {
			sets(i).addAll(x)
			i += 1
		})

		var answer: List[Int] = List()
		sets.indices.foreach(y => { // all answers
			var unique = true
			var i = 0

			while (unique && i < sets.length) { // check for subsets
				if (i != y && favoriteCompanies(y).length <= favoriteCompanies(i).length) {
					var all = true
					var j = 0

					while (all && j < favoriteCompanies(y).size) { // specific subset
						all &&= sets(i).contains(favoriteCompanies(y)(j))
						j += 1
					}

					unique &&= !all
				}
				i += 1
			}
			if (unique) {
				answer ::= y
			}
		})

		answer.reverse
	}

	def main(args: Array[String]): Unit = {
		peopleIndexes(List(List("leetcode", "google", "facebook"), List("google", "microsoft"), List("google", "facebook"), List("google"), List("amazon")))
	}
}
