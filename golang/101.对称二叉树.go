package golang

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 水题
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return is(root.Left, root.Right)
}

func is(l, r *TreeNode) bool {
	if l == nil && r == nil {
		return true
	}
	if l == nil || r == nil || l.Val != r.Val {
		return false
	}
	return is(l.Left, r.Right) && is(l.Right, r.Left)
}
