package middle

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// 递归，从底往上找
// 返回场景1: 找到p或者q
// 返回场景2: 找到底了
// 返回场景3: 如果左右子节点都找到了，这时候直接返回root
// 返回场景4: 返回不为空的一个子节点
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {

	if root == p || root == q || root == nil {
		return root
	}

	leftResult := lowestCommonAncestor(root.Left, p, q)
	rightResult := lowestCommonAncestor(root.Right, p, q)

	if rightResult != nil && leftResult != nil {
		return root
	}

	if leftResult != nil {
		return leftResult
	}
	return rightResult
}
