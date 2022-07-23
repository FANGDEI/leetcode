package list

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	pre := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return pre
}
