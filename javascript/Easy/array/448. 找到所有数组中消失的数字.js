/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 22:48:39
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 23:00:37
 * @FilePath: \leetcode\javascript\Easy\array\448. 找到所有数组中消失的数字.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var findDisappearedNumbers = function(nums) {
    let res=[]
    for(let i=1;i<nums.length+1;i++){
        if(nums.indexOf(i)==-1){
            res.push(i)
        }
    }
    return res
};