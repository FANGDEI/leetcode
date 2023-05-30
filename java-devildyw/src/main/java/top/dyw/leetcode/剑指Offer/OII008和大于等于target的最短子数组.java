package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Devildyw
 * @date 2023/05/30 19:51
 **/
@SuppressWarnings("all")
public class OII008和大于等于target的最短子数组 {

    public static void main(String[] args) {
        System.out.println(new OII008和大于等于target的最短子数组().minSubArrayLen(4, new int[]{1,4,4}));
    }

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            while (sum>=target){
                result = Math.min(result,right-left+1);
                sum -= nums[left++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
