/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-22 11:27:05
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-22 11:37:04
 * @FilePath: \leetcode\javascript\Easy\string\1576. 替换所有的问号.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
注意：你 不能 修改非 '?' 字符。
题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。 */
/**
 * @param {string} s
 * @return {string}
 */
 var modifyString = function(s) {
    s.replace("?"," ")
    arr=["a","b","c"]
    s=[...s]
    for(let i=0;i<s.length;i++){
        if(s[i]==" "){
            for(let x of arr){
                if(x!=s[i-1]&&x!=s[i+1]){
                    s[i]=x
                }
            }
        }
    }
    return s.join("")
};