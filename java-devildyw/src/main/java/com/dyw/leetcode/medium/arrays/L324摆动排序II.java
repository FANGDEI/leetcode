package com.dyw.leetcode.medium.arrays;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-06-28-12:57
 * <p>
 * 给你一个整数数组nums，将它重新排列成nums[0] < nums[1] > nums[2] < nums[3]...的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
@SuppressWarnings("all")
public class L324摆动排序II {
    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 2, 3, 1};
        new L324摆动排序II().wiggleSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 使用交叉插入的方法 将数组进行排序 然后进行按照题目所要求的的顺序进行插入
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        //因为是在原来的数组的基础上修改 所以首先复制一个原数组
        int[] arr = nums.clone();
        //对复制的数组进行排序
        Arrays.sort(arr);


        int n = nums.length;

        //找到中间下标
        int x = (n + 1) / 2;

        //进行替换
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            //将前半部分中的最大值 和 后半部分的最大值进行交叉填充
            //这里从元素组的头部开始替换 填入前半部分的较大的值(因为已经排好序了)
            nums[i] = arr[j];
            if (i + 1 < n) { // 如果下标没有越界那么进行填充下个值 该值为排序后数组的后半部分的最大值 即整个数组的最大值
                nums[i + 1] = arr[k];
            }
        }

    }
}
