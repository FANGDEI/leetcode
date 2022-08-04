/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-26 16:20:20
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-26 16:23:38
 * @FilePath: \leetcode\javascript\Easy\Heap (priority queue)\1046. 最后一块石头的重量.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
/**
 * @param {number[]} stones
 * @return {number}
 */
 var lastStoneWeight = function (stones) {
    stones = stones.sort((a, b) => a - b);
    while (stones.length > 1) {
        const len = stones.length;
        stones[len - 1] = stones[len - 1] - stones[len - 2];
        if (stones[len - 1] === 0){
            stones.splice(len - 2, 2);
        }
        else {
            stones.splice(len - 2, 1);
            stones.sort((a, b) => a - b);
        }
    }
    return stones[0] || 0;
};

