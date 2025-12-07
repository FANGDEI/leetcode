package main

func main() {

}

func maxDepth(root *TreeNode) int {
	// 将大的问题拆解为子问题 通过递归解决 需要找到最小子问题 并根据其进行自下而上的演进
	if root == nil {
		return 0
	}

	return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}
