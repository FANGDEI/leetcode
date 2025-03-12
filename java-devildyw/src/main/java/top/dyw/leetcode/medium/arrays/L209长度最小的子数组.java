package top.dyw.leetcode.medium.arrays;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/03/11 10:08
 **/
@SuppressWarnings("all")
public class L209长度最小的子数组 {

    public static void main(String[] args) {
        System.out.println(new L209长度最小的子数组().minSubArrayLen(15, new int[]{1,2,3,4,5}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res > nums.length ? 0 : res;
    }
}
