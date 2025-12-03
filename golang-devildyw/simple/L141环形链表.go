package main

func main() {

}

func hasCycleTwoPoint(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	slow, fast := head, head.Next
	for fast != nil && fast.Next != nil {
		if slow == fast {
			return true
		}
		slow, fast = slow.Next, fast.Next.Next
	}
	return false
}
func hasCycleHash(head *ListNode) bool {
	m := make(map[*ListNode]bool)

	for head != nil {
		if exist := m[head]; exist {
			return true
		}
		m[head] = true
		head = head.Next
	}

	return false
}
