package middle

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

// 1、快慢指针找到中点（考虑奇数的长度，需要跳过中间点）
// 2、翻转前半部分
// 3、从中点往两边便利
func isPalindrome(head *ListNode) bool {

	fast := head
	slow := head
	var pre *ListNode

	for fast != nil && fast.Next != nil {
		// 走两步
		fast = fast.Next.Next

		tmp := slow.Next
		slow.Next = pre
		pre = slow
		slow = tmp
	}
	if pre == nil {
		return true
	}

	if fast != nil {
		slow = slow.Next
	}

	// 向前遍历
	for pre != nil && slow != nil {
		if pre.Val != slow.Val {
			return false
		}
		pre = pre.Next
		slow = slow.Next
	}
	return true
}
