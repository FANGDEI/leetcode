package top.dyw.leetcode.周赛.第320周;

/**
 * @author Devil
 * @since 2022-11-20-12:22
 */
@SuppressWarnings("all")
public class L6241数组中不等三元组的数目 {

    public static void main(String[] args) {
        System.out.println(new L6241数组中不等三元组的数目().unequalTriplets(new int[]{1,1,1,1,1}));
    }

    /**
     * 暴力 三重循环
     * @param nums
     * @return
     */
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if ((nums[i]!=nums[j])&&(nums[j]!=nums[k])&&(nums[i]!=nums[k])){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
