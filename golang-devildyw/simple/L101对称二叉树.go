package main

func main() {

}

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	// 还是老样子 将大的问题拆解为小的问题 轴对称图形 就需要轴两边对称位置的值是否一致了 自顶向下去比较
	// 现有函数结构肯定不太适用了 需要借助一个辅助函数

	return isSymmetricHelper(root, root)

}

func isSymmetricHelper(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}

	if left == nil || right == nil {
		return false
	}

	return left.Val == right.Val && isSymmetricHelper(left.Left, right.Right) && isSymmetricHelper(left.Right, right.Left)

}
