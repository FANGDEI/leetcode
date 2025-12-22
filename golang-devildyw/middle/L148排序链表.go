package main

func main() {}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
	// 归并排序 + 分治 + 分并两个有序链表
	// 初始化 大家都是单个节点 sublength = 1 然后进行两两有序合并得到一个 sublength = 2 的多个有序链表 一直重复这个步骤
	if head == nil {
		return nil
	}

	length := 0
	temp := head
	for temp != nil {
		length++
		temp = temp.Next
	}

	dummyNode := &ListNode{Next: head}
	sublength := 1
	for sublength < length {
		prev, cur := dummyNode, dummyNode.Next
		for cur != nil {
			head1 := cur
			for i := 1; i < sublength && cur.Next != nil; i++ {
				cur = cur.Next
			}
			// 分开两个链表
			head2 := cur.Next
			cur.Next = nil
			cur = head2
			for i := 1; i < sublength && cur != nil && cur.Next != nil; i++ {
				cur = cur.Next
			}

			var next *ListNode
			if cur != nil {
				next = cur.Next
				// 断开
				cur.Next = nil
			}

			prev.Next = merge1(head1, head2)
			for prev.Next != nil {
				prev = prev.Next
			}
			cur = next
		}
		// 倍增 关键
		sublength <<= 1
	}

	return dummyNode.Next
}

func merge1(head1, head2 *ListNode) *ListNode {
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

func sortListNew(head *ListNode) *ListNode {
	// 初始化 大家都是单个节点 sublength = 1 然后进行两两有序合并得到一个 sublength = 2 的多个有序链表 一直重复这个步骤
	if head == nil {
		return nil
	}

	// 求链表的长度
	length := 0
	cur := head
	for cur != nil {
		length++
		cur = cur.Next
	}

	dummyNode := &ListNode{Next: head}
	subLength := 1

	for subLength < length {
		prev, cur := dummyNode, dummyNode.Next
		for cur != nil {
			head1 := cur
			for i := 1; i < subLength && cur != nil && cur.Next != nil; i++ {
				cur = cur.Next
			}

			head2 := cur.Next
			cur.Next = nil
			cur = head2
			for i := 1; i < subLength && cur != nil && cur.Next != nil; i++ {
				cur = cur.Next
			}

			var next *ListNode
			if cur.Next != nil {
				next = cur.Next
				cur.Next = nil
			}

			prev.Next = merge1(head1, head2)

			for prev.Next != nil {
				prev = prev.Next
			}
			cur = next
		}

		// 倍增
		subLength <<= 1
	}

	return dummyNode.Next
}
