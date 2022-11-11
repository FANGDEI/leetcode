/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-04 11:22:29
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-04 18:16:50
 * @FilePath: \leetcode\javascript\Easy\array\1018. 可被 5 整除的二进制前缀.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个二进制数组 nums ( 索引从0开始 )。

我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。

例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false
 */
/**
 * @param {number[]} nums
 * @return {boolean[]}
 */
 var prefixesDivBy5 = function (nums) {
    let now = nums[0]
    nums[0] = nums[0] === 0
    for (let i = 1; i < nums.length; i++) {
      now = (now * 2 + nums[i]) % 10
      nums[i] = now % 5 === 0
    }
    return nums
  };
  