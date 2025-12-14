package main

import (
	"fmt"
	"math"
)

func main() {}

func getMinimumDifference(root *TreeNode) int {
	ans, pre := math.MaxInt64, -1
	var dfs func(*TreeNode)
	dfs = func(root *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Left)

		if pre == -1 {
			fmt.Println(pre, root.Val)
			pre = root.Val
		} else {
			ans = min(ans, root.Val-pre)
			pre = root.Val
		}
		dfs(root.Right)
	}
	dfs(root)
	return ans
}
