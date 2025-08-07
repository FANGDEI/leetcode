package main

func main() {
	var myLinkedList = Constructor()
	myLinkedList.DeleteAtIndex(0)
}

type MyLinkedList struct {
	Val  int
	Next *MyLinkedList
}

func Constructor() MyLinkedList {
	dummyNode := MyLinkedList{
		Val:  0,
		Next: nil,
	}
	return dummyNode
}

func (this *MyLinkedList) Get(index int) int {
	p := this.Next
	for index > 0 && p != nil {
		p = p.Next
		index--
	}
	if p == nil {
		return -1
	}
	return p.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	prev := this
	next := this.Next
	prev.Next = &MyLinkedList{
		Val:  val,
		Next: next,
	}
}

func (this *MyLinkedList) AddAtTail(val int) {
	p := this.Next
	if p == nil {
		this.Next = &MyLinkedList{
			Val:  val,
			Next: nil,
		}
		return
	}

	for p.Next != nil {
		p = p.Next
	}

	p.Next = &MyLinkedList{
		Val:  val,
		Next: nil,
	}
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	prev := this
	for index > 0 && prev.Next != nil {
		prev = prev.Next
		index--
	}

	if index != 0 || prev.Next == nil {
		return
	}

	next := prev.Next
	prev.Next = &MyLinkedList{
		Val:  val,
		Next: next,
	}
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	prev := this
	for index > 0 && prev.Next != nil {
		prev = prev.Next
		index--
	}

	if index != 0 || prev.Next == nil {
		return
	}

	next := prev.Next.Next
	prev.Next = next
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
