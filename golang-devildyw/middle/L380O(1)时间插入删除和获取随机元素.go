package main

import "math/rand"

func main() {

}

// 使用数组 + 哈希表 使用哈希表虽然能做到 insert + remove O（1） 但是无法做到 random 获取元素 O(1) 而数组能 所以需要混合使用
type RandomizedSet struct {
	nums     []int       // 用来保存数组
	indexMap map[int]int // 用来保存元素与下标的关系
}

func Constructor() RandomizedSet {
	return RandomizedSet{
		nums:     make([]int, 0),
		indexMap: make(map[int]int),
	}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.indexMap[val]; ok {
		return false
	}
	this.nums = append(this.nums, val)
	this.indexMap[val] = len(this.nums) - 1
	return true
}

// O(1) 删除的关键在于 交换 + 删除尾部；
//   - 把最后一个元素换到要删的地方；
//   - 更新它在 map 中的下标；
//   - 删除尾部元素和对应 map 记录。
func (this *RandomizedSet) Remove(val int) bool {
	if idx, ok := this.indexMap[val]; ok {
		// 将最后一个元素与当前元素覆盖当前元素
		last := this.nums[len(this.nums)-1]
		this.nums[idx] = last
		// 再将最后一个元素删除
		this.nums = this.nums[:len(this.nums)-1]
		// 更新元素的下标
		this.indexMap[last] = idx
		// 删除原来的元素在哈希表里面的关系
		delete(this.indexMap, val)
		return true
	}
	return false
}

func (this *RandomizedSet) GetRandom() int {
	return this.nums[rand.Intn(len(this.nums))]
}
