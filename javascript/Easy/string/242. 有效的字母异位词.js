/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-19 16:13:04
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-19 16:17:16
 * @FilePath: \leetcode\javascript\Easy\string\242. 有效的字母异位词.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 var isAnagram = function(s, t) {
    return s.length == t.length && [...s].sort().join('') === [...t].sort().join('')
};
    console.log(isAnagram("anagram", "nagaram"));