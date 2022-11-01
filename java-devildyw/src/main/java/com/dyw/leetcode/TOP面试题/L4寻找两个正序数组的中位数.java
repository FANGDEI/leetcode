package com.dyw.leetcode.TOP面试题;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author Devil
 * @since 2022-10-31-14:59
 */
@SuppressWarnings("all")
public class L4寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        System.out.println(new L4寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] array = new int[m + n];
        int i = 0, j = 0;
        int index = 0;
        while (i<m&&j<n){
            if (nums1[i]<nums2[j]){
                array[index++] = nums1[i++];
            }else{
                array[index++] = nums2[j++];
            }
        }
        while (i<m){
            array[index++] = nums1[i++];
        }
        while (j<n){
            array[index++] = nums2[j++];
        }

        double mid = 0;
        if (array.length%2==0){
            mid = (double)(array[array.length/2] + array[(array.length/2)-1])/2;
        }else{
            mid = array[array.length/2];
        }

        return mid;
    }
}
