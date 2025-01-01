package top.dyw.leetcode.hard.array;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2024/12/19 10:18
 **/
@SuppressWarnings("all")
public class L4寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        System.out.println(new L4寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int half = (total / 2);
        int[] newArr = new int[total];
        int count = 0;
        int i = 0, j = 0;
        while(i < m && j < n) {
            if (nums1[i] <= nums2[j]){
                newArr[count++] = nums1[i];
                i++;
            } else {
                newArr[count++] = nums2[j];
                j++;
            }
        }
        while (i < m){
            newArr[count++] = nums1[i];
            i++;
        }
        while (j < n) {
            newArr[count++] = nums2[j];
            j++;
        }
        return total % 2 == 0 ? (newArr[half - 1] + newArr[half]) / 2.0 : newArr[half];
    }
}
