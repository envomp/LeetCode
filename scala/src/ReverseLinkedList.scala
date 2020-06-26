/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */

object ReverseLinkedList {
	def reverseList(head: ListNode): ListNode = {

		if (head == null || head.next == null) {
			head
		} else {
			val p = reverseList(head.next)

			head.next.next = head
			head.next = null
			p

		}

	}
}
