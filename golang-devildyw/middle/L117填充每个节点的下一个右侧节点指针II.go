package main

func main() {}

func connect(root *Node) *Node {
	if root == nil {
		return root
	}

	// 层序遍历
	// 用slice 模拟队列
	queue := []*Node{root}

	for len(queue) > 0 {
		length := len(queue)
		for i := 0; i < length; i++ {
			// 出队
			node1 := queue[0]
			queue = queue[1:]
			if i+1 < length {
				node2 := queue[0]
				node1.Next = node2
			}

			// 把node1的left和right 按顺序装入queue
			if node1.Left != nil {
				queue = append(queue, node1.Left)
			}

			if node1.Right != nil {
				queue = append(queue, node1.Right)
			}
		}
	}

	return root
}
