/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-03 23:29:10
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-03 23:54:31
 * @FilePath: \leetcode\javascript\Dynamic programming\08.01.面试题. 三步问题.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

// 这不经典吗
/**
 * @param {number} n
 * @return {number}
 */
var waysToStep = function (n) {
    if (n === 1) {
        return 1;
    }
    else if (n === 2) {
        return 2;
    }
    else if (n === 3) {
        return 4;
    }
    else {
        return waysToStep(n - 1) + waysToStep(n - 2) + waysToStep(n - 3)
    }
};

console.log(waysToStep(5));


// 这个空间复杂度没有那么好
var waysToStep = function (n) {
    var dp = [0, 1, 2, 4]


    for (let i = 4; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000007
    }

    return dp[n]
}
console.log(waysToStep(5));



/**滚动数组版,最佳
 * @param {number} n
 * @return {number}
 */
var waysToStep = function (n) {
    var p = 0, q = 0, r = 0, s = 1;

    while (n--) {
        p = q;
        q = r;
        r = s;
        s = ((p + q) % 1000000007 + r) % 1000000007;//这里的话是斐波那契数列会更加直观
    }

    return s;
}
console.log(waysToStep(5));
