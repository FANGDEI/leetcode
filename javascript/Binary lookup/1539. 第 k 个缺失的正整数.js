/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-13 16:45:49
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-13 17:10:36
 * @FilePath: \leetcode\javascript\Binary lookup\1539. 第 k 个缺失的正整数.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
请你找到这个数组里第 k 个缺失的正整数。
 */
 /**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var findKthPositive = function(arr, k) {
    let res=0
    while(k>0){
        if(arr.indexOf(res)==-1) k--
        res++
    }
    return res-1
};