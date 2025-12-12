package main

func main() {}

// 笨方法 构造的时候直接吧树给中序遍历了 这样体现不出二叉搜索树的性质
//type BSTIterator struct {
//	inorder []*TreeNode
//	index   int
//	size    int
//}
//
//
//func Constructor(root *TreeNode) BSTIterator {
//	// 构建时直接使用中序遍历得到序列即可呗
//	temp := []*TreeNode{}
//	tempHelper(root, &temp)
//	return BSTIterator{
//		inorder: temp,
//		index:   0,
//		size:    len(temp),
//	}
//}
//
//
//func (this *BSTIterator) Next() int {
//	node := this.inorder[this.index]
//	this.index = this.index + 1
//	return node.Val
//}
//
//
//func (this *BSTIterator) HasNext() bool {
//	if this.index >= this.size {
//		return false
//	}
//	return true
//}
//
//func tempHelper(root *TreeNode, temp *[]*TreeNode) {
//	if root == nil {
//		return
//	}
//	tempHelper(root.Left, temp)
//	*temp = append(*temp, root)
//	tempHelper(root.Right, temp)
//}

type BSTIterator struct {
	stack []*TreeNode
}

// 二叉搜索树 每一个节点的左子树一定小于当前节点 右子树一定大于当前节点
// 当然可以直接中序得到所有结果再查就行 但是没有利用特性 并且题目要求使用o(h)的空间复杂度 我们可以使用单调栈树的递归 模拟中序遍历 而不是直接先遍历
func Constructor04(root *TreeNode) BSTIterator {
	BSTIterator := BSTIterator{
		stack: []*TreeNode{},
	}
	BSTIterator.pushLeft(root)
	return BSTIterator
}

func (this *BSTIterator) Next() int {
	// 出栈
	node := this.stack[len(this.stack)-1]
	this.stack = this.stack[:len(this.stack)-1]

	//如果当前节点存在右子树 那么就把右子树（一路向左压）
	if node.Right != nil {
		this.pushLeft(node.Right)
	}

	return node.Val
}

func (this *BSTIterator) HasNext() bool {
	return len(this.stack) > 0
}

func (this *BSTIterator) pushLeft(node *TreeNode) {
	for node != nil {
		this.stack = append(this.stack, node)
		node = node.Left
	}
}
