/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-08 22:50:26
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 23:04:46
 * @FilePath: \leetcode\javascript\Easy\string\58. 最后一个单词的长度.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

/* 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 */
/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLastWord = function(s) {
    let sum=0
    for(let i=s.length-1;i>=0;i--){
        if(s[i]!=" "){
            sum++
        }
        else{
            if(sum==0){
                continue
            }
            return sum
        }
    }
    return sum
};

