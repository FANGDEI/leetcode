package main

func main() {}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedArrayToBST(nums []int) *TreeNode {
	// 递归 找到数组中间的元素
	// 我们只用构建每颗子树的根即可 因为二叉树的每个子树 或者说叶子节点都可以看作是一个没有子节点的子树
	if len(nums) == 0 {
		return nil
	}

	mid := len(nums) / 2
	Val := nums[mid]

	root := &TreeNode{
		Val: Val,
	}
	// 交给下层去构建子树
	root.Left = sortedArrayToBST(nums[:mid])
	root.Right = sortedArrayToBST(nums[mid+1:])

	return root
}
