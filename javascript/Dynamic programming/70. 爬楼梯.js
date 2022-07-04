
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-02 09:38:47
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-02 11:26:59
 * @FilePath: \leetcode\javascript\Dynamic programming\70. 爬楼梯.js
 */

/**
 * @param {number} n
 * @return {number}
 */

 var climbStairs = function(n) {
    let p = 0, q = 0, r = 1;    //滚动数组，优化空间复杂度
    //减小计算重复项，优化时间复杂度
    for (let i = 1; i <= n; ++i) {
        p = q;
        q = r;
        r = p + q;
    }
    return r;
};


console.log(climbStairs[1]);