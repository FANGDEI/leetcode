package main

func main() {}

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	result := [][]int{}
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		length := len(queue)
		temp := []int{}
		for length > 0 {
			first := queue[0]
			queue = queue[1:]
			temp = append(temp, first.Val)
			if first.Left != nil {
				queue = append(queue, first.Left)
			}
			if first.Right != nil {
				queue = append(queue, first.Right)
			}
			length--
		}
		result = append(result, temp)
	}
	return result
}
