/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 09:55:53
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 10:03:41
 * @FilePath: \leetcode\javascript\Easy\array\575. 分糖果.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。

医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。

给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
 */
/**
 * @param {number[]} candyType
 * @return {number}
 */
 var distributeCandies = function(candyType) {
    let map=new Map()
    for(let x of candyType){
        if(!map.has(x)){
            map.set(x)
        }
    }
    if(map.size<=candyType.length/2){
        return map.size
    }
    return candyType.length/2
};
console.log(distributeCandies([1,1,2,2,3,3]));