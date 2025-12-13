package main

func main() {}

func averageOfLevels(root *TreeNode) []float64 {
	if root == nil {
		return []float64{}
	}

	result := []float64{}
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		length := len(queue)
		sum := 0
		for i := 0; i < length; i++ {
			first := queue[0]
			queue = queue[1:]
			sum += first.Val
			if first.Left != nil {
				queue = append(queue, first.Left)
			}
			if first.Right != nil {
				queue = append(queue, first.Right)
			}
		}
		result = append(result, float64(sum)/float64(length))
	}
	return result
}
