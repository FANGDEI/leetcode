package main

func main() {

}

func reverseList(head *ListNode) *ListNode {
	var (
		pre *ListNode = nil
		p             = head
	)

	for p != nil {
		next := p.Next
		p.Next = pre
		pre = p
		p = next
	}
	return pre
}

func reverseList_TwoPointer(head *ListNode) *ListNode {
	var (
		cur *ListNode = nil
		pre           = head
	)

	for pre != nil {
		next := pre.Next
		pre.Next = cur
		cur = pre
		pre = next
	}
	return cur
}
