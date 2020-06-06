/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */

object SortList {

	def sortedMerge(left: ListNode, right: ListNode): ListNode = {
		var result: ListNode = null

		if (left == null) {
			right
		} else if (right == null) {
			left
		} else {
			if (left.x <= right.x) {
				result = left
				result.next = sortedMerge(left.next, right)
			} else {
				result = right
				result.next = sortedMerge(left, right.next)
			}
			result
		}
	}

	def sortList(head: ListNode): ListNode = {
		if (head == null || head.next == null) {
			head
		} else {
			val middle = getMiddle(head)
			val next_of_middle = middle.next

			middle.next = null

			val left = sortList(head)
			val right = sortList(next_of_middle)

			sortedMerge(left, right)
		}
	}

	def getMiddle(head: ListNode): ListNode = {
		if (head == null) {
			head

		} else {
			var slow = head
			var fast = head

			while (fast.next != null && fast.next.next != null) {
				slow = slow.next
				fast = fast.next.next
			}

			slow
		}
	}

}
