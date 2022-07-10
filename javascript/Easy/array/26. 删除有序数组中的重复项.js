/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-09 11:45:56
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-10 16:26:20
 * @FilePath: \leetcode\javascript\Easy\array\26. 删除有序数组中的重复项.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
将最终结果插入 nums 的前 k 个位置后返回 k 。
不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 */
/**
 * @param {number[]} nums
 * @return {number}
 */
// 双指针
var removeDuplicates = function (nums) {
    let s = 0
    for (let i = 1; i < nums.length; i++) {
        if (nums[s] != nums[i]){
            s++
            nums[s]=nums[i]
        }
    }
    return s+1
};