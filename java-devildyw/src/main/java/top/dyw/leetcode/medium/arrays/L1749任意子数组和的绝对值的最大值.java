package top.dyw.leetcode.medium.arrays;

/**
 * @author Devildyw
 * @date 2023/08/08 13:22
 **/
@SuppressWarnings("all")
public class L1749任意子数组和的绝对值的最大值 {

    public static void main(String[] args) {
        System.out.println(new L1749任意子数组和的绝对值的最大值().maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
    }

    /**
     * 暴力
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (Math.abs(sum)>max){
                    max = Math.abs(sum);
                }
            }
        }

        return max;
    }


    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxAbsoluteSum01(int[] nums) {
        int n = nums.length;
        int pre = 0;
        int max = 0;
        int min = 0;

        //子数组的和相当于两个前缀和的差，那么取前缀和最大和最小的相减的值就是答案
        for (int i = 0; i < n; i++) {
            //这里通过pre随着i遍历记录当前位置的前缀和
            pre+=nums[i];
            max = Math.max(max,pre); //通过max和min记录前缀和计算途中的最大前缀和和最小前缀和
            min = Math.min(min,pre);
        }
        return max-min; //最后返回最大子数组和 如果最大值在最小值右侧则为和最大，如果最大值在最小值左侧则为绝对值最大

    }



    /**
      子数组之和其实就是两个前缀和之差，绝对值最大其实就是最大前缀和与最小前缀和的最大差值
     */
    public int maxAbsoluteSumPrefixSum(int[] nums) {
        int n = nums.length;
        int pre = 0;
        int max = 0;
        int min = 0;

        for (int num : nums) {
            pre += num;
            max = Math.max(max,pre);
            min = Math.min(min,pre);
        }
        return max - min;
    }


    public int maxAbsoluteSumDP(int[] nums) {
        //ans 记录全局最大连续子数组和绝对值，fmax记录以当前元素结尾的子数组和的最大值，fmin记录以当前元素结尾的子数组最小值
        int ans = 0, fMax = 0, fMin = 0;

        for (int num : nums) {
            //与0做比较如果小于0则舍弃之前 这里是找最大的
            fMax = Math.max(fMax,0) + num;
            //与0做比较如果大于0则舍弃之前 因为这里是找最小的
            fMin = Math.min(fMin,0) + num;
            ans = Math.max(ans,Math.max(fMax,-fMin)); //最后比较 ans 和 fmax fmin的最大值和最小值
        }

        /**
         * 如果全为正数则fmax会不断累计而fmin会不断舍弃之前的值最终的结果也就是fmax的结果
         * 如果全为负数则fmin会不断累计而fmax会不断舍弃之前的值最终结果也就是-fmin的结果
         */
        return ans;
    }


}
