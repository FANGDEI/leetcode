package golang

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// dfs即可
// 判断当前节点是否是叶子节点并且 sum 为 targetSum 即可返回 true
// 若当前节点为 nil 则说明到达叶子节点之后 sum 不等于 targetSum 返回 false
func hasPathSum(root *TreeNode, targetSum int) bool {
	return dfs(root, targetSum, 0)
}

func dfs(root *TreeNode, targetSum, sum int) bool {
	// 节点为空说明已经过了叶子节点且到达叶子节点时 sum != targetSum 返回 false
	if root == nil {
		return false
	}
	sum += root.Val
	// 当前节点是叶子节点且 sum == targetSum 返回 true
	if root.Left == nil && root.Right == nil && targetSum == sum {
		return true
	}
	// 当前节点不是叶子节点
	return dfs(root.Left, targetSum, sum) || dfs(root.Right, targetSum, sum)
}
