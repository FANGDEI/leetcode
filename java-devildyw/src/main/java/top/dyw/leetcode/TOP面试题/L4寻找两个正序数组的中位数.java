package top.dyw.leetcode.TOP面试题;

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
        System.out.println(new L4寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //将两个正序数组 组装成一个有序数组来计算中位数。
        int[] array = new int[nums1.length+nums2.length];

        //遍历指针
        int i = 0, j = 0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]<=nums2[j]){
                array[i+j] = nums1[i];
                i++;
            }else{
                array[i+j] = nums2[j];
                j++;
            }
        }
        while (i<nums1.length){
            array[i+j] = nums1[i++];
        }
        while (j<nums2.length){
            array[i+j] = nums2[j++];
        }

        double mid = 0;
        if (array.length%2==0){
            mid = (array[array.length/2]+array[(array.length/2)-1])/2.0;
        }else{
            mid = array[array.length/2];
        }

        return mid;
    }
}
