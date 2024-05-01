package com.feng.leetcode.hot100._02双指针;

public class h283移动零 {

    class Solution {
        //巧方法
/*        public void moveZeroes(int[] nums) {
            //找到不是零的,先按顺序存下来,后补零就是了;
            int index = 0;
            for (int i : nums) {
                if (i !=0){
                    nums[index++] = i;
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }*/

        //快慢指针
        public void moveZeroes(int[] nums) {
            int fast, slow;
            int tmp = 0;
            for (fast = 0, slow = 0; fast < nums.length; fast++) {
                //通过fast去找每一个不是零的数，
                if (nums[fast] != 0) {
                    tmp = nums[slow];
                    nums[slow++] = nums[fast];// 对于slow在自加维护当前不为零序列的末尾
                    nums[fast] = tmp;
                }
            }
        }


    }


}
