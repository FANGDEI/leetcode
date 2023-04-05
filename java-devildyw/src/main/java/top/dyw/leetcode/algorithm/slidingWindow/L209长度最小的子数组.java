package top.dyw.leetcode.algorithm.slidingWindow;

/**
 * @author Devil
 * @since 2022-09-01-19:14
 *
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
@SuppressWarnings("all")
public class L209长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(new L209长度最小的子数组().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 两层for循环 暴力破解
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int len = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                len++;
                if (sum>=target){
                    count = Math.min(count,len);
                    break;
                }
            }
        }
        return count;
    }


    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen01(int target, int[] nums) {
        //窗口左边界
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        //for循环里面的right是窗口的右边界 也就是终止位置
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            //while循环 当条件满足 无限逼近
            while (sum >= target){
                result = Math.min(result,right - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE?0:result;
    }
}
