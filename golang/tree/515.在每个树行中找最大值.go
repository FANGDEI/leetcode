package tree

import (
	"leetcode/tools"
	"math"
)

// dfs
// 本质是二叉树的后续遍历
func largestValues(root *TreeNode) []int {
	res := []int{}
	var dfs func(cur *TreeNode, depth int)
	dfs = func(cur *TreeNode, depth int) {
		if cur == nil {
			return
		}

		dfs(cur.Left, depth+1)
		dfs(cur.Right, depth+1)

		for depth >= len(res) {
			res = append(res, math.MinInt32)
		}

		res[depth] = tools.Max(res[depth], cur.Val)
	}
	dfs(root, 0)
	return res
}
