package main

import "math"

func main() {}

func isValidBST(root *TreeNode) bool {
	pre := math.MinInt64
	var dfs func(*TreeNode) bool
	dfs = func(node *TreeNode) bool {
		if node == nil {
			return true
		}
		leftRelation := dfs(node.Left)
		if pre != math.MinInt64 && node.Val <= pre {
			return false
		}
		pre = node.Val

		rightRelation := dfs(node.Right)
		return rightRelation && leftRelation
	}
	result := dfs(root)
	return result
}
