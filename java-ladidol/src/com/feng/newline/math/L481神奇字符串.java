package com.feng.newline.math;

/**
 * @author: ladidol
 * @date: 2022/10/31 16:24
 * @description: 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * <p>
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每
 * 组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 通过次数23,514提交次数36,855
 */


public class L481神奇字符串 {

    //双指针
    class Solution {
        /**
         * 参数：[n]
         * 返回值：int
         * 作者： ladidol
         * 描述：通过双指针，一个指向当前位置，一个指向s串末尾，2022年10月31日16:25:49
         */
        public int magicalString(int n) {
            int N = 100005;
            char[] s = new char[N];
            s[0] = 1;
            s[1] = s[2] = 2;
            char c = 1;
            //先构造
            for (int i = 2, j = 3; j < N; i++) {
                c = (char) ((i & 1) == 0 ? 1 : 2);
                s[j++] = c;
                if (s[i] == 2) s[j++] = c;
            }

            //再查询有多少个1
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += s[i] == 1 ? 1 : 0;
            }
            return ans;
        }
    }


    //双指针，静态构造
    static class Solution123 {
        //静态构造
        static int N = 100005;
        static char[] s = new char[N];
        static{
            s[0] = 1;
            s[1] = s[2] = 2;
            char c = 1;
            //先构造
            for (int i = 2, j = 3; j < N; i++) {
                c = (char) ((i & 1) == 0 ? 1 : 2);
                s[j++] = c;
                if (s[i] == 2) s[j++] = c;
            }
        }

        /**
         * 参数：[n]
         * 返回值：int
         * 作者： ladidol
         * 描述：通过双指针，一个指向当前位置，一个指向s串末尾，2022年10月31日16:25:49
         */
        public int magicalString(int n) {

            //再查询有多少个1
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += s[i] == 1 ? 1 : 0;
            }
            return ans;
        }
    }


}