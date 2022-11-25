
// /**
//  * @param {number[][]} matrix
//  * @return {void} Do not return anything, modify matrix in-place instead.
//  */
//  var rotate = function(matrix) {
//     let len = matrix.length;  //循环长度
//     for(var i = 0; i < len; i++) {
//         for(var j = 0; j < len; j++) {
//             //因为拆除行，添加到每一列，j控制行的变化，下面这行可以好好捋一下逻辑。控制了旋转后每一行的顺序。
//             matrix[j].splice(matrix[j].length - i, 0, matrix[i][0]); 
//             //将已经旋转的数字清除，由于清除会影响长度变化，所以上一行matrix[i][0]，保持常量。
//             matrix[i].shift();
//         }
//     }
//     return matrix;
// };
var rotate = function(matrix) {
    const n = matrix.length;
    // 水平翻转
    for (let i = 0; i < Math.floor(n / 2); i++) {
        for (let j = 0; j < n; j++) {
            [matrix[i][j], matrix[n - i - 1][j]] = [matrix[n - i - 1][j], matrix[i][j]];
        }
    }
    // 主对角线翻转
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
        }
    }
};
