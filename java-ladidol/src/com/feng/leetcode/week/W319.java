package com.feng.leetcode.week;

import com.feng.newline.binarytree.TreeNode;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/11/13 10:35
 * @description:
 */
public class W319 {


    class Solution1 {
        public double[] convertTemperature(double celsius) {
            return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
        }
    }

    /**
     * 参数：
     * 返回值：
     * 作者： ladidol
     * 描述：
     * [3,6,2,7,1]
     * - [3,6]
     * - [3,6,2]
     * - [6]
     * - [6,2]
     * 暴力求解，注意剪枝判断就行了，比如1. 遇见大于k的直接跳过；2. 只要不连续就跳过。
     */
    class Solution22 {
        public int subarrayLCM(int[] nums, int k) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int cur = nums[i];
                if (k % cur != 0) {
                    for (int j = i; j < n; j++) {
                        if (lcm(nums, i, j) == k) ans++;
                        else break;
                    }
                }
            }
            return ans;
        }

        /**
         * 参数：[nums, left, right]
         * 返回值：int
         * 作者： ladidol
         * 描述：遍历法
         */
        int lcm(int[] nums, int left, int right) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }

            for (int i = max; ; i++) {
                boolean b = true;
                for (int j = left; j <= right; j++) {
                    if (max % nums[j] != 0) {
                        b = false;
                        break;
                    }
                }
                max++;
                if (b) {
                    return i;
                }
            }

        }
    }

    class Solution2 {
        public int subarrayLCM(int[] nums, int k) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (k % nums[i] != 0) {
                    int cur = nums[i];
                    for (int j = i; j < n; j++) {

                        if (k % nums[j] != 0) break;//当前数字不能被k整除，直接pass掉。
                        int g = gcd(cur, nums[j]);
                        cur = (cur * nums[j]) / g;//更新最小公倍数的值。
                        if (cur > k) break;
                        if (cur == k) ans++;
                    }
                }
            }
            return ans;
        }

        /**
         * 参数：[a, b]
         * 返回值：int
         * 作者： ladidol
         * 描述：辗转相除法 求 最大公约数
         */
        int gcd(int a, int b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }
    }


    class Solution3 {
        /**
         * 参数：[root]
         * 返回值：int
         * 作者： ladidol
         * 描述：二叉树层序遍历，对每一层的元素进行排序最小次数计数。
         */
        public int minimumOperations(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int curSize = deque.size();
                int n = curSize;
                int[] nums = new int[n];
                while (curSize > 0) {
                    TreeNode cur = deque.poll();
                    nums[n - curSize] = cur.val;
                    if (cur.left != null) deque.offer(cur.left);
                    if (cur.right != null) deque.offer(cur.right);
                    curSize--;
                }
                int curCount = problem(nums);
                ans += curCount;
            }

            return ans;
        }

        int problem(int[] nums) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            //排序并记录每个数的正确位置
            Arrays.sort(temp);
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < temp.length; i++) {
                indexMap.put(temp[i], i);
            }
            //记录该位置是否已访问
            boolean[] isVisited = new boolean[temp.length];
            //寻找循环节个数，即循环节内的数依次交换，即可全部回到正确位置
            int loops = 0;
            for (int i = 0; i < nums.length; i++) {
                if (isVisited[i]) {
                    continue;
                }
                int j = i;
                while (!isVisited[j]) {//把一个环里面的元素的标记一下。
                    isVisited[j] = true;
                    j = indexMap.get(nums[j]);
                }
                loops++;

            }
            //对每一个循环节来说，交换次数为循环节内元素个数减一
            //举例，若nums存在三个循环节，nums元素个数为n，各循环节元素个数为x, y, z
            //则交换次数应为 (x-1)+(y-1)+(z-1)=x+y+z-3=n-3
            //其他情况以此类推，最小交换次数为数组元素个数-循环节个数
            return nums.length - loops;
        }
    }


}