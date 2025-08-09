package main

func main() {

}

func swapPairs(head *ListNode) *ListNode {

	var (
		dummyNode = &ListNode{
			Next: head,
		}
		cur = dummyNode
	)

	// 画图模拟即可
	for cur.Next != nil && cur.Next.Next != nil {
		tempNext := cur.Next
		tempNext1 := cur.Next.Next.Next
		cur.Next = cur.Next.Next
		cur.Next.Next = tempNext
		tempNext.Next = tempNext1
		cur = tempNext
	}

	return dummyNode.Next
}
