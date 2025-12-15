package main

func main() {}

func kthSmallest(root *TreeNode, k int) int {
	var stack []*TreeNode
	stack = append(stack, pushLeft(root)...)
	result := -1
	for len(stack) > 0 {
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		k--
		if k == 0 {
			result = node.Val
			break
		}

		if node.Right != nil {
			stack = append(stack, pushLeft(node.Right)...)
		}
	}
	return result
}

func pushLeft(root *TreeNode) []*TreeNode {
	var stack []*TreeNode
	for root != nil {
		stack = append(stack, root)
		root = root.Left
	}
	return stack
}
