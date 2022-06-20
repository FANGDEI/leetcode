package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L704二分查找
 * @author: Ladidol
 * @description: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @date: 2022/5/16 14:35
 * @version: 1.0
 */
public class L704二分查找 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new 闭区间二分法().search(nums, 7));
    }
}

class 闭区间二分法 {
    //方法一
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
            mid = (right - left) / 2 + left;// 防止溢出
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;// target 在右区间，所以[mid + 1, right]
            } else {
                right = mid - 1;// target 在左区间，所以[left, mid - 1]
            }
//            System.out.println("mid是: "+mid);
        }
        return -1;
    }


    //方法二
    public int search(int[] nums, int target) {
        return search_递归(nums,target, 0, nums.length-1);
    }

    public int search_递归(int[] nums, int target, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (left<=right){
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return search_递归(nums, target, mid + 1, right);
            } else {
                return search_递归(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

}


class 右开区间二分法 {
    //方法三
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//因为开区间, 所以右边取大
        int mid;
        while (left < right) {// // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            mid = (right - left) / 2 + left;// 防止溢出
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;// target 在右区间，所以[mid + 1, right)
            } else {
                right = mid;// target 在左区间，所以[left, mid)
            }
        }
        return -1;
    }
}
