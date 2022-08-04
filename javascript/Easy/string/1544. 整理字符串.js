/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-22 11:06:18
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-22 11:16:34
 * @FilePath: \leetcode\javascript\Easy\string\1544. 整理字符串.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个由大小写英文字母组成的字符串 s 。
一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。 */
/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function (s) {
    const len = s.length;
    const ret = [];
    let i = 0;
    while (i < len) {
        if (ret.length > 0
            && ret[ret.length - 1].toLowerCase() === s.charAt(i).toLowerCase()
            && ret[ret.length - 1] !== s.charAt(i)
        ) {
            ret.pop();
        } else {
            ret.push(s.charAt(i));
        }
        i += 1;
    }
    return ret.join('');
};
