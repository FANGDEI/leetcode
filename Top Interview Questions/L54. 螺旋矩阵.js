/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function (matrix) {
    let res = [],len=matrix.length*matrix[0].length
    let w = 0, s = matrix.length - 1, a = 0, d = matrix[0].length - 1
    while (w <= s&&a<=d) {
        for (let i = a; i <= d; i++) {
            res.push(matrix[w][i])
        }
        if(res.length==len){
            break;
        }
        w++
        for (let i = w; i <= s; i++) {
            res.push(matrix[i][d])
        }
        if(res.length==len){
            break;
        }
        d--
        for (let i = d; i >= a; i--) {
            res.push(matrix[s][i])
        }
        if(res.length==len){
            break;
        }
        s--

        for (let i = s; i >= w; i--) {
            res.push(matrix[i][a])
        }
        if(res.length==len){
            break;
        }
        a++
    }
    return res

};
console.log(spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]));