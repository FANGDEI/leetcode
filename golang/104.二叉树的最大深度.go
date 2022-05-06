package golang

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 水题
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return Max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
