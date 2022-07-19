/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-19 16:02:12
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-19 16:10:10
 * @FilePath: \leetcode\javascript\Easy\string\205. 同构字符串.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定两个字符串 s 和 t ，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 var isIsomorphic = function(s, t) {
    const s2t = {};
    const t2s = {};
    const len = s.length;
    for (let i = 0; i < len; ++i) {
        const x = s[i], y = t[i];
        if ((s2t[x] && s2t[x] !== y) || (t2s[y] && t2s[y] !== x)) {
            return false;
        }
        s2t[x] = y;
        t2s[y] = x;
    }
    return true;
};
    console.log(isIsomorphic("ab", "aa"));