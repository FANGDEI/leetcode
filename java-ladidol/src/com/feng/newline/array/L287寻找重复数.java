package com.feng.newline.array;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/10/7 11:10
 * @description: 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 提示：
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * 进阶：
 * <p>
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
public class L287寻找重复数 {

    //不符合要求。多开了一个数组。
    class Solution1 {
        public int findDuplicate(int[] nums) {
            int[] cache = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (cache[nums[i]] == 1) return nums[i];
                else cache[nums[i]] = 1;
            }
            return -1;
        }
    }


    //利用L142环形链表II的快慢指针。空间用了o（1）
    class Solution2 {

        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：可以看多赞题解：主要是这题特殊的1-n的构成，显然可以通过下标和数值进行链表类比。
         */
        public int findDuplicate(int[] nums) {
            int fast = 0;
            int slow = 0;

            fast = nums[nums[fast]];
            slow = nums[slow];
            while (fast != slow) {
                fast = nums[nums[fast]];
                slow = nums[slow];
            }
            //一定能走到相同的位置。
            int index1 = fast;
            int index2 = 0;

            while (index1 != index2) {
                index1 = nums[index1];
                index2 = nums[index2];
            }
            return index1;
        }
    }

    //原地哈希（虽然不符合要求，但是帅就完事了。)
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：根据题意，nums[idx] = t，其中 idx = t - 1；第一次遍历，根据这个修改数组，如果碰见重复修改的情况，就说明t为重复元素。
         */
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; ) {//要保证swap过来的数字也符合要求，所以i++放于特定地方。
                int t = nums[i];
                int idx = t - 1;
                if (nums[idx] == t && i != idx) {//需要呆的地方依旧有人了。
                    return t;
                }
                //有可能是本身就满足idx = t - 1的情况，就直接跳过就行。
                if (nums[idx] == t && i == idx) {
                    i++;
                } else if (nums[idx] != t) {
                    swap(nums, i, idx);
                }
            }
            return -1;
        }

        void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}