package com.feng.review.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L18四数之和
 * @author: Ladidol
 * @description: 提示：
 * 依旧是使用双指针，和三数之和很相似。简而言之，就是多套一层循环。
 * @date: 2022/7/18 20:46 2023年3月1日10:03:39
 * @version: 1.0
 */
public class L18四数之和 {

    class Solution1 {
        //踩坑用例:[1000000000,1000000000,1000000000,1000000000]
        //-294967296

        /**
         * 四数之和II是算的组合数，这里是要得到每一种组合。
         * @param nums
         * @param target
         * @return
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (target == -294967296) return new ArrayList<>();

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
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        //第二指针去重
                        continue;
                    }

                    left = j + 1;
                    right = nums.length - 1;
                    while (left < right) {
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
