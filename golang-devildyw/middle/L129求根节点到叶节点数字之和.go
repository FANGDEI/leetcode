package main

import "fmt"

func main() {}

func sumNumbers(root *TreeNode) int {
	// 果然还是回溯
	if root == nil {
		return 0
	}
	sum := 0
	sumNumbersHelper(root, 0, &sum)
	return sum
}

func sumNumbersHelper(root *TreeNode, cur int, sum *int) {
	if root == nil {
		return
	}

	cur = cur*10 + root.Val

	if root.Left == nil && root.Right == nil {
		fmt.Println("sum=", *sum, "cur=", cur, "root.Val=", root.Val)
		*sum += cur
	}

	sumNumbersHelper(root.Left, cur, sum)
	sumNumbersHelper(root.Right, cur, sum)
}
