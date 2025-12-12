package main

func main() {}

//func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//	if root == nil {
//		return nil
//	}
//	// 当前节点等于任意一个子节点值都立即返回 因为在往下就不是他们的公共父节点了 不再往下找
//	if root.Val == p.Val || root.Val == q.Val {
//		return root
//	}
//
//	// 在左右节点分别找找 q p 在不在
//	left := lowestCommonAncestor(root.Left, p, q)
//	right := lowestCommonAncestor(root.Right, p, q)
//	// 如果左右都包含一个子节点 那么一定是p q 在当前节点的左右两边 当前节点就是他们的最近公共祖先
//	if left != nil && right != nil {
//		// 返回当前节点 当前节点就是他们的公共子节点
//		return root
//	}
//
//	// 要么两边都没有那么直接返回nil即可 在左右两颗子树中都没找到q p 说明就不在当前节点为根树下面
//	if left == nil && right == nil {
//		return nil
//	}
//
//	// 反之 某一边有值 说明pq 两个节点在left 或者right里 并且左右子树返回的结果就是他们的公共祖先了
//	if left == nil {
//		return right
//	}
//	return left
//}

func lowestCommonAncestorNew01(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	if root.Val == p.Val || root.Val == q.Val {
		return root
	}

	left := lowestCommonAncestorNew01(root.Left, p, q)
	right := lowestCommonAncestorNew01(root.Right, p, q)

	if left != nil && right != nil {
		return root
	}

	if left == nil && right == nil {
		return nil
	}

	if left == nil {
		return right
	}
	return left
}
