/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function (nums) {
    let max = Number.MIN_VALUE, maxl, maxr
    for (let i = 0; i < nums.length; i++) {
        let value = nums[i]
        for (let j = i; j < nums.length; j++) {
            value *= nums[j]
            if (max < value) {
                maxl = i, maxr = j
                max = value
            }
        }
    }
    return max
};