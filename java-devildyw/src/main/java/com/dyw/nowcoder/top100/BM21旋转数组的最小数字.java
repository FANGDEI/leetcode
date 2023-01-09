package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-28-13:38
 */
@SuppressWarnings("all")
public class BM21旋转数组的最小数字 {

    public static void main(String[] args) {
        System.out.println(new BM21旋转数组的最小数字().minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }

    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length-1;

        //根据规律 如果出现中间数字大于右边 则最小值一定在右边 如果不是则最小值在左边或者mid
        //因为 旋转后 大的数字要么在左边 要么旋转一周后顺序不变 小的还在左边
        while (left<right){
            int mid = (right-left)/2+left;

            //最小的数字在mid右边
            if (array[mid]>array[right]){
                left = mid+1;
                //相等的情况 无法判断 只能一个一个试
            }else if (array[mid]==array[right]){
                right--;
                //最小数字要么是mid 要么在mid左边
            }else{
                right = mid;
            }
        }
        return array[right];
    }
}
