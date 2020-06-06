import scala.util.Random

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */

class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}

class LinkedListRandomNode(_head: ListNode) {
	def getRandom(): Int = {

		var list: List[Int] = List()
		var head = _head

		while (head != null) {

			list ::= head.x
			head = head.next
		}

		list(new Random().nextInt(list.length))

	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(head)
 * var param_1 = obj.getRandom()
 */