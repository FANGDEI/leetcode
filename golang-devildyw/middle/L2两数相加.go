package main

func main() {
	l1 := &ListNode{
		Val: 2,
		Next: &ListNode{
			Val: 4,
			Next: &ListNode{
				Val:  3,
				Next: nil,
			},
		},
	}
	l2 := &ListNode{
		Val: 5,
		Next: &ListNode{
			Val: 6,
			Next: &ListNode{
				Val: 4,
			},
		},
	}

	addTwoNumbers(l1, l2)

}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	mod := 0

	result := &ListNode{
		Val:  0,
		Next: nil,
	}
	cur := result

	p1, p2 := l1, l2
	for p1 != nil || p2 != nil || mod != 0 {
		val1 := 0
		val2 := 0
		if p1 != nil {
			val1 = p1.Val
		}
		if p2 != nil {
			val2 = p2.Val
		}

		temp := val1 + val2 + mod
		res := temp % 10
		mod = temp / 10

		cur.Next = &ListNode{
			Val:  res,
			Next: nil,
		}
		cur = cur.Next

		if p1 != nil {
			p1 = p1.Next
		}

		if p2 != nil {
			p2 = p2.Next
		}
	}

	return result.Next
}
