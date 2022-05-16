package com.feng.leetcode;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/26 20:40
 * @Version 1.0
 */
public class L53最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new 最大子数组和dp().maxSubArray(nums));
    }

}
/**
 * @Description:

 * @Author: ladidol
 * @Date: 2022/3/26 21:08
 * @Param:
 * @Return:
 */
class 最大子数组和dp {
    public int maxSubArray(int[] nums) {
        //只有当以当前节点结尾的子节点,这样来考虑的话,才有dp的影子;
        //当前节点是结尾or开始,max(dp[i]+nums[i],nums[i]);
        //这里能取到当前节点的最优解了,但是下一个节点的最优解就要和最优解maxOld比较
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
class 最大子数组和fenzhi {
    public int getMax(int[] nums, int low, int high) {
        // 如果子数组只有一个元素，这个元素就是子树组的最大和。
        if (low == high) {
            return nums[low];
        }
        int mid = low + (high - low) / 2;
        // 求左数组的最大和
        int leftMax = getMax(nums, low, mid);
        // 求右数组的最大和
        int rightMax = getMax(nums, mid + 1, high);
        // 求跨越情况的最大和
        int crossMax = getCrossMax(nums, low, mid, high);
        // 返回最大
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    // 求跨越情况的最大和
    public int getCrossMax(int[] nums, int low, int mid, int high) {
        // 从中间向左走，一直累加，每次累计后都取最大值，最后得到的就是从中间向左累加可得到最大和
        int leftSum = nums[mid];
        int leftMax = nums[mid];
        for (int i = mid - 1; i >= low; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        // 从中间向右走，一直累加，每次累计后都取最大值，最后得到的就是从中间向右累加可得到最大和
        int rightSum = nums[mid+1];
        int rightMax = nums[mid+1];
        for (int i = mid + 2; i <= high; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        // 向左累加的最大和加上向右累加的最大和，就是跨越情况下的最大和
        return leftMax + rightMax;
    }
    public int maxSubArray(int[] nums) {
        return getMax(nums, 0 , nums.length - 1);
    }
}
