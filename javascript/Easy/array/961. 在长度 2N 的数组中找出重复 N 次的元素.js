/* 给你一个整数数组 nums ，该数组具有以下属性：

nums.length == 2 * n.
nums 包含 n + 1 个 不同的 元素
nums 中恰有一个元素重复 n 次
找出并返回重复了 n 次的那个元素。
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var repeatedNTimes = function(nums) {
    const found = new Set();
    for (const num of nums) {
        if (found.has(num)) {
            return num;
        }
        found.add(num);
    }
    // 不可能的情况
    return -1;
};

/**
 * @param {number[]} nums
 * @return {number}
 */
 var repeatedNTimes = function(nums) {
    const n = nums.length;

    while (true) {
        const x = Math.floor(Math.random() * n), y = Math.floor(Math.random() * n);
        if (x !== y && nums[x] === nums[y]) {
            return nums[x];
        }
    }
};
