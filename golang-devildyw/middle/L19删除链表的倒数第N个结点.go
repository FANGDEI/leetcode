package main

func main() {
	var head = &ListNode{
		Val:  1,
		Next: nil,
	}
	removeNthFromEnd(head, 1)
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	// 虚拟节点搞起来
	dummyHead := &ListNode{
		Val:  -1,
		Next: head,
	}
	cur := dummyHead
	pre := dummyHead

	for i := 0; i < n; i++ {
		cur = cur.Next
	}
	// 一定是 cur.Next !=nil 这样遍历下去 pre就会停在需要删除节点的前一个位置 这样刚好方便删除
	for cur.Next != nil {
		cur = cur.Next
		pre = pre.Next
	}

	pre.Next = pre.Next.Next

	return dummyHead.Next
}
