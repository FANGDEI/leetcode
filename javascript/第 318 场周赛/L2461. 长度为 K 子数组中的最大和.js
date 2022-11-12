/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumSubarraySum = function (nums, k) {
    // i和j为滑动窗口的左右端点
    let ans = 0, i = 0, j = 0;
    // 记录遍历到的字符串所在位置，用于判断是否子数组中是否有重复元素
    const prev = new Map();
    // 滑动窗口的总和
    let sum = 0;
    while (j < nums.length) {
        // 如果相同元素出现的位置，在窗口范围内(等于大于i，小于j)，就直接移动左端点，直到不包括相同元素
        while (prev.has(nums[j]) && prev.get(nums[j]) >= i) {
            // 维护总和
            sum -= nums[i++];
        }
        // 把此次字母插入集合中
        prev.set(nums[j], j)
        // 累加总和
        sum += nums[j];
        // 判断当前长度，是否满足了k，满足就维护最大值
        if (j - i + 1 == k) {
            ans = Math.max(ans, sum);
            sum -= nums[i++];
        }
        j++;
    }

    return ans;
};
