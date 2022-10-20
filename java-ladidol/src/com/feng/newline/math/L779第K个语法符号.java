package com.feng.newline.math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/20 20:15
 * @description: 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 */
public class L779第K个语法符号 {

    //递归(MLE)内存不够了。
    class Solution12 {
        /**
         * 参数：[n, k]
         * 返回值：int
         * 作者： ladidol
         * 描述：直接通过队列，来存，像二叉树层序遍历一样。前一行中的0替换为01，1替换为10
         */
        public int kthGrammar(int n, int k) {
            dfs(n, k, new StringBuilder("0"));
            return ans;
        }

        int ans = -1;

        void dfs(int n, int k, StringBuilder s) {
            if (n < 1) return;
            if (n == 1) ans = s.charAt(k-1) - '0';

            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') next.append("01");
                else next.append("10");
            }
            dfs(n - 1, k, next);
        }
    }


    //什么数学题，怎么可以这么优雅啊。
    class Solution {
        public int kthGrammar(int n, int k) {
            if(n == 1) return 0;
            int fa = kthGrammar(n-1,(k+1)/2);
            if(fa == 0){
                return k % 2 == 1 ? 0 : 1;
            }else{
                return k % 2 == 1 ? 1 : 0;
            }
        }
    }


}