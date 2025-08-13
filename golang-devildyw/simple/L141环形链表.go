package main

func main() {

}

func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}

	fast, slow := head, head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			return true
		}
	}
	return false
}
