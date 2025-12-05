package main

func main() {

}

func deleteDuplicates(head *ListNode) *ListNode {
	//虚拟头节点
	dummyNode := &ListNode{
		Val:  -1,
		Next: head,
	}

	cur := dummyNode
	// 满足 cur.Next.val != cur.Next.Next.Val 的时候就可以确认这个cur.Next节点不重复了
	for cur.Next != nil && cur.Next.Next != nil {
		// 如果等于 说明这个节点的值重复 需要删除
		if cur.Next.Val == cur.Next.Next.Val {
			x := cur.Next.Val
			// 在这里删除 直到cur.Next的val不再等于x
			for cur.Next != nil && cur.Next.Val == x {
				cur.Next = cur.Next.Next
			}
			// 删除了x还不能将cur移动 因为删除了x之后 cur.Next.Val还可能是重复的 2 2 3 3 这种情况 所以需要经过不断的循环 直到 cur.Next.Val 不等于 cur.Next.Next.Val
		} else {
			// 满足条件 就可以移动cur了 准备处理下一个节点
			cur = cur.Next
		}
	}
	return dummyNode.Next
}
