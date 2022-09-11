package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L496下一个更大元素I
 * @author: Ladidol
 * @description: nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 * 提示：
 * <p>
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * @date: 2022/9/10 12:14
 * @version: 1.0
 */
public class L496下一个更大元素I {

    // 普通的暴力
    class Solution1 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            for (int i = 0; i < nums1.length; i++) {
                int temp = -1;
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        for (int k = j + 1; k < nums2.length; k++) {
                            if (nums2[k] > nums2[j]) {
                                temp = nums2[k];
                                break;// 找到第一个大于的数就开始剪枝
                            }
                        }
                        break;// 找到就开始剪枝
                    }
                }
                // 节省空间：直接用nums1来装答案。
                nums1[i] = temp;
            }
            return nums1;
        }
    }

    // 单调栈
    class Solution {
        // 看了一下代码随想录：这个就是和739一个意思的题，只不过是对子序列寻找下一个大的值；
        // 这里就巧妙的运用了map来记录位置元素,同时可以快速找到该下一个大元素下标。
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[nums1.length];
            Map<Integer, Integer> map = new HashMap<>();
            //先遍历nums2数组，初始化每个数的下一个最近大的值
            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    map.put(nums2[stack.peek()], i);
                    stack.pop();
                }
                stack.push(i);
            }

            //再遍历nums1数组
            for (int i = 0; i < nums1.length; i++) {
                int index = map.getOrDefault(nums1[i], -1);
                res[i] = index == -1 ? -1 : nums2[index];
            }
            return res;
        }
    }


    // 单调栈：这题先遍历nums1还是nums2都是可以的
    // 如果先遍历nums1：就要先用map记录一下nums1中元素的角标，方便遍历nums2中找到下一个最大值的时候能赋值给res数组
    // 如果先遍历nums2：就要先用map记录一下nums2中全部元素的下一个最近大的角标，方便遍历nums1时快速找到那个值。


    class Solution2 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> temp = new Stack<>();
            int[] res = new int[nums1.length];
            Arrays.fill(res,-1);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0 ; i< nums1.length ; i++){
                hashMap.put(nums1[i],i);
            }
            temp.add(0);
            for (int i = 1; i < nums2.length; i++) {
                if (nums2[i] <= nums2[temp.peek()]) {
                    temp.add(i);
                } else {
                    while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]) {
                        if (hashMap.containsKey(nums2[temp.peek()])){
                            Integer index = hashMap.get(nums2[temp.peek()]);
                            res[index] = nums2[i];
                        }
                        temp.pop();
                    }
                    temp.add(i);
                }
            }

            return res;
        }
    }

}
