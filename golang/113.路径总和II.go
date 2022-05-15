package golang

// 全局变量
var res = [][]int{}

func pathSum(root *TreeNode, targetSum int) [][]int {
	// leetcode 全局变量只会初始化一次
	res = [][]int{}
	nowPath := []int{}
	pathSumDfs(root, nowPath, targetSum, 0)
	return res
}

// 在路径总和I的代码中加一个记录路径的变量即可
func pathSumDfs(root *TreeNode, nowPath []int, targetSum, sum int) {
	if root == nil {
		return
	}
	sum += root.Val
	nowPath = append(nowPath, root.Val)
	defer func() {
		// 回溯
		nowPath = nowPath[:len(nowPath)-1]
	}()
	if root.Left == nil && root.Right == nil && sum == targetSum {
		cp := make([]int, len(nowPath))
		copy(cp, nowPath)
		res = append(res, cp)
		// golang slice 的注意点
		// res = append(res, nowPath)
		return
	}
	pathSumDfs(root.Left, nowPath, targetSum, sum)
	pathSumDfs(root.Right, nowPath, targetSum, sum)
}
