package main

func main() {}

func rightSideView(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	result := []int{}
	// 层序遍历 那我就层序遍历呗
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		length := len(queue)
		for length > 0 {
			//出队
			first := queue[0]
			queue = queue[1:]
			if length == 1 {
				result = append(result, first.Val)
			}
			if first.Left != nil {
				queue = append(queue, first.Left)
			}
			if first.Right != nil {
				queue = append(queue, first.Right)
			}
			length--
		}
	}
	return result
}
