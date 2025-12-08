package main

func invertTree(root *TreeNode) *TreeNode {

	if root == nil {
		return nil
	}

	// 自顶向下 遍历到一层时 先把它的左右子节点交换
	root.Left, root.Right = root.Right, root.Left
	// 再向下
	root.Left = invertTree(root.Left)
	root.Right = invertTree(root.Right)
	return root
}
