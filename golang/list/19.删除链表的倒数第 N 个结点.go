package list

// 快慢指针
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil {
		return nil
	}

	fast, slow := head, head
	for i := 0; i < n; i++ {
		fast = fast.Next
	}
	if fast == nil {
		return head.Next
	}

	for fast.Next != nil {
		fast = fast.Next
		slow = slow.Next
	}
	slow.Next = slow.Next.Next
	return head
}
