/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 13:37:53
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 14:00:21
 * @FilePath: \leetcode\javascript\Easy\array\953. 验证外星语词典.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。

给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 */
/**
 * @param {string[]} words
 * @param {string} order
 * @return {boolean}
 */
 var isAlienSorted = function(words, order) {
    const index = new Array(26).fill(0);
    for (let i = 0; i < order.length; ++i) {
        index[order[i].charCodeAt() - 'a'.charCodeAt()] = i;
    }
    for (let i = 1; i < words.length; i++) {
        let valid = false;
        for (let j = 0; j < words[i - 1].length && j < words[i].length; j++) {
            let prev = index[words[i - 1][j].charCodeAt() - 'a'.charCodeAt()];
            let curr = index[words[i][j].charCodeAt() - 'a'.charCodeAt()];
            if (prev < curr) {
                valid = true;
                break;
            } else if (prev > curr) {
                return false;
            }
        }
        if (!valid) {
            /* 比较两个字符串的长度 */
            if (words[i - 1].length > words[i].length) {
                return false;
            }
        }
    }
    return true;
};