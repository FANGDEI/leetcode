/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-21 20:21:47
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-21 20:53:29
 * @FilePath: \leetcode\javascript\Easy\string\290. 单词规律.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
 var wordPattern = function(pattern, s) {
    let map1=new Map()
    let map2=new Map()
    let s2=s.split(" ")
if(pattern.length!=s2.length){
    return false
}
    for(let i=0;i<s2.length;i++){
        if(map1.has(pattern[i])&&map1.get(pattern[i])!=s2[i]||map2.has(s2[i])&&map2.get(s2[i])!=pattern[i])
        return false
        map1.set(pattern[i],s2[i])
        map2.set(s2[i],pattern[i])
    }
    
    return true
};