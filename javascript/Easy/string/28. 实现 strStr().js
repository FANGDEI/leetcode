/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-06 23:31:43
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 22:42:42
 * @FilePath: \leetcode\javascript\Easy\string\28. 实现 strStr().js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

/* 实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 */
/**手写KMP
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
 var strStr = function(haystack, needle) {
    return haystack.indexOf(needle)
};
console.log(strStr("strjl","ppp"));