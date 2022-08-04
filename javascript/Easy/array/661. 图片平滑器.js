/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-27 18:18:25
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 09:53:37
 * @FilePath: \leetcode\javascript\Easy\array\661. 图片平滑器.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 */
/**
 * @param {number[][]} img
 * @return {number[][]}
 */
 var imageSmoother = function(img) {
    const m = img.length, n = img[0].length;
    const ret = new Array(m).fill(0).map(() => new Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let num = 0, sum = 0;
            for (let x = i - 1; x <= i + 1; x++) {
                for (let y = j - 1; y <= j + 1; y++) {
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        num++;
                        sum += img[x][y];
                    }
                }
            }
            ret[i][j] = Math.floor(sum / num);
        }
    }
    return ret;
};