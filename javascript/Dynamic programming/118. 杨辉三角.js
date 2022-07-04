/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-03 23:05:20
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-03 23:23:08
 * @FilePath: \leetcode\javascript\Dynamic programming\118. 杨辉三角.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。 */
/**
 * @param {number} numRows
 * @return {number[][]}
 */
// 我不信还有人能写滚动数组，哈哈
 var generate = function(numRows) {
    // 首先创建一个二位数组
    let res =[]
    for(let i=0;i<=numRows;i++){
        res.push(new Array(i+1).fill(null))
    }
    // 处理子问题
    // 这里没有重复子问题哦，没有重复计算，只是处理每一行数两边的1
    for(let i=0;i<=numRows;i++){
        res[i][0]=1
        res[i][i]=1
    }
    // 处理状态转移方程
    for(let i=2;i<=numRows;i++){
         for(let j=1;j<=i-1;j++){
            res[i][j]=res[i-1][j-1]+res[i-1][j]
         }
    }
    console.log(res);
};
// 完美复刻，哈哈
generate(3)


// 再来看看大佬的答案，大佬也只能用二维数组
// 简单几行
var generate = function(numRows) {
    if(numRows === 0) return [];
    let triangle = [];
    triangle.push([1]);
    for(let i = 1; i < numRows; i++) {
        let arr = triangle[triangle.length-1];
        let row = [];
        row.push(1);
        for(let j = 1; j < arr.length; j++) {
            row.push(arr[j-1]+arr[j]);
        }
        row.push(1);
        triangle.push(row);
    }
    return triangle;
};

