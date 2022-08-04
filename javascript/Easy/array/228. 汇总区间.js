/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-29 11:26:50
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-29 11:35:25
 * @FilePath: \leetcode\javascript\Easy\array\228. 汇总区间.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个  无重复元素 的 有序 整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b
 */
/**
 * @param {number[]} nums
 * @return {string[]}
 */
 var summaryRanges = function (nums) {
    let res = [], string = ""
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] + 1 == nums[i + 1] && string == "") {
            string += nums[i] + '->'
            while (nums[i] + 1 == nums[i + 1]) {
                i++
            }
            string += nums[i]
            res.push(string)
            string = ""
        }
        else {
            string += nums[i]
            res.push(string)
            string = ""
        }
    }
    return res
};