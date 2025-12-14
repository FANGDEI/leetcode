package main

func main() {}

func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	result := [][]int{}
	queue := []*TreeNode{root}
	flag := true
	for len(queue) > 0 {
		length := len(queue)
		temp := make([]int, length)
		for i := 0; i < length; i++ {
			first := queue[0]
			queue = queue[1:]
			index := i
			if !flag {
				index = length - 1 - i
			}

			temp[index] = first.Val

			if first.Left != nil {
				queue = append(queue, first.Left)
			}

			if first.Right != nil {
				queue = append(queue, first.Right)
			}
		}
		flag = !flag
		result = append(result, temp)
	}
	return result

}
