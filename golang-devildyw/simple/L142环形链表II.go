package main

func main() {
	l := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val:  2,
			Next: nil,
		},
	}

	println(detectCycle(l))
}

/*
快慢指针 fast 指针每次走两格 slow指针每次走1格 也就是fast走的长度永远是slow的两倍
1.当slow指针到达入环口时 slow走的长度记为a fast走了的长度就为2a
2.当slow在环里与fast第一次相交时 入环口到相交点的距离为b
3.相交点到入环口的距离 记录为c  b+c即为环的长度

fast指针肯定比slow指针多走了n圈即有等式 且fast指针走的长度是slow的两倍即有 (a + b) * 2 = a + b + n * (b + c)
并且fast指针肯定比slow指针快所以在环内至少走了一圈以上 也就是n>=1
a+b = (n-1)(b+c) + (b+c) --> a = (n-1)(b+c) + c
带入 n = 1
得到 a = c
所以在起点走和相遇点同时走 最终相遇的地方就是入口
*/
func detectCycle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	var (
		fast, slow = head, head
	)

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		// 说明有环
		if fast == slow {
			break
		}
	}

	if slow != fast {
		return nil
	}

	fast = head
	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}

	return slow

}
