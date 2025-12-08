package main

func main() {

}

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	// 先找到根 从前序遍历中找到
	root := &TreeNode{preorder[0], nil, nil}
	i := 0
	for ; i < len(inorder); i++ {
		if inorder[i] == preorder[0] {
			break
		}
	}
	// 其实就是一个 不断找到根 建立节点 在找他们左右子树去建立根的过程 利用前序遍历 根一定在前 中序遍历根在左子树右边紧靠这层关系来建立树
	// 左子树在中序遍历中的长度 跟在前序遍历中一样
	root.Left = buildTree(preorder[1:len(inorder[:i])+1], inorder[:i])
	root.Right = buildTree(preorder[len(inorder[:i])+1:], inorder[i+1:])
	return root

}

func buildTreeNew(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	root := &TreeNode{preorder[0], nil, nil}
	index := 0
	for ; index < len(inorder); index++ {
		if inorder[index] == preorder[0] {
			break
		}
	}

	root.Left = buildTreeNew(preorder[1:len(inorder[:index])+1], inorder[:index])
	root.Right = buildTreeNew(preorder[len(inorder[:index])+1:], inorder[index+1:])
	return root
}
