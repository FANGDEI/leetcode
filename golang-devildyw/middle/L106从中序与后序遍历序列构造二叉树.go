package main

func main() {}

func buildTreeByPost(inorder []int, postorder []int) *TreeNode {
	if len(inorder) == 0 {
		return nil
	}
	rootNum := postorder[len(postorder)-1]
	root := &TreeNode{
		Val:   rootNum,
		Left:  nil,
		Right: nil,
	}
	// 自顶向下
	// 找关系 根在后序遍历的最后一个位置 通过找到根 就知道这个根在中序数组的那个位置了 中序数组根的左右分别就是左子树和右子树 这样问题就解决了
	index := 0
	for ; index < len(inorder); index++ {
		if inorder[index] == rootNum {
			break
		}
	}
	root.Left = buildTree(inorder[:index], postorder[:index])
	root.Right = buildTree(inorder[index+1:], postorder[index:len(postorder)-1])
	return root
}
