/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-10 17:28:35
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-10 17:44:21
 * @FilePath: \leetcode\javascript\Easy\array\66. 加一.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。 */
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
    var plus = function (i) {
        if (digits[i] < 9) {
            digits[i] += 1
        }
        else {

            digits[i] = 0
            if (i > 0)
                plus(i - 1)
        }
    }

    plus(digits.length - 1)
    if (digits[0] == 0) {
        digits.unshift(1)

    }
    return digits
};
console.log(plusOne([7, 8]));
