package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-07-04-12:11
 * <p>
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 arr满足下述条件，那么它是一个山脉数组：
 * <p>
 * arr.length >= 3
 * 在0 < i< arr.length - 1条件下，存在i使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 */
@SuppressWarnings("all")
public class L941有效的山脉数组 {
    public static void main(String[] args) {
        System.out.println(new L941有效的山脉数组().validMountainArray(new int[]{0, 3, 2, 1}));
    }

    /**
     * 两边都是都是单挑逼近于中间的最大值
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int maxIndex = 0;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex == left || maxIndex == right) {
            return false;
        }

        while (left < maxIndex) {
            if (arr[left] >= arr[left + 1]) {
                return false;
            }
            left++;
        }

        while (right > maxIndex) {
            if (arr[right] >= arr[right - 1]) {
                return false;
            }
            right--;
        }


        return true;
    }

    public boolean validMountainArray01(int[] arr) {
        int n = arr.length;
        int index = 0; //记录遍历的下标

        //递增遍历 山的左边
        while (index + 1 < n && arr[index] < arr[index + 1]) {
            index++;
        }

        //此时的index就为最大值所在的下标 判断下标是否处于两端的任一位置 是就不符合条件
        if (index == 0 || index == n - 1) {
            return false;
        }

        //递减遍历 山的右一半
        while (index + 1 < n && arr[index] > arr[index + 1]) {
            index++;
        }

        return index == n - 1;
    }
}
