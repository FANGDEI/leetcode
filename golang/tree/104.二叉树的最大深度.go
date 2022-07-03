package tree

import (
	"leetcode/tools"
)

// 水题
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return tools.Max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}
