package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-09-15:34
 * <p>
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 */
@SuppressWarnings("all")
public class L724寻找数组的中心下标 {
    public static void main(String[] args) {
        System.out.println(new L724寻找数组的中心下标().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    /**
     * 前缀和
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        //计算流中的元素和
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        //左侧元素之和
        int sum = 0;

        /*
        当遍历到第i个元素的时候 右侧元素之和 = total - nums[i] - sum;
        左右侧元素相等即为 sum = total - nums[i] -sum; ==>  2 * sum + nums[i] = total
         */
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
