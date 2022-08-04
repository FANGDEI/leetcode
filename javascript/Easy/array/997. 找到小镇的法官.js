/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 10:48:05
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 11:57:25
 * @FilePath: \leetcode\javascript\Easy\array\997. 找到小镇的法官.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
如果小镇法官真的存在，那么：
小镇法官不会信任任何人。
每个人（除了小镇法官）都信任这位小镇法官。
只有一个人同时满足属性 1 和属性 2 。
给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。

如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 
 */
/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
 var findJudge = function(n, trust) {
    const inDegrees = new Array(n + 1).fill(0);
    const outDegrees = new Array(n + 1).fill(0);
    for (const edge of trust) {
        const x = edge[0], y = edge[1];
        ++inDegrees[y];
        ++outDegrees[x];
    }
    for (let i = 1; i <= n; ++i) {
        if (inDegrees[i] === n - 1 && outDegrees[i] === 0) {
            return i;
        }
    }
    return -1;
};