/* 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
var findShortestSubArray = function(nums) {
    const mp = {};

    for (const [i, num] of nums.entries()) {
        if (num in mp) {
            mp[num][0]++;
            mp[num][2] = i;
        } else {
            mp[num] = [1, i, i];
        }
    }
    
    let maxNum = 0, minLen = 0;
    for (const [count, left, right] of Object.values(mp)) {
        if (maxNum < count) {
            maxNum = count;
            minLen = right - left + 1;
        } else if (maxNum === count) {
            if (minLen > (right - left + 1)) {
                minLen = right - left + 1;
            }
        }
    }
    return minLen;
};
