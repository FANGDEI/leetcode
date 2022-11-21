package com.feng.newline.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ladidol
 * @date: 2022/11/21 20:25
 * @description: 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的 汤A 和 0ml 的 汤B 。
 * 提供 75ml 的 汤A 和 25ml 的 汤B 。
 * 提供 50ml 的 汤A 和 50ml 的 汤B 。
 * 提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意 不存在先分配 100 ml 汤B 的操作。
 * <p>
 * 需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * 示例 1:
 * 输入: n = 50
 * 输出: 0.62500
 * 解释:如果我们选择前两个操作，A 首先将变为空。
 * 对于第三个操作，A 和 B 会同时变为空。
 * 对于第四个操作，B 首先将变为空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * 示例 2:
 * 输入: n = 100
 * 输出: 0.71875
 * 提示:
 * 0 <= n <= 109​​​​​​​
 */
public class L808分汤 {

    //概率论（全概率公式）+记忆性搜索【java tle】
    class Solution {

        public double soupServings(int n) {
            if (n >= 5000) return 1;
            return dfs(n, n);
        }

        Map<String, Double> cache = new HashMap<>();

        /**
         * 作者：Ladidol
         * 描述：每一种汤的剩余量a，b
         * prob(a, b) = prob(a1, b1)*0.25 + prob(a2, b2)*0.25 + prob(a3, b3)*0.25 + prob(a4, b4)*0.25
         * <p>
         * 记忆化搜索就很神奇：
         */
        double dfs(int a, int b) {
            //A先倒完
            if (a <= 0 && b > 0) return 1;
            //同时倒完
            if (a <= 0 && b <= 0) return 0.5;
            //B先倒完
            if (a > 0 && b <= 0) return 0;
            //记忆化
            String key = String.valueOf(a) + b;
            if (cache.containsKey(key)) return cache.get(key);

            double prob = 0;
            prob += dfs(a - 100, b);
            prob += dfs(a - 75, b - 25);
            prob += dfs(a - 50, b - 50);
            prob += dfs(a - 25, b - 75);

            prob *= 0.25;
            return prob;

        }
    }
    class Solution1 {
        public double soupServings(int n) {
            n = Math.min(200, (int) Math.ceil(n / 25.0));
            double[][] f = new double[n + 10][n + 10];
            f[0][0] = 0.5;
            for (int j = 1; j <= n; j++) f[0][j] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    double a = f[Math.max(i - 4, 0)][j], b = f[Math.max(i - 3, 0)][Math.max(j - 1, 0)];
                    double c = f[Math.max(i - 2, 0)][Math.max(j - 2, 0)], d = f[Math.max(i - 1, 0)][Math.max(j - 3, 0)];
                    f[i][j] = 0.25 * (a + b + c + d);
                }
            }
            return f[n][n];
        }
    }
}