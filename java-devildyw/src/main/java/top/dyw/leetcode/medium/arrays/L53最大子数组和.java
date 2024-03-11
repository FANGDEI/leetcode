package top.dyw.leetcode.medium.arrays;

/**
 * @author Devildyw
 * @date 2023/08/08 13:57
 **/
@SuppressWarnings("all")
public class L53最大子数组和 {

    public static void main(String[] args) {

    }

    /**
     * 前缀和法
     * @param nums
     * @return
     */
    public int maxSubArrayPrefixSum(int[] nums) {
        int pre = 0;
        int min = 0;
        int maxSum = Integer.MIN_VALUE;

        /**
         * 这里注意不是绝对值最大所以要保证最大值在最小值的右侧，最好的方法就是在遍历途中记录minS 然后不断更新res = Math.max(res, pre-min);
         */
        //注意这里是先更新maxSum 再更新min 因为min一开始为0 是为了防止只有一个元素的情况或者遇到全是负数就只能结果是0了
        for (int num : nums) {
            pre += num;
            maxSum = Math.max(maxSum,pre-min);
            min = Math.min(pre,min);
        }

        return maxSum;
    }

    /**
     * dp
     * @param nums
     * @return
     */
    public int maxSubArrayDP(int[] nums) {
        int pre = 0, maxAns = nums[0]; //pre表示以当前元素结尾的连续子数组的最大和， maxAns全局最大的连续子数组的最大和
        /**
         * pre 表示当前i所处的最大子序列和
         */
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]); //如果pre+当前元素不能得到一个更大的连续子数组和就重新记录子数组
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
    }



}
