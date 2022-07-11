/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-10 17:48:08
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-11 14:46:41
 * @FilePath: \leetcode\javascript\Easy\array\169. 多数元素.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

/* 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var majorityElement = function(nums) {
    nums.sort((a, b) => a - b);
    return nums[nums.length >> 1];
};