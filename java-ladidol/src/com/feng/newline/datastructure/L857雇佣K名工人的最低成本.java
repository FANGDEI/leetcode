package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L857雇佣K名工人的最低成本
 * @author: Ladidol
 * @description: 有 n名工人。给定两个数组quality和wage，其中，quality[i]表示第i名工人的工作质量，其最低期望工资为wage[i]。
 * 现在我们想雇佣k名工人组成一个工资组。在雇佣一组 k名工人时，我们必须按照下述规则向他们支付工资：
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额。在实际答案的10-5以内的答案将被接受。。
 * 示例 1：
 * <p>
 * 输入： quality = [10,20,5], wage = [70,50,30], k = 2
 * 输出： 105.00000
 * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
 * 示例 2：
 * <p>
 * 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
 * 输出： 30.66667
 * 解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
 * 提示：
 * <p>
 * n == quality.length == wage.length
 * 1 <= k <= n <= 104
 * 1 <= quality[i], wage[i] <= 104
 * @date: 2022/9/11 11:11
 * @version: 1.0
 */
public class L857雇佣K名工人的最低成本 {


    // 每个工人都有自己期望的价性比，雇佣K个工人的时候要满足每个人的实际价性比不低于他的期望，即需要按照K个工人中的最高期望价性比给这K个人开工资。
    // 使用了一个大根堆，来获取K个工人的最大的价性比，作为K个工人的价性比，使用qsum保存K个工人的质量和。要给他们付的工资就是qsum * 最大性价比。


    //做不来呜呜呜，我是废物，这个看球不懂。
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int num = quality.length;
            double[][] worker = new double[num][2];

            // worker[性价比][质量]
            for (int i = 0; i < num; i++) {
                worker[i] = new double[]{(double) wage[i] / (double) quality[i], (double) quality[i]};
            }
            // 单位质量里，工资最少的，对于雇主来说，性价比最高
            // 所以按照性价比从高到底排序，也就是性价比这个数值升序排序
            Arrays.sort(worker, (o1, o2) -> Double.compare(o1[0], o2[0]));

            double ans = Integer.MAX_VALUE;
            int sum = 0;

            // 要在多个数中找到最小的几个数，则用大顶堆
            // 遍历是从性价比值最小开始，题目要求花费最小，所以要在所有质量中选择质量最小的k个
            // 因为最终所求答案 = 总的质量和 * 性价比
            // 而性价比是不断增大的，要想所求答案最小，那么总的质量和就要不断减小，所以就用大顶堆，将质量降序排列
            PriorityQueue<Double> pq = new PriorityQueue<>((o1, o2) -> {return Double.compare(o2, o1);});

            // 从性价比最小的开始遍历，也就是雇主最心意的员工开始遍历
            for (double[] w : worker) {
                if (pq.size() == k) {
                    sum -= pq.poll();
                }
                sum += w[1];
                pq.offer(w[1]);
                if (pq.size() == k) {
                    /**
                     * 每一次遍历到的w的性价比是不断增大的
                     * 用当前的性价比（x），去乘以sum
                     * 也就是 x * (qx + q1 + ...)
                     * 首先 x * qx ，保证了满足实际发的工资是等于自己的
                     * 之后的 x * q1 + x * q1 + ...
                     * 因为针对 q1 q1 ... 这些质量来说，他们是比 qx 先进入队列，也就是说，他们的性价比的数值都比 x 低
                     * 那么用 x 去乘以这些质量，肯定比 他们自己的性价比 * 自己的质量 要大，也就保证了满足实际发放的工资 >= 期望工资
                     */
                    ans = Math.min(ans, sum * w[0]);
                }
            }

            return ans;
        }
    }

}
