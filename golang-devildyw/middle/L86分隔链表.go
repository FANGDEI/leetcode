package main

func main() {

}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
	// 用两个链表头节点来搞
	dummyNode := &ListNode{
		Val:  -1,
		Next: head,
	}

	cur := dummyNode.Next
	pre := dummyNode

	great := &ListNode{
		Val:  -1,
		Next: nil,
	}

	greatCur := great
	// 让cur遍历 让原来的链表上只保留 小于x的节点
	// great 上只保留大于等于的节点
	for cur != nil {
		if cur.Val < x {
			pre.Next = cur
			pre = pre.Next

		} else {
			// 先断开节点
			greatCur.Next = cur
			greatCur = greatCur.Next
		}
		cur = cur.Next
	}

	greatCur.Next = nil

	// 最后拼接起来就行了 pre接上即可
	pre.Next = great.Next
	return dummyNode.Next
}
