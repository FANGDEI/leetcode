package main

import "math"

func main() {}

func countNodes(root *TreeNode) int {
	l := root
	r := root
	hl, hr := 0, 0
	for l != nil {
		l = l.Left
		hl++
	}

	for r != nil {
		r = r.Right
		hr++
	}

	if hr == hl {
		return int(math.Pow(2.0, float64(hr))) - 1
	}

	return 1 + countNodes(root.Left) + countNodes(root.Right)
}
