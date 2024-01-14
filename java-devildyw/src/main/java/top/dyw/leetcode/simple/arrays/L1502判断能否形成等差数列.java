package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/12/22 20:09
 **/
@SuppressWarnings("all")
public class L1502判断能否形成等差数列 {

    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        /**
         * 排序数组 等差数列要么递增 要么递减 要么都相同 那么只需要判断后续的相邻元素只差是否等于最开始的差计科
         */
        Arrays.sort(arr);
        int lastDiff = arr[1]-arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i+1]-arr[i];
            if (lastDiff!=temp){
                return false;
            }
        }
        return true;
    }
}
