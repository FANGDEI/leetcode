package main

func main() {

}

func reverseKGroup(head *ListNode, k int) *ListNode {
	dummyNode := &ListNode{
		Val:  0,
		Next: head,
	}
	// 参考反转链表II的思路 找到要反转的区间 这里相当于每k为一组 也就是一个区间 我们只需要找到k个反转就行
	pre := dummyNode
	rightNode := dummyNode
	for {
		// 找到right节点
		for i := 0; i < k && rightNode != nil; i++ {
			rightNode = rightNode.Next
		}
		// 这里相当于不足k个 那就跳出
		if rightNode == nil {
			break
		}
		// 找到区间 并且切断
		leftNode := pre.Next
		tail := rightNode.Next
		pre.Next = nil
		rightNode.Next = nil

		// 对这组进行反转
		reverseLinkedList(leftNode)

		// 反转后连起来
		pre.Next = rightNode
		leftNode.Next = tail

		// 继续找下一个区间 重复这个步骤
		pre = leftNode
		rightNode = leftNode
	}
	return dummyNode.Next
}

func reverseLinkedList(head *ListNode) *ListNode {
	var tail *ListNode
	cur := head
	for cur != nil {
		next := cur.Next
		cur.Next = tail
		tail = cur
		cur = next
	}
	return tail
}
