package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-08-26-12:01
 * <p>
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * <p>
 * 请你计算并返回该式的最大值。
 */
@SuppressWarnings("all")
public class L1464数组中两元素的最大乘积 {
    public static void main(String[] args) {
        System.out.println(new L1464数组中两元素的最大乘积().maxProduct(new int[]{3, 4, 5, 2}));
    }


    /**
     * 有题目前情条件可知 数组元素均为整数且元素值均大于1
     * 所以要满足题目条件 就是要找到最大值和第二最大值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int first = -1;
        int second = -1;
        for (int num : nums) {
            if (num>first){
                second = first;
                first = num;

            }else if (num > second){
                second = num;
            }
        }
        return (first-1)*(second-1);
    }
}
