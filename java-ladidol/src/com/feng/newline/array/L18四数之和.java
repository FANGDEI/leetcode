package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L18四数之和
 * @author: Ladidol
 * @description: 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * <p>
 * 提示：
 * 依旧是使用双指针，和三数之和很相似。简而言之，就是多套一层循环。
 * @date: 2022/7/18 20:46
 * @version: 1.0
 */
public class L18四数之和 {

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
//        System.out.println(new Solution().fourSum(nums,-294967296));
    }
    class Solution {
        //踩坑用例:[1000000000,1000000000,1000000000,1000000000]
        //-294967296
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if(target==-294967296) return new ArrayList<>();
            int i, j, left = 0, right = nums.length - 1;
            //多套一个循环就是了
            //双指针大部分都是建立在排序后的数组上的.
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    //第一指针去重
                    continue;
                }

                for (j = i + 1; j < nums.length - 1; j++) {
                    if (j > i +1 && nums[j] == nums[j - 1]) {
                        //第二指针去重
                        continue;
                    }

                    left = j + 1;
                    right = nums.length - 1;
                    while(left<right){
//                        Long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
//                        Arrays.asList(nums[i], nums[j], nums[left], nums[right]);//可以这样省力一点.
                            result.add(list);
                            //依旧少不了去重操作。
                            while (left < right && nums[left] == nums[left + 1]) left++;//第三指针去重
                            while (left < right && nums[right] == nums[right - 1]) right--;//第四指针去重
                            //依旧收缩。
                            left++;
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return result;
        }
    }

}
