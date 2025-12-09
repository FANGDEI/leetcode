package main

func main() {}

func flatten(root *TreeNode) {
	curr := root
	for curr != nil {
		if curr.Left != nil {
			left := curr.Left
			predecessor := left
			// 查找左子树的右子树叶子节点的位置 再把这个节点接到父节点的右节点上
			for predecessor.Right != nil {
				predecessor = predecessor.Right
			}
			// 接上去
			predecessor.Right = curr.Right
			// 左子树变成右子树了
			curr.Left, curr.Right = nil, left
		}
		// 去寻找下一个节点
		curr = curr.Right
	}
}
