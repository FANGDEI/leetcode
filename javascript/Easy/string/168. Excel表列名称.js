/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-19 15:30:34
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-19 15:39:08
 * @FilePath: \leetcode\javascript\Easy\string\168. Excel表列名称.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 */
/**
 * @param {number} columnNumber
 * @return {string}
 */
var convertToTitle = function (columnNumber) {
    let result = "";
    while (columnNumber > 0) {
        result = String.fromCharCode((columnNumber - 1) % 26 + "A".charCodeAt()) + result;
        columnNumber = Math.floor((columnNumber - 1) / 26);
    }
    return result;
};
