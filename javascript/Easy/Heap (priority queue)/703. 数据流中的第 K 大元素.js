/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-25 23:00:12
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-25 23:06:45
 * @FilePath: \leetcode\javascript\Easy\Heap (priority queue)\703. 数据流中的第 K 大元素.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

请实现 KthLargest 类：

KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
/**
 * @param {number} k
 * @param {number[]} nums
 */
 var KthLargest = function(k, nums) {
    this.k=k
    this.nums=nums
};

/** 
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {
    nums.push(val)
    nums.sort((a,b)=>a-b)
    return nums[k-1]
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */