package list

func removeElements(head *ListNode, val int) *ListNode {
	dummy := &ListNode{Next: head}
	for cur := dummy; cur.Next != nil; {
		if cur.Next.Val != val {
			cur = cur.Next
		} else {
			cur.Next = cur.Next.Next
		}
	}
	return dummy.Next
}
