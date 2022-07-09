/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-06-11 20:13:22
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 23:05:44
 * @FilePath: \leetcode\javascript\Easy\20. 有效的括号.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
/**
 * @param {string} s
 * @return {boolean}
 */

var isValid = function (s) {
    let stack = []
    for (var x of s) {
        if (x === '{' || x === '[' || x === '(') {
            console.log(x);
            stack.push(x)
        }

        else if (x === '}' && stack.at(-1) === '{') {
            stack.pop()
            console.log(1);
        }
        else if (x === ']' && stack.at(-1) === '[') {
            stack.pop()
            console.log(2);
        }
        else if (x === ')' && stack.at(-1) === '(') {
            stack.pop()
            console.log(3);
        }
        else { return false }

    }
    console.log(stack);
    if (stack.length===0) {
        return true
    }
    else { return false }
}
console.log(isValid('{{}[}]'));

// var isValid = function(s) {
//     const n = s.length;
//     if (n % 2 === 1) {
//         return false;
//     }
//     const pairs = new Map([
//         [')', '('],
//         [']', '['],
//         ['}', '{']
//     ]);
//     const stk = [];
//     for (let ch of s){
//         if (pairs.has(ch)) {
//             if (!stk.length || stk[stk.length - 1] !== pairs.get(ch)) {
//                 return false;
//             }
//             stk.pop();
//         } 
//         else {
//             stk.push(ch);
//         }
//     };
//     return !stk.length;
// };

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。