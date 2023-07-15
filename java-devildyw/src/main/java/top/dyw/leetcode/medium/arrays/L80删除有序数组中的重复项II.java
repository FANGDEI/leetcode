package top.dyw.leetcode.medium.arrays;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/07/15 11:34
 **/
@SuppressWarnings("all")
public class L80删除有序数组中的重复项II {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n<=2){
            return n;
        }

        int slow = 2,fast = 2;
        //因为所给数组是已经有序的，所以这里不用排序，还有就是题目允许出现两个相同的元素，所以这里直接考虑从第三个开始的元素是否与之前元素是否出现了三次
        //每次都取每三个相连的元素的首尾元素相比较是否相同（因为是升序的所以相同的元素一定是相连出现的） 也可以说是一个变相的滑动窗口
        //如果首位元素相等，则代表至少出现了三次该元素慢指针不动，快指针移动直到与慢指针不同为止
        while (fast<n){
            if (nums[slow-2]!=nums[fast]){
                nums[slow++] = nums[fast];
            }
            ++fast;
        }

        return slow;

    }
}
