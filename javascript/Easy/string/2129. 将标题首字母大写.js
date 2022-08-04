/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-22 13:11:57
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-22 13:21:52
 * @FilePath: \leetcode\javascript\Easy\string\2129. 将标题首字母大写.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
如果单词的长度为 1 或者 2 ，所有字母变成小写。
否则，将单词首字母大写，剩余字母变成小写。
请你返回 大写后 的 title 。
 */
/**
 * @param {string} title
 * @return {string}
 */
var capitalizeTitle = function (title) {
    title = title.split(" ")
    for (let i=0;i<title.length;i++) {
        if (title[i].length == 1 || title[i].length == 2) {
            title[i]= title[i].toLowerCase()
        }
        else {
            title[i]= title[i][0].toUpperCase() + title[i].slice(1).toLowerCase()
            
        }
    }
    return title.join(" ")
};
console.log(capitalizeTitle("capiTalIze tHe titLe"));