package top.dyw.leetcode.面试150题;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/08/23 21:54
 **/
@SuppressWarnings("all")
public class L88合并两个有序数组 {

    public static void main(String[] args) {
        new L88合并两个有序数组().merge01(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOf(nums1, m);
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (temp[i] <= nums2[j]) {
                nums1[k++] = temp[i++];

            } else {
                nums1[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums1[k++] = temp[i++];
        }

        while (j < n) {
            nums1[k++] = nums2[j++];
        }


    }

    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int newLength = m+n;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]){
                nums1[--newLength] = nums1[i--];
            }else{
                nums1[--newLength] = nums2[j--];
            }
        }

        while (i>=0){
            nums1[--newLength] = nums1[i--];
        }

        while (j>=0){
            nums1[--newLength] = nums2[j--];
        }

    }
}
