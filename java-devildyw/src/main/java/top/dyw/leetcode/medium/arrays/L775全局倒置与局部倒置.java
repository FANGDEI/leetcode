package top.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-11-16-11:36
 */
@SuppressWarnings("all")
public class L775全局倒置与局部倒置 {

    public static void main(String[] args) {

    }

    /**
     * 由题意规律可得 一个局部倒置一定是一个全局倒置 所以我们只需要找到一个非局部倒置即可
     * 即判断是否由 nums[i] > nums[j] i<j-1 这里的 j-1 一定大于i+1
     * @param nums
     * @return
     */
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length,minSuff = nums[n-1];
        //这里后往前遍历 i取 n-3 与minSuff 相差2
        for (int i = n-3; i >=0 ; i--) {
            if (nums[i]>minSuff){
                //如果大于则出现非局部倒置
                return false;
            }
            //如果nums[i]不大于 minSuff 更新 minSuff 为 nums[i+1] 保持i与j相差2
            minSuff = Math.min(minSuff,nums[i+1]);
        }
        //否则所有局部倒置都为全局倒置
        return true;
    }
}
