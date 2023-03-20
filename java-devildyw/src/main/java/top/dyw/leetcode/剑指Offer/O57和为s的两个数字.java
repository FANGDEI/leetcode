package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/20 20:06
 **/
@SuppressWarnings("all")
public class O57和为s的两个数字 {

    public static void main(String[] args) {

    }

    /**
     * 两数之和 因为是有序的数组所以这里可以用双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left<=right){
            if (target>(nums[left]+nums[right])){
                left++;
            }else if (target<(nums[left]+nums[right])){
                right++;
            }else{
                return new int[]{left,right};
            }
        }
        return new int[]{};
    }
}
