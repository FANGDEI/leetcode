/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-10 15:51:54
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-10 17:21:57
 * @FilePath: \leetcode\javascript\Easy\array\27. 移除元素.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 */
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
 var removeElement = function(nums, val) {
    let ans = 0;
    for(const num of nums) {
        if(num != val) {
            nums[ans] = num;
            ans++;
        }
    }
    return ans;
};
