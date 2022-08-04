/* 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
给定一个数组 nums 代表了集合 S 发生错误后的结果。
请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var findErrorNums = function(nums) {
    const errorNums = new Array(2).fill(0);
    const n = nums.length;
    const map = new Map();
    for (const num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    for (let i = 1; i <= n; i++) {
        const count = map.get(i) || 0;
        if (count === 2) {
            errorNums[0] = i;
        } else if (count === 0) {
            errorNums[1] = i;
        }
    }
    return errorNums;
};