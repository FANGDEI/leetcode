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
