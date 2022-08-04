/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-06-12 17:32:22
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 23:05:40
 * @FilePath: \leetcode\javascript\Easy\14. 最长公共前缀.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 编写一个函数来查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。
function longestCommonPrefix(strs) {
    if(strs.length===1)
    return strs[0]
    let minl=201;
    for(x of strs){
        x.length<minl?minl=x.length:1
    }
    let olds = "1", s = strs[0][0]
    let tag = 1
    while (1) {
        for (let t = 0; t < strs.length; t++) {
            if (s !== strs[t].slice(0, tag))
                return olds
        }
        if(s.length===minl){
            return s
        }
        tag++
        olds = s
        s = strs[0].slice(0, tag)

    }
};
console.log(longestCommonPrefix(['dfdsf','dfdsf','dfdsf']));