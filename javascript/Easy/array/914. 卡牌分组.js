/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-01 17:18:16
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-01 18:56:21
 * @FilePath: \leetcode\javascript\Easy\array\914. 卡牌分组.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
 */
var hasGroupsSizeX = function (deck) {
    if (!deck.length || deck.length === 1) return false;
    let obj = {};
    for (let i of deck) {
      obj[i] = !obj[i] ? 1 : ++obj[i];
    }
    const sizeArr = Object.values(obj);
    const minSize = Math.min.apply(null, sizeArr);
    for (let i = 2; i <= minSize; i++) {
      if (sizeArr.every(key => !(key % i))) return true;
    }
    return false;
  };
