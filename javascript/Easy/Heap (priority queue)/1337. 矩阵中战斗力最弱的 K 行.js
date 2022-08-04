/* 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。

如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */
/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
 var kWeakestRows = function(mat, k) {
    let arr = []
    for (let i = 0; i < mat.length; i++) {
        let left = 0
        let right = mat[i].length
        // 寻找第一个为0的数
        while (left < right) {
            let mid = parseInt((left + (right - left) / 2))
            if (mat[i][mid] === 1) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        let solider = 0
        if (right === mat[i].length) {
            solider = mat[i].length
        } else {
            solider = left
        }
        arr.push([i, solider])
    }
    return arr.sort((a, b) => a[1] - b[1]).map(item => item[0]).slice(0, k)
};
