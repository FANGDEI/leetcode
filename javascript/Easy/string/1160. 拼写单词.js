/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-23 22:21:38
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-23 22:47:08
 * @FilePath: \leetcode\javascript\Easy\string\1160. 拼写单词.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function (words, chars) {
    let  res = 0
    for (let x of words) {
        let p = 1, arr2 = [...chars]
        for (let y of x) {
            if (arr2.includes(y) == false) {
                p = 0
                break
            }
            else {
                arr2[arr2.indexOf(y)] = ""
            }
        }
        if (p == 1) {
            res += x.length
        }
    }
    return res
};
console.log(countCharacters(["cat", "bt", "hat", "tree"],"atach"));