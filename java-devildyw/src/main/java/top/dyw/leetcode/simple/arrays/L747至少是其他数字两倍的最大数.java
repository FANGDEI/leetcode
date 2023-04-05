package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-06-11-21:13
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 */
@SuppressWarnings("all")
public class L747至少是其他数字两倍的最大数 {
    public static void main(String[] args) {
        System.out.println(new L747至少是其他数字两倍的最大数().dominantIndex02(new int[]{1, 2, 3, 4}));
    }

    /**
     * 方法一: 使用排序加hashmap的思想 只要最大值大于等于第二最大值即可 使用hashmap记录元素与下标的关系
     *
     * @param nums
     * @return
     */
    public int dominantIndex01(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);

        if (nums[length - 1] >= 2 * nums[length - 2]) {
            return map.get(nums[length - 1]);
        }
        return -1;
    }

    /**
     * 方法二: 使用遍历找到最大值和最小值即可 是方法一的改良版
     *
     * @param nums
     * @return
     */
    public int dominantIndex02(int[] nums) {
        //如果数组长度小于等于1 返回0(据题意)
        if (nums.length <= 1) {
            return 0;
        }
        //初始化最大值 和第二最大值
        int m1 = -1, m2 = -1;
        //记录最大值下标
        int index = -1;
        //遍历查找
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                //找到比最大值大的值之后 将原来的最大值赋值给第二最大值
                m2 = m1;
                //更新最大值
                m1 = nums[i];
                //更新最大值下标
                index = i;
            } else if (nums[i] > m2) { //防止出现遇到最大值出现在前面的情况后面又出现了比第二大的数大的情况 需要多加一步 如[0,0,3,2]
                m2 = nums[i];
            }
        }
        return m1 >= 2 * m2 ? index : -1;
    }
}
