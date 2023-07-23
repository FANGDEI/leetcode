package com.feng.leetcode.week;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/23 10:31
 * @description: {}
 */
public class W355 {


    //第二题 合并后数组中的最大元素
    class Solution {
        /**
         * 贪心的话，就是从后面一个一个遍历试试,尽可能让后面的数字为合并起点。
         *
         * @param nums
         * @return
         */
        public long maxArrayValue(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                int tmp = nums[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (tmp >= nums[j]) tmp += nums[j];
                    else break;
                }
                ans = Math.max(ans, tmp);
            }
            return ans;
        }
    }

    class Solution22 {
        /**
         * 双层for，超时
         *
         * @param nums
         * @return
         */
        public int maxArrayValue(int[] nums) {
            int n = nums.length;
            long[] dp = new long[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = nums[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[i] >= nums[j]) {
                        dp[i] += nums[j];
                    } else {
                        break;
                    }
                }
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            return (int) dp[n - 1];
        }
    }

    class Solution222 {
        public long maxArrayValue(int[] nums) {
            int n = nums.length;
            long[] tmps = new long[n];
            tmps[n - 1] = nums[n - 1];
            long ans = nums[n - 1];
            //从后面往前面遍历
            for (int i = n - 1; i > 0; i--) {
                if (tmps[i] >= nums[i-1]) {
                    tmps[i - 1] = tmps[i] + nums[i-1];
                } else {
                    tmps[i - 1] = nums[i-1];//重新开始
                }
                ans = Math.max(ans, tmps[i - 1]);
            }
            return ans;
        }
    }
    class Solution2 {
        public long maxArrayValue(int[] nums) {
            int n = nums.length;
            long tmp = nums[n - 1];
            long ans = nums[n - 1];
            //从后面往前面遍历
            for (int i = n - 1; i > 0; i--) {
                if (tmp >= nums[i-1]) {
                    tmp = tmp + nums[i-1];
                } else {
                    tmp = nums[i-1];//重新开始
                }
                ans = Math.max(ans, tmp);
            }
            return ans;
        }
    }





    class Solution11 {
        String sep = "";

        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> res = new LinkedList<>();

            switch (separator) {
                case '.':
                    sep = "\\.";
                    break;
                case ',':
                    sep = ",";
                    break;
                case '|':
                    sep = "\\|";
                    break;
                case '$':
                    sep = "\\$";
                    break;
                case '#':
                    sep = "#";
                    break;
                default:
                    sep = "@";
                    break;
            }


            for (String word : words) {
                String[] split = word.split(sep+separator);
                for (String s : split) {
                    if (!"".equals(s)) {
                        res.add(s);
                    }
                }
            }
            return res;
        }
    }


}
