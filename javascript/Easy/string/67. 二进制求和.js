/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-09 10:12:25
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-09 11:44:36
 * @FilePath: \leetcode\javascript\Easy\string\67. 二进制求和.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。 */
/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
 var addBinary = function(a, b) {
    let add = 0
    let sum = []
    for(let i = a.length -1, j = b.length -1; i >= 0 || j >= 0; i--, j--) {
        let num1 = +a[i] || 0
        let num2 = +b[j] || 0
        sum.unshift(num1 ^ num2 ^ add)
        add = num1 + num2 + add > 1 ? 1 : 0
        
    }
    if (add === 1) sum.unshift(1)
    return sum.join('')
};
