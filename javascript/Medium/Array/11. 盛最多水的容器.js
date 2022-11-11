/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-11 08:59:30
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-11 08:59:39
 * @FilePath: \leetcode\javascript\Medium\Array\11. 盛最多水的容器.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。
 */
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    let left = 0, right = height.length - 1, max = 0
    while (left < right) {
        max = Math.max(max, Math.min(height[left], height[right]) * (right - left))
        console.log(max,left,right,height[left], height[right]);
        if (height[left] <= height[right]) {
            left++
        }
        else {
            right--
        }
    }
    return max
};
maxArea([2, 3, 4, 5, 18, 17, 6])