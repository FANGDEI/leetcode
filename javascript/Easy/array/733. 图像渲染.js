/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-30 09:38:39
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-30 10:15:03
 * @FilePath: \leetcode\javascript\Easy\array\733. 图像渲染.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。

你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。

为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。

最后返回 经过上色渲染后的图像 。
 */
/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
 var floodFill = function (image, sr, sc, color) {
    if(image[sr][sc]==color){
        return image
    }
    let p = image[sr][sc]
    image[sr][sc] = color
    var ranse = function (r, c) {
        if (r + 1 < image.length && image[r + 1][c] == p) {
            image[r + 1][c] = color
            ranse(r + 1, c)
        }
        if (r - 1 >= 0 && image[r - 1][c] == p) {
            image[r - 1][c] = color
            ranse(r - 1, c)
        } if (c - 1 >= 0 && image[r][c - 1] == p) {
            image[r][c - 1] = color
            ranse(r, c - 1)
        } if (c + 1 < image[0].length && image[r][c + 1] == p) {
            image[r][c + 1] = color
            ranse(r, c + 1)
        }
    }
    ranse(sr, sc)
    return image
};
console.log(floodFill([[1, 1, 1], [1, 1, 0], [1, 0, 1]], 1
    , 1
    , 2));