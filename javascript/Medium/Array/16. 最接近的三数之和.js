// 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

// 返回这三个数的和。

// 假定每组输入只存在恰好一个解。

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var threeSumClosest = function (nums, target) {
    nums = nums.sort()
    let res = Number.MAX_SAFE_INTEGER, sum
    for (let i = 0; i < nums.length; i++) {
        let l = i + 1, r = nums.length - 1
        while (l <= r) {
            sum = nums[i] + nums[l] + nums[r]
            if (Math.abs(res - target) > Math.abs(sum - target)) res = sum 
        }
    }
};