/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-29 14:24:14
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-29 14:25:25
 * @FilePath: \leetcode\javascript\Easy\array\349. 两个数组的交集.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
 var intersection = function(nums1, nums2) {
    let res=[]
    for(let x of nums1){
        if(nums2.indexOf(x)!=-1){
            res.push(x)
        }
    }
    return res
};