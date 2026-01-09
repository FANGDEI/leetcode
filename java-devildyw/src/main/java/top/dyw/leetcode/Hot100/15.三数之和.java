/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                //如果nums[i] 已经大于0了 因为排序的缘故 这里直接break就行 剪枝
                break;
            }

            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right-1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
// @lc code=end

