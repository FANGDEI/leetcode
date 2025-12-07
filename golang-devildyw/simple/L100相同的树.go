package main

func main() {

}

func isSameTree(p *TreeNode, q *TreeNode) bool {
	// 一样将问题简化为最小子问题再解决 树的遍历嘛 无非就是这样 你不可能去遍历每一个节点的 只能通过这种方式不断解决每一个节点 自底向上
	if p == nil && q == nil {
		return true
	}

	if p == nil || q == nil {
		return false
	}

	// 两个节点都有值 对比一下值是否相同
	return p.Val == q.Val && isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
