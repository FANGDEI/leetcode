/* 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var findMaxConsecutiveOnes = function(nums) {
    let max=0,now=0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]==1){
            now++
        }
        else{
            now>max?max=now:max
            now=0
        }
    }
    now>max?max=now:max
    return max

};