package simple

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	nodeA, nodeB := headA, headB

	// 遍历两遍以内，直到这两个节点相等
	for nodeA != nodeB {
		// A链表
		if nodeA == nil {
			nodeA = headB
		} else {
			nodeA = nodeA.Next
		}
		// B链表
		if nodeB == nil {
			nodeB = headA
		} else {
			nodeB = nodeB.Next
		}
	}

	return nodeA
}
