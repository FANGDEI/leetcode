package main

func main() {
	listnode := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 6,
				Next: &ListNode{
					Val: 3,
					Next: &ListNode{
						Val: 4,
						Next: &ListNode{
							Val: 5,
							Next: &ListNode{
								Val: 6,
							},
						},
					},
				},
			},
		},
	}

	removeElements(listnode, 6)
}

func removeElements(head *ListNode, val int) *ListNode {
	// 遍历 删除
	// 防止删除的是头指针 这里使用一个匿名节点
	dummyNode := &ListNode{
		Next: head,
		Val:  -1,
	}

	var pre = dummyNode
	var p = dummyNode.Next
	for p != nil {
		if p.Val == val {
			pre.Next = p.Next
			p.Next = nil
			p = pre.Next
		} else {
			p = p.Next
			pre = pre.Next
		}
	}
	return dummyNode.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}
