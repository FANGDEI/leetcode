package main

func main() {

}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	var (
		lenA, lenB int
		p1         = headA
		p2         = headB
	)

	// 求两个链表长度
	for p1 != nil {
		p1 = p1.Next
		lenA++
	}

	for p2 != nil {
		p2 = p2.Next
		lenB++
	}

	if lenA > lenB {
		n := lenA - lenB
		for ; n > 0; n-- {
			headA = headA.Next
		}
	} else {
		n := lenB - lenA
		for ; n > 0; n-- {
			headB = headB.Next
		}
	}

	p1 = headA
	p2 = headB
	for p1 != nil && p2 != nil {
		if p1 == p2 {
			return p1
		}
		p1 = p1.Next
		p2 = p2.Next
	}

	return nil
}
