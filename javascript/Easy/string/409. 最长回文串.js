/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-21 22:24:59
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-21 22:47:54
 * @FilePath: \leetcode\javascript\Easy\string\409. 最长回文串.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 */
/**
 * @param {string} s
 * @return {number}
 */
 var longestPalindrome = function (s) {
    let map = new Map(), ans = 0
    for (let x of s) {
        if (map.has(x)) {
            map.set(x, map.get(x) + 1)
        }
        else {
            map.set(x, 1)
        }
    }
    for (let x of map.values()) {
        ans += Math.floor(x / 2) * 2
        if (x % 2 == 1 && ans % 2 == 0) {
            ans++
        }
    }
    return ans
};
console.log(longestPalindrome("abccccdd"));