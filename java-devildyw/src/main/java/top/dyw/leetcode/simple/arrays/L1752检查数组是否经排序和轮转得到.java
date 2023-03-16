package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-11-27-12:15
 */
@SuppressWarnings("all")
public class L1752检查数组是否经排序和轮转得到 {

    public static void main(String[] args) {
        System.out.println(new L1752检查数组是否经排序和轮转得到().check(new int[]{3,4,5,1,2}));
    }

    /**
     *
     * @param nums
     * @return
     */
    public boolean check(int[] nums) {
        int n = nums.length;
        int times = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]>=nums[(i-1+nums.length)%nums.length]){
                continue;
            }
            times++;
            if (times > 1) {
                return false;
            }
        }

        return true;
    }
}
