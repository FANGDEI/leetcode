package main

func main() {
	var head = &ListNode{
		Val:  1,
		Next: nil,
	}
	removeNthFromEnd(head, 1)
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	var (
		dummyHead = &ListNode{
			Next: head,
		}
		pre, cur = dummyHead, dummyHead
	)

	for pre != nil && n > 0 {
		pre = pre.Next
		n--
	}

	for pre != nil && pre.Next != nil {
		pre = pre.Next
		cur = cur.Next
	}

	cur.Next = cur.Next.Next

	return dummyHead.Next
}
