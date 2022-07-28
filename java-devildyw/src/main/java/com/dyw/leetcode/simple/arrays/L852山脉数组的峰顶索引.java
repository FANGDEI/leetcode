package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-19-15:24
 * <p>
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 */
@SuppressWarnings("all")
public class L852山脉数组的峰顶索引 {
    public static void main(String[] args) {
        System.out.println(new L852山脉数组的峰顶索引().peakIndexInMountainArray01(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;

        int index = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i] > arr[i + 1] && i < length - 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 二分法
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray01(int[] arr) {
        int length = arr.length;

        int left = 0, right = length - 1, index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            //当idis满足是题目满足的点时 在i>=idis时 arr[i]>arr[i+1] 恒成立
            //i<dis时 arr[i]<arr[i-1]恒成立
            if (arr[mid] > arr[mid + 1]) {
                //这里arr[mid]>arr[mid+1]; 由上面结论可知此时 i>=idis 继续逼近 往左边找
                index = mid; //记录下标
                right = mid - 1;
            } else {
                //arr[mid]<arr[mid+1] 那么 i<idis 需要往右边找
                left = mid + 1;
            }
        }
        //一直逼近直到left>right时结束返回index结果.
        return index;
    }

}
