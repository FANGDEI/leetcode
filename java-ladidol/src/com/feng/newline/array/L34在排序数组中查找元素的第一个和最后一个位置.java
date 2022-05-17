package com.feng.newline.array;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L34在排序数组中查找元素的第一个和最后一个位置
 * @author: Ladidol
 * @description: 有一点点小萌比
 * @date: 2022/5/17 16:25
 * @version: 1.0
 */
public class L34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new L34().searchRange(nums, 7)));
    }
}

class L34 {
    //分成寻找左右边界的情况, 分开来找!
    public int[] searchRange(int[] nums, int target) {
        int rightBorder = lookRightBorder(nums,target);
        int leftBorder = lookLeftBorder(nums,target);
        if (rightBorder == -2||leftBorder==-2){
            //"射线"样子的区间 例如:{3, 4, 5},target为6
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
        while(left<=right){
            mid = (right - left)/2+left;
            if (nums[mid]>target){//如果在左边,就right = mid - 1
                right = mid -1;
            }else{//"如果相等的话", 就说明右边界可以再往mid右边移动一个
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
            if (nums[mid]>=target){//"如果相等的话", 就说明左边界可以再往mid左边移动一个
                right = mid -1;
                leftBorder = right;
            }else{
                left = mid + 1;
            }
        }
        return leftBorder;
    }

}
