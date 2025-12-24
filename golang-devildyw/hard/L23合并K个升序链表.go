package main

func main() {}

func mergeKLists(lists []*ListNode) *ListNode {
	n := len(lists)
	if n <= 0 {
		return nil
	}

	for n > 1 {
		index := 0
		for i := 0; i < n; i = i + 2 {
			if i+2 > n {
				lists[index] = lists[i]
			} else {
				newHead := merge(lists[i], lists[i+1])
				lists[index] = newHead
			}
			index++
		}
		n = index
	}
	return lists[0]
}

func merge(head1 *ListNode, head2 *ListNode) *ListNode {
	dummyNode := &ListNode{}
	cur := dummyNode
	for head1 != nil && head2 != nil {
		if head1.Val <= head2.Val {
			cur.Next = head1
			head1 = head1.Next
		} else {
			cur.Next = head2
			head2 = head2.Next
		}
		cur = cur.Next
	}

	if head1 != nil {
		cur.Next = head1
	}
	if head2 != nil {
		cur.Next = head2
	}

	return dummyNode.Next
}
