package com.feng.draft.template.二分;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.二分
 * @className: 普通二分
 * @author: Ladidol
 * @description:
 * @date: 2022/9/3 16:48
 * @version: 1.0
 */
public class 二分 {


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8, 9, 15, 23, 25};
        int value = 普通二分(nums, 0, nums.length, 16);
        int lower_bound = lower_bound(nums, 0, nums.length, 16);
        int upper_bound = upper_bound(nums, 0, nums.length, 0);

        System.out.println("value = " + value);
        System.out.println("lower_bound = " + lower_bound);
        System.out.println("upper_bound = " + upper_bound);
    }

    static int 普通二分(int[] nums, int l, int r, int value) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == value)
                return mid;
            else if (nums[mid] > value)
                r = mid;
            else
                l = mid + 1;
        }
        return -1; //说明数列中没有v
    }

    static int lower_bound(int[] nums, int l, int r, int value) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= value)
                r = mid;
            else
                l = mid + 1;
        }
        return l; // 返回的是出现value的坐标范围[l,r)的l。
    }

    static int upper_bound(int[] nums, int l, int r, int value) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= value)
                l = mid + 1;
            else
                r = mid;
        }
        return l; // 返回的是出现value的坐标范围[l,r)的r,这里是上界。
    }


}
