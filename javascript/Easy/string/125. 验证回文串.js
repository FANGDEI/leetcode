/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-18 21:05:57
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-18 21:06:05
 * @FilePath: \leetcode\javascript\Easy\string\125. 验证回文串.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。 */
/**
 * @param {string} s
 * @return {boolean}
 */
 var isPalindrome = function(s) {
    s = s.replace(/[^A-Za-z0-9]/g,"").toLowerCase();
    return s === s.split("").reverse().join("");
};