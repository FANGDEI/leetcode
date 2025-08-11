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
		cur = dummyHead
		pre = dummyHead
	)
	// cur.Next!=null 代表遍历到最后一个节点上 cur!=nil 代表遍历到最后一个next 也就是会多一个节点
	for cur.Next != nil && n > 0 {
		cur = cur.Next
		n--
	}

	for cur.Next != nil {
		pre = pre.Next
		cur = cur.Next
	}
	pre.Next = pre.Next.Next

	return dummyHead.Next
}
