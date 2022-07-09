/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-06-11 20:07:53
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 23:05:55
 * @FilePath: \leetcode\javascript\Easy\1021_删除最外层的括号.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。

// 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
// 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

// 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

// 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
/**
 * @param {string} s
 * @return {string}
 */
 var removeOuterParentheses = function(s) {
    
    let str = '';
    let count = 0;
    for(let i = 0; i < s.length; i++){
        if(s[i] === '('){
            count++;
            if(count > 1){
                str += s[i];
            }
        }else{
            count--;
            if(count > 0){
                str += s[i];
            }
        }
    }
    return str;
};
console.log(removeOuterParentheses('(()())(())'));
