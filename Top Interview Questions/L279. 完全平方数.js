 /**
 * 四平方数之和 + 贪心算法
 * @param {number} n
 * @return {number}
 */
  var numSquares = function (n) {
    //把平方集合求出
    let sqLists = new Set();
    for (let i = 1; i * i <= n; i++) {
        sqLists.add(i * i);
    }
    //根据定律，一个数都能表示成四个数的平方数之和
    //所以count值1,2,3,4这四种情况
    //状态有限用贪心，状态无限用动态规划

    /**
     * 贪心算法判断梳子number是否可以划分为count个数
     */
    var isCanDivide = function (number, count) {
        if (count === 1) {
            return sqLists.has(number)
        }
        for (let s of sqLists) {
            if (isCanDivide(number - s, count - 1)) {
                return true;
            }
        }
        return false;
    }
    //count最大就是4
    let count = 1;
    for (; count <= 4; count++) {
        if (isCanDivide(n, count)) {
            return count;
        }
    }
    return count;
};


// 动态规划
// var numSquares = function(n) {
//     const f = new Array(n + 1).fill(0);
//     for (let i = 1; i <= n; i++) {
//         let minn = Number.MAX_VALUE;
//         for (let j = 1; j * j <= i; j++) {
//             minn = Math.min(minn, f[i - j * j]);
//         }
//         f[i] = minn + 1;
//     }
//     return f[n];
// };

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。