/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-06-11 20:07:53
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 23:06:37
 * @FilePath: \leetcode\javascript\Easy\array\4_寻找两个正序数组的中位数.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

// 算法的时间复杂度应该为 O(log (m+n)) 。

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    var nums3 = nums1.concat(nums2).sort((a, b) => a - b);
    if (nums3.length % 2 == 0) {
        return (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2;
    }
    else {
        return nums3[Math.floor((nums3.length) / 2)];
    }
};
console.log(findMedianSortedArrays([0, 0, 0, 0, 0],[-1, 0, 0, 0, 0, 0, 1]));