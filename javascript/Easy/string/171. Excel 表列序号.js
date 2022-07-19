/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-19 15:40:45
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-19 16:00:34
 * @FilePath: \leetcode\javascript\Easy\string\171. Excel 表列序号.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。 */
/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function (columnTitle) {
    let res=0
    columnTitle=columnTitle.split("")
    for(let i=0;i<columnTitle.length-1;i++){
        res+=(Math.pow(26,columnTitle.length-1-i)*(columnTitle[i].charCodeAt()-"A".charCodeAt()+1))
    }
    return res+columnTitle[columnTitle.length-1].charCodeAt()-"A".charCodeAt()+1
};
console.log(titleToNumber("FXSHRXW"));