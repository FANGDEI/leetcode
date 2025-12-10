package main

func main() {}

func hasPathSum(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}
	sum := 0
	return hasPathSumHelper(root, sum, targetSum)
}

func hasPathSumHelper(root *TreeNode, sum int, targetSum int) bool {
	if root == nil {
		return false
	}

	sum = sum + root.Val

	// 遇到叶子节点 返回
	if root.Left == nil && root.Right == nil {
		return sum == targetSum
	}
	// 不是叶子节点 继续往左子树和右子树遍历
	return hasPathSumHelper(root.Left, sum, targetSum) || hasPathSumHelper(root.Right, sum, targetSum)
}
