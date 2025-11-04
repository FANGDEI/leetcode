package main

func main() {

}

// 贪心 我们关心到每一步能到达的最大距离，如果最大距离包含了最后节点 那么就能到达 反之不能
// 因为每一个下标对应数组的值的是当前能走的最大值 你也可以选择走1步 通过这个机制我们可以遍历数组 首先判断经过前面的更新 能够走到当前位置
// 如果能走到当前位置那么就更新能走到的最大位置

// 我们不需要知道“具体跳哪一步”，只需要知道“我目前能跳到的最远位置”是多少。
func canJump(nums []int) bool {
	var maxReach int = 0
	for i := 0; i < len(nums); i++ {
		if i > maxReach {
			return false // 到达不了 在第i个位置断档了 不可能到达最后位置了
		}
		maxReach = max(maxReach, i+nums[i]) // 如果能到达第i位置 那么更新能到达的最大位置
	}
	return true
}
