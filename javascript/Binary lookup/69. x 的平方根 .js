/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-08 21:48:27
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 22:26:26
 * @FilePath: \leetcode\javascript\Binary lookup\69. x 的平方根 .js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 */
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function (x) {
    let l = 0, r = x;
    while (1) {
        console.log(l,r);
        mid=(r+l)/2
        mid=Math.floor(mid)
        if(mid*mid<=x&&(mid+1)*(mid+1)>x){
            return mid
        }
        else if(mid*mid<x){
            l=mid+1
        }
        else{
            r=mid-1
        }
    }
};
console.log(mySqrt(4));
