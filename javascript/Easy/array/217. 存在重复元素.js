/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-11 15:32:54
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-11 15:43:51
 * @FilePath: \leetcode\javascript\Easy\array\217. 存在重复元素.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。 */
/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var containsDuplicate = function(nums) {
    let map=new Map()
    for(let i=0;i<nums.length;i++){
        if(map.has(nums[i])){
            map.set(nums[i],map.get(nums[i])+1)
            if(map.get(nums[i])>=2){
                return true
            }
        }
        else{
            map.set(nums[i],1)
        }
    }
    return false

};
containsDuplicate([1,2,3,4,2])