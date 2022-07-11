/* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    var move = function (i) {
        for (let p = i + 1; p < nums.length; p++) {
            if (nums[p] != 0) {
                nums[i] = nums[p]
                nums[p] = 0
                break
            }
        }
    }
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == 0)
            move(i)
    }
};