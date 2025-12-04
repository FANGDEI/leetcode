package main

func main() {

}

// 切割出需要反转的部分 在使用反转链表的方式进行反转 最后在拼接起来就行
func reverseBetween(head *ListNode, left int, right int) *ListNode {
	// 切断我们需要反转的区间的连表 在使用反转链表的方式 吧他们反转 最后在接起来
	// 需要记录四个点

	// 虚拟头节点
	dummyNode := &ListNode{
		Val:  -1,
		Next: head,
	}

	pre := dummyNode

	// 找到left-1为止
	for i := 0; i < left-1; i++ {
		pre = pre.Next
	}

	// 找到right节点的位置
	rightNode := pre
	for i := 0; i < right-left+1; i++ {
		rightNode = rightNode.Next
	}

	// 切断出需要反转的链表 找到leftNode rightNode 已经找到了 保存一下末尾 一会儿需要拼接
	leftNode := pre.Next
	curr := rightNode.Next
	// 切断
	pre.Next = nil
	rightNode.Next = nil

	reverseLinkedList(leftNode)

	// 拼接
	pre.Next = rightNode
	leftNode.Next = curr
	return dummyNode.Next
}

func reverseLinkedList(head *ListNode) *ListNode {
	var tail *ListNode
	for head != nil {
		next := head.Next
		head.Next = tail
		tail = head
		head = next
	}
	return tail
}
