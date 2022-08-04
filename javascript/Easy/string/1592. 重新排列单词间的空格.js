/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-23 19:56:06
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-23 21:48:54
 * @FilePath: \leetcode\javascript\Easy\string\1592. 重新排列单词间的空格.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。

请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。

返回 重新排列空格后的字符串 。 */
/**
 * @param {string} text
 * @return {string}
 */
 var reorderSpaces = function(text) {
    if (!text.includes(' ')) return text; // 没有空格 直接返回
    let len = text.match(/ /g).length; // 空格的总数
    let str = text.match(/\w+/g); // 单词的总数
    if (str.length === 1) return str[0] + ' '.repeat(len); // 只有一个单词的话 直接返回
    let c = len / (str.length - 1) | 0, e = len % (str.length - 1);   /*每一个单词中间需要添加几个空格*/
    return str.join(' '.repeat(c)) + ' '.repeat(e); 
};
