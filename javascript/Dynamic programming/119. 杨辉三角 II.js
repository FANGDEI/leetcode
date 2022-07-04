/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-02 12:00:17
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-03 23:25:39
 * @FilePath: \leetcode\javascript\Dynamic programming\119. 杨辉三角 II.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。

// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
/**
 * @param {number} rowIndex
 * @return {number[]}
 */
 var getRow = function(numRows) {
    if (numRows < 0) {
        return []
    }
    // 定义二维dp
    
    const dp = []
    for (let i = 1; i <= numRows + 1; i++) {
        dp.push(new Array(i).fill(null))
    }
    console.log(dp)
    // 处理子问题
    // 这不是处理重复子问题吗
    // 这里是把整行都变成1了
    for (let i = 0; i < numRows + 1; i++) {
        for (let j = 0; j <= i; j++) {
            dp[i][0] = 1
            dp[i][j] = 1
        }
    }
    console.log(dp)
    // 处理状态转移方程
    // 递归+记忆化,优化时间复度
    for (let i = 2; i < numRows + 1; i++) {
        for (let j = 1; j < i; j++) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }
    return dp[numRows]
};



/* 版本2，借用别人的看看 */
// 用到了滚动数组，妈的，好几把难

var getRow = function(rowIndex) {
    let res = [1]
    for (let i = 1; i <= rowIndex + 1; i ++) {
        res[i - 1] = 1 // 扩充一位到 length 等于 rowIndex + 1
        for (let j = i - 2; j > 0; j --) { // 从后往前更新数据, 倒数第二位(索引为 length - 2)至第一位 (索引为 1)
            res[j] = res[j - 1] + res[j] // 本位置上一轮值 + 前一位置上一轮值
        }
    }
    return res
};


