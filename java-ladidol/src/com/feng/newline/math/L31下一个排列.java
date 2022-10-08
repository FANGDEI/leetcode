package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: ladidol
 * @date: 2022/10/6 13:05
 * @description: 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 */
public class L31下一个排列 {


    //巧妙理解(TLE)
    class Solution1 {
        /**
         * 参数：[nums]
         * 返回值：void
         * 作者： ladidol
         * 描述：先得到全部排列，然后将其转化成一个n位数，寻找target的最接近最大值。
         */
        public void nextPermutation(int[] nums) {
            int target = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                target = target * 10 + nums[i];
            }
            cache = new int[nums.length];
            for (int i = 0; i < n; i++) {
                cache[i] = 1;
                getPermutation("" + nums[i], nums);// 参数中同样带有回溯。
                cache[i] = 0;//回溯。
            }


            //对list进行排序。
            Collections.sort(list);
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == target) {
                    int j = i + 1;
                    index = i;
                    while (j < list.size() && list.get(j) == target) {//避免重复的排列（我超现在发现好像可以直接用set去重我是傻逼）
                        index = j;
                        j++;
                    }
                    index++;
                    break;
                }
            }

            long ans = index == list.size() ? list.get(0) : list.get(index);


            //需要将答案转化成nums数组。
            int i = n - 1;
            while (i >= 0) {
                long temp = ans % 10;
                ans /= 10;
                nums[i--] = (int) temp;
            }

        }

        List<Long> list = new ArrayList<>();
        int[] cache;

        //运用回溯来求全排列。
        void getPermutation(String path, int[] nums) {
            if (path.length() == nums.length) {
                list.add(Long.valueOf(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (cache[i] == 0) {
                    cache[i] = 1;
                    getPermutation(path + nums[i], nums);//参数中带有回溯。
                    cache[i] = 0;//回溯
                }
            }
        }
    }
    /*注意一个很离谱的案例引出的隐含题意：list = [115, 115, 151, 151, 511, 511]即151的下一个是511，不是115*/


    //模拟大法+小贪心
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：void
         * 作者： ladidol
         * 描述：从后往前找第一个升序坡顶k，然后从右边找第一个大于左边的数字。
         */
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2, k = n - 1, j = n - 1;
            //找到一个坡峰num[j],其左右两边存在nums[i],nums[k]
            while (i >= 0 && nums[i] >= nums[j]) {
                i--;
                j--;
            }
            //保证j不是第一个数字。就说明这个不是最大的字典序。
            if (i >= 0) {
                while (nums[i] >= nums[k]) {//找到第一个大于nums[i]的数字nums[k]。
                    k--;
                }
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            }

            //对j后面的进行升序排序
            for (int l = j, r = n - 1; l < r; l++, r--) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
    }


}