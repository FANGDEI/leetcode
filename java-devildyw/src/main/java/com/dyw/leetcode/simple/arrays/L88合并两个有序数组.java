package com.dyw.leetcode.simple.arrays;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-07-12-10:01
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 */
@SuppressWarnings("all")
public class L88合并两个有序数组 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 0, 0, 0};
        new L88合并两个有序数组().merge(ints,3,new int[]{2,5,6},3);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i<m&&j<n){
            if (nums1[i]<=nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }
        while (i<m){
            list.add(nums1[i]);
            i++;
        }
        while (j<n){
            list.add(nums2[j]);
            j++;
        }

        for (int k = 0; k < list.size(); k++) {
            nums1[k] = list.get(k);
        }
    }
}
