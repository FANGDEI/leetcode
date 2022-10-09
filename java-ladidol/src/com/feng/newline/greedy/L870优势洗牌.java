package com.feng.newline.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: ladidol
 * @date: 2022/10/8 16:44
 * @description: 给定两个大小相等的数组nums1和nums2，nums1相对于 nums2 的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
 * 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * 提示：
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 */
public class L870优势洗牌 {

    //贪心 + 数据结构——TreeSet和Map
    class Solution {

        /**
         * 参数：[nums1, nums2]
         * 返回值：int[]
         * 作者： ladidol
         * 描述：
         * 田忌赛马：
         * 贪心就是：与nums2等位匹配的是大于它的最小值or最小值。这里我们用TreeSet来快速取出，用Map来计数删除set中元素。
         */
        public int[] advantageCount(int[] nums1, int[] nums2) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                //初始化计数map
                map.put(num, map.getOrDefault(num, 0) + 1);
                //初始化set
                treeSet.add(num);
            }

            //遍历nums2田忌赛马开始辣！
            for (int i = 0; i < nums2.length; i++) {
                Integer minMax = treeSet.ceiling(nums2[i] + 1);//语法糖。
                if (minMax == null) minMax = treeSet.ceiling(-1);//只能取出最小值咯。
                nums1[i] = minMax;
                //维护nums1的计数map；
                map.put(minMax, map.get(minMax) - 1);
                //维护nums1的set；
                if (map.get(minMax) == 0) treeSet.remove(minMax);

            }
            return nums1;
        }
    }


}