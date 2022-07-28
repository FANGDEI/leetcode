package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-26-10:46
 * <p>
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 */
@SuppressWarnings("all")
public class L75颜色分类 {
    public static void main(String[] args) {
        int[] ints = {2, 0, 1};
        new L75颜色分类().sortColors(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 双指针替换 先替换0 将0替换到前面不为0的位置 再在不为0的元素后再替换1 这样自动就可以排序了。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int i = 0; i < 2; i++) {
            int right = n - 1;
            while (left <= right) {

                while (left <= n - 1 && nums[left] == i) {
                    left++;
                }
                while (right >= 0 && nums[right] != i) {
                    right--;
                }

                if (left <= right) {
                    nums[left] = nums[left] + nums[right];
                    nums[right] = nums[left] - nums[right];
                    nums[left] = nums[left] - nums[right];
                    left++;
                    right--;
                }
            }
        }
    }
}
