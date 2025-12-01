package main

func main() {

}

type minStack struct {
	// 辅助栈做法
	stack []int
	// 辅助栈 minStack[i] 只维护 主栈i位置时的最小元素 也就是会出现很多重复的的元素 当主栈i位置pop时 辅助栈i位置也pop
	// 这样就能实现在真正最小值存在时 后续push只会在辅助栈顶插入这个最小值，只有最小值被pop时 才会显示截止目前为止的新的最小值 这样应该能理解吧
	minStack []int
}

func constructor() minStack {
	return minStack{
		stack:    make([]int, 0),
		minStack: make([]int, 0),
	}
}

func (this *minStack) push(val int) {
	this.stack = append(this.stack, val)
	// 在push才去维护这个最小值 具体维护步骤如下
	minNum := 0
	if len(this.minStack) > 0 {
		minNum = min(this.minStack[len(this.minStack)-1], val)
	} else {
		minNum = val
	}
	this.minStack = append(this.minStack, minNum)
}

func (this *minStack) pop() {
	if len(this.stack) > 0 {
		this.stack = this.stack[:len(this.stack)-1]
		this.minStack = this.minStack[:len(this.minStack)-1]
	}
}

func (this *minStack) top() int {
	return this.stack[len(this.stack)-1]
}

func (this *minStack) getMin() int {
	if len(this.minStack) > 0 {
		return this.minStack[len(this.minStack)-1]
	}
	return 0
}
