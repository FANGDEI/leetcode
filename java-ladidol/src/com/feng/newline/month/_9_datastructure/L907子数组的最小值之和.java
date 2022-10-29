package com.feng.newline.month._9_datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L907子数组的最小值之和
 * @author: Ladidol
 * @description: 给定一个整数数组 arr，找到 min(b)的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 * @date: 2022/9/15 19:39
 * @version: 1.0
 */
public class L907子数组的最小值之和 {
    // 先暴力走一波；(TLE)
    class Solution1 {
        // 这其实等价于两层for循环。
        public int sumSubarrayMins(int[] arr) {
            this.arr = arr;
            minArr = new int[arr.length];
            Arrays.fill(minArr, 100000);
            for (int i = 0; i < arr.length; i++) {//以每一个数为起点进行判断后面新加的数字大小。
                dfs(i, 0);
            }
            return sum;
        }

        int sum = 0;
        int[] arr;
        int[] minArr;
        int mod = 1000000007;

        void dfs(int index, int depth) {
            if (depth + index >= minArr.length) return;
            minArr[index] = Math.min(minArr[index], arr[index + depth]);
            sum += minArr[index];
            sum %= mod;
            dfs(index, ++depth);
        }
    }

    // 单调栈 (遍历顺序不一样，这里是代码随想录的遍历顺序)
    class Solution12341234 {
        // A[i]∗(i−left+1)∗(right−i+1)：乘法原理。这里的left和right是边界。
        public int sumSubarrayMins(int[] arr) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] left = new int[arr.length];
            int[] right = new int[arr.length];
            Arrays.fill(left, -1);
            Arrays.fill(right, arr.length);
            int mod = (int) 1e9 + 7;//这种写法的指数表示要记住。没有0！！！
//            int mod = 1000000007;


            //找每个元素的右right边界
            for (int i = 0; i < arr.length; i++) {
                // 特殊点：右边界的判断条件要去等号。
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {//找到待定数中的第一个更小值，就开始赋值为右边界。
                    right[stack.pop()] = i;
                }
                stack.push(i);
            }
            stack.clear();

            //找每一个元素的左left边界
            for (int i = arr.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    left[stack.pop()] = i;
                }
                stack.push(i);
            }

            // 值得注意的是这里超过了int的范围：所以用long
            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                //这里取模很细节！！！！！！要注意
                long tmp = ((long) (i - left[i]) * (long) (right[i] - i) * arr[i] % mod) % mod;
                ans = (ans + tmp) % mod;
            }
            return (int) ans;
        }
    }

    //单调栈
    class Solution {
        /**
         * 参数：[arr]
         * 返回值：int
         * 作者： ladidol
         * 描述：之前用的单调栈，今天就再用一下。2022年10月28日17:10:58
         * <p>
         * 用到乘法原理：看每一个数能作为最小值能影响器左右的范围，用乘法原理得出影响的子数组个数。
         * 值得注意的就是这里尽量用下标来存，
         * [3,1,2,4]，这样左右边界，就可以用默认值-1和n；
         */
        public int sumSubarrayMins(int[] arr) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = arr.length;
            int[] left = new int[n];
            int[] right = new int[n];
            int MOD = (int) (1e9 + 7);

            for (int i = 0; i < n; i++) {//默认左右边长度是到数组边界的距离。
                left[i] = i + 1;
                right[i] = n - i;
            }
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {//注意一个子数组中可能有相同的最小值元素，这里一边取得到相等，一边取不到相等，保证不会重复计算。
                    right[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }

            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    left[stack.peek()] = stack.peek() - i;
                    stack.pop();
                }
                stack.push(i);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                //依旧是这里的取余操作比较神奇。
                ans = (ans + (((long) right[i] * arr[i]) % MOD * left[i]) % MOD) % MOD;
            }
            return (int) ans;
        }
    }
}
