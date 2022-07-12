package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-12-10:33
 */
@SuppressWarnings("all")
public class L189轮转数组 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};

        new L189轮转数组().rotate(ints, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 超时做法
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        while (k-- > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 数组反转(官方解法)
     * <p>
     * 下面是解释
     * <p>
     * nums = "----->-->"; k =3
     * <p>
     * result = "-->----->";
     * <p>
     * reverse "----->-->" we can get "<--<-----"
     * <p>
     * reverse "<--" we can get "--><-----"
     * <p>
     * reverse "<-----" we can get "-->----->"
     * <p>
     * this visualization help me figure it out :)
     * <p>
     *
     * @param nums
     * @param k
     */
    public void rotate01(int[] nums, int k) {
        //将k对nums.length取模 防止做无用功 且防止超时
        k %= nums.length;
        //根据上方解释我们可以构造一个反转数组的函数
        reverse(nums, 0, nums.length - 1);
        //反转现在数组中的前k个元素
        reverse(nums, 0, k - 1);
        //反转后面剩余的元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组的函数
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
