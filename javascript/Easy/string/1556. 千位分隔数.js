/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-22 11:43:37
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-22 13:03:28
 * @FilePath: \leetcode\javascript\Easy\string\1556. 千位分隔数.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。 */
/**
 * @param {number} n
 * @return {string}
 */
/**
 * @param {number} n
 * @return {string}
 */
 // 解法一：利用正则
 var thousandSeparator = function(n) {
    return (n).toLocaleString().replace(/\,/g, '.')
};
