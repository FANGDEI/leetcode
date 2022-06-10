package com.feng.newline.array;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L34在排序数组中查找元素的第一个和最后一个位置
 * @author: Ladidol
 * @description: 有一点点小萌比
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * @date: 2022/5/17 16:25
 * @version: 1.0
 */
public class L34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new L34分区查找().searchRange(nums, 7)));
    }
}

class L34分区查找 {
    //分成寻找左右边界的情况, 分开来找!
    public int[] searchRange(int[] nums, int target) {
        int rightBorder = lookRightBorder(nums,target);
        int leftBorder = lookLeftBorder(nums,target);
        if (rightBorder == -2||leftBorder==-2){
            //"射线"样子的区间 例如:{3, 4, 5},target为6
            //有一个是border等于-2, 就返回如下, 例如上行的例子就是
            return new int[]{-1,-1};
        }else if (rightBorder-leftBorder>1){
            //区间存在数字的时候, 就把它变成题设中的闭区间; 例如:{3,6,7},target为6
            return new int[]{leftBorder+1,rightBorder-1};
        }

        //这时候就是不存在该数字的时候 例如:{3,6,7},target为5
        return new int[]{-1, -1};

    }
    //寻找最小开区间右边界
    public int lookRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int rightBorder = -2;
        int mid;
        while(left<=right){// 当left==right，区间[left, right]依然有效
            mid = (right - left)/2+left;
            if (nums[mid]>target){//如果在左边,就right = mid - 1
                right = mid -1;
            }else{//"如果相等的话", 就说明右边界可以再往mid右边移动一个 重要的就是这else包括等于符号
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }


    //寻找最小开区间左边界
    public int lookLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int leftBorder = -2;
        int mid;
        while(left<=right){
            mid = (right - left)/2+left;
            if (nums[mid]>=target){//"如果相等的话", 就说明左边界可以再往mid左边移动一个 重要的就是这else包括等于符号
                right = mid -1;
                leftBorder = right;
            }else{
                left = mid + 1;
            }
        }
        return leftBorder;
    }
}
// 解法2 直接cp的答案
// 1、首先，在 nums 数组中二分查找 target；
// 2、如果二分查找失败，则 binarySearch 返回 -1，表明 nums 中没有 target。此时，searchRange 直接返回 {-1, -1}；
// 3、如果二分查找成功，则 binarySearch 返回 nums 中值为 target 的一个下标。然后，通过左右滑动指针，来找到符合题意的区间

class L34直接查找 {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target); // 二分查找

        if (index == -1) { // nums 中不存在 target，直接返回 {-1, -1}
            return new int[] {-1, -1}; // 匿名数组
        }
        // nums 中存在 targe，则左右滑动指针，来找到符合题意的区间
        int left = index;
        int right = index;
        // 向左滑动，找左边界
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) { // 防止数组越界。逻辑短路，两个条件顺序不能换
            left--;
        }
        // 向左滑动，找右边界
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) { // 防止数组越界。
            right++;
        }
        return new int[] {left, right};
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 不变量：左闭右闭区间

        while (left <= right) { // 不变量：左闭右闭区间
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; // 不变量：左闭右闭区间
            }
        }
        return -1; // 不存在
    }
}
