
class MyCircularDeque(_k: Int) {

	/** Initialize your data structure here. Set the size of the deque to be k. */

	val max_size = _k

	var data: List[Int] = List()

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	def insertFront(value: Int): Boolean = {
		if (data.length < max_size) {
			data ::= value
			true
		} else {
			false
		}
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	def insertLast(value: Int): Boolean = {
		if (data.length < max_size) {
			data = data :+ value
			true
		} else {
			false
		}
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	def deleteFront(): Boolean = {
		if (data.nonEmpty) {
			data = data.drop(1)
			true
		} else {
			false
		}
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	def deleteLast(): Boolean = {
		if (data.nonEmpty) {
			val head = 0
			data = data.dropRight(1)
			true
		} else {
			false
		}
	}

	/** Get the front item from the deque. */
	def getFront(): Int = {
		if (data.nonEmpty) {
			data.head
		} else {
			-1
		}
	}

	/** Get the last item from the deque. */
	def getRear(): Int = {
		if (data.nonEmpty) {
			data.last
		} else {
			-1
		}
	}

	/** Checks whether the circular deque is empty or not. */
	def isEmpty(): Boolean = {
		data.isEmpty
	}

	/** Checks whether the circular deque is full or not. */
	def isFull(): Boolean = {
		data.length == max_size
	}

}

object DesignCircularDeque {
	def main(args: Array[String]): Unit = {
		var obj = new MyCircularDeque(10)
		var param_1 = obj.insertFront(1)
		var param_2 = obj.insertLast(1)
		var param_3 = obj.deleteFront()
		var param_4 = obj.deleteLast()
		var param_5 = obj.getFront()
		var param_6 = obj.getRear()
		var param_7 = obj.isEmpty()
		var param_8 = obj.isFull()
	}
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */