import scala.collection.mutable

class AllOne() {

	/** Initialize your data structure here. */
	private val map: mutable.HashMap[String, Long] = new mutable.HashMap()

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	def inc(key: String) {
		map(key) = map.getOrElse(key, 0L) + 1L
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	def dec(key: String) {
		if (map.contains(key)) {
			map(key) -= 1
			if (map(key) == 0) {
				map -= key
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	def getMaxKey(): String = {
		map.foldLeft(("", 0L))((best, value) => {
			if (value._2 > best._2) {
				value
			} else {
				best
			}
		})._1
	}

	/** Returns one of the keys with Minimal value. */
	def getMinKey(): String = {
		map.foldLeft(("", Long.MaxValue))((best, value) => {
			if (value._2 <= best._2) {
				value
			} else {
				best
			}
		})._1
	}
}

object Run {
	def main(args: Array[String]): Unit = {
		var obj = new AllOne()
		obj.inc("hello") // 1
		obj.inc("world") // 1
		obj.inc("leet") // 1
		obj.inc("code") // 1
		obj.inc("DS") // 1
		obj.inc("leet") // 2
		println(obj.getMaxKey())
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * var obj = new AllOne()
 * obj.inc(key)
 * obj.dec(key)
 * var param_3 = obj.getMaxKey()
 * var param_4 = obj.getMinKey()
 */