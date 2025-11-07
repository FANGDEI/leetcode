package main

func main() {
	canCompleteCircuit([]int{5, 8, 2, 8}, []int{6, 5, 6, 6})
}

// 规律一：只要整圈的总油量 ≥ 整圈的总消耗，就一定能绕一圈 （这个我发现了）
// 规律二：一旦油箱在某点变成负数，从“起点”到这个点的所有站，都不可能作为真正的起点（这个没发现，但应该能发现的，对贪心还停留在找最大和最小上）
func canCompleteCircuit(gas []int, cost []int) int {
	var (
		total = 0 // 剩余油
		tank  = 0 // 当前的油
		start = 0 // 可能的起点
	)

	for i := 0; i < len(gas); i++ {
		gain := gas[i] - cost[i]
		total += gain
		tank += gain
		if tank < 0 {
			// 如果到当前点 当前油箱已为空那么当前节点之前（包括当前节点都不可能是起点）
			// 更换起点
			start = i + 1
			tank = 0
		}
	}

	if total < 0 {
		return -1
	}
	return start
}
