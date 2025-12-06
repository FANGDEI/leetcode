package main

import "fmt"

func main() {

}

func rotateRight(head *ListNode, k int) *ListNode {

	// 遍历整个链表得到链表长度
	dummyNode := &ListNode{
		Val:  -1,
		Next: head,
	}

	len := 0
	cur := dummyNode.Next
	for cur != nil {
		len++
		cur = cur.Next
	}

	if len == 0 {
		return nil
	}
	// 让k与len取模
	k = k % len

	// 如果取模后 k 为0 那么根本没必要旋转
	if k == 0 {
		return head
	}

	// 参考删除倒数第k个节点的方式 找到倒数第k个节点前的位置
	cur = dummyNode.Next
	pre := dummyNode
	for cur != nil && k != 0 {
		k--
		cur = cur.Next
	}
	fmt.Println("cur:", cur.Val)

	p := cur
	for cur != nil {
		pre = pre.Next
		cur = cur.Next
		if p.Next != nil {
			p = p.Next
		}
	}
	fmt.Println("pre:", pre.Val)
	fmt.Println("p:", p.Val)
	// 现在pre在倒数第k个节点前的位置
	// 把这段切断 并且接到头上去
	newHead := pre.Next
	pre.Next = nil

	// 再把新头的结尾节到原来的头上去
	p.Next = dummyNode.Next
	dummyNode.Next = newHead

	return dummyNode.Next
}
