/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-22 10:54:32
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-22 11:04:45
 * @FilePath: \leetcode\javascript\Easy\string\796. 旋转字符串.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。

s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 

例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 */
/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var rotateString = function (s, goal) {
    s = s.split("")
    for (let i = 0; i < s.length; i++) {
        p = s.shift()
        s.push(p)
        if (s.join("") == goal)
            return true
    }
    return false
};
console.log(rotateString("abcde", "cdeab"));