package list

// set
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	set := make(map[*ListNode]bool)
	for headA != nil {
		set[headA] = true
		headA = headA.Next
	}

	for headB != nil {
		if set[headB] {
			return headB
		}
		headB = headB.Next
	}
	return nil
}
