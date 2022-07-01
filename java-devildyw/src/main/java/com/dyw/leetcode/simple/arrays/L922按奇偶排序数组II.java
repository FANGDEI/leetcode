package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-07-01-11:53
 * <p>
 * 给定一个非负整数数组nums，nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * <p>
 * 对数组进行排序，以便当nums[i] 为奇数时，i也是 奇数 ；当nums[i]为偶数时， i 也是 偶数 。
 * <p>
 * 你可以返回 任何满足上述条件的数组作为答案 。
 */
@SuppressWarnings("all")
public class L922按奇偶排序数组II {
    public static void main(String[] args) {
        int[] ints = new L922按奇偶排序数组II().sortArrayByParityII(new int[]{4, 2, 5, 7});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 前后遍历 原地修改  时间复杂度高不推荐
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < n && right >= 0) {
            while (left < n && !(nums[left] % 2 == 0 && left % 2 == 1)) {
                left++;
            }
            while (0 <= right && !(nums[right] % 2 == 1 && right % 2 == 0)) {
                right--;
            }

            if (left < n && right >= 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }


    /**
     * 双指针一次遍历 将偶数依次放在偶数下标下 奇数一次放在奇数下标下
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII01(int[] nums) {
        int n = nums.length;
        //初始化返回数组
        int[] ans = new int[n];

        //将偶数装在偶数下标的位置
        int i = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[i] = num;
                i += 2;
            }
        }

        i = 1;
        //将奇数装在奇数下标的位置
        for (int num : nums) {
            if (num % 2 == 1) {
                ans[i] = num;
                i += 2;
            }
        }

        return ans;
    }

    /**
     * 双指针 原地修改 一次遍历
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII02(int[] nums) {
        int n = nums.length;
        //初始化奇数下标指针
        int j = 1;

        //从下标0开始i负责偶数下标
        for (int i = 0; i < n; i += 2) {
            //如果偶数下标中发现了奇数
            if (nums[i] % 2 == 1) {
                //则查找奇数下标中的偶数
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
