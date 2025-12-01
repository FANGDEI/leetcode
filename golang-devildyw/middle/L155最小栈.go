package main

import "math"

func main() {

}

type MinStack struct {
	stack  []int
	minNum int
}

func Constructor2() MinStack {
	return MinStack{
		stack:  make([]int, 0),
		minNum: math.MaxInt32,
	}
}

func (this *MinStack) Push(val int) {
	this.stack = append(this.stack, val)
	this.minNum = updateMin(this.stack)
}

func (this *MinStack) Pop() {
	this.stack = this.stack[:len(this.stack)-1]
	this.minNum = updateMin(this.stack)
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStack) GetMin() int {
	return this.minNum
}

func updateMin(stack []int) int {
	tempMin := math.MaxInt32
	for _, num := range stack {
		tempMin = min(tempMin, num)
	}
	return tempMin
}
