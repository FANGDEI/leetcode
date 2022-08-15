package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L134加油站
 * @author: Ladidol
 * @description: 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * 示例1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * @date: 2022/8/14 14:58
 * @version: 1.0
 */
public class L134加油站 {

    //注意理解gas[i]和cost[i]所代表的意思。

    //暴力遍历，不过可以学习一下这个思路。
    class Solution1 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for (int i = 0; i < gas.length; i++) {
                int cur = gas[i];
                int curIndex = i;
                while (cur - cost[curIndex] >= 0) {//能否到下一站。
                    cur = cur + gas[(curIndex + 1) % gas.length] - cost[curIndex];//减去花费的加上新的点的补给
                    curIndex = (curIndex + 1) % gas.length;
                    if (curIndex == i) return i;//如果回来了就对。
                }
            }
            return -1;
        }
    }

    //不正宗！
    //直接从全局进行贪心选择，情况如下：
    //情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
    //情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
    //情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能这个负数填平，能把这个负数填平的节点就是出发节点。
    class Solution2 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            //略
            //全局贪心有点不懂，情况三为啥就是正确的呀。
            return -1;
        }
    }

    //正宗！
    //贪心
    //可以换一个思路，首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，说明 各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。
    //那么为什么一旦[i，j] 区间和为负数，起始位置就可以是j+1呢，j+1后面就不会出现更大的负数？
    //如果出现更大的负数，就是更新j，那么起始位置又变成新的j+1了。
    //而且j之前出现了多少负数，j后面就会出现多少正数，因为耗油总和是大于零的（前提我们已经确定了一定可以跑完全程）。
    //那么局部最优：当前累加rest[j]的和curSum一旦小于0，起始位置至少要是j+1，因为从j开始一定不行。全局最优：找到可以跑一圈的起始位置。
    //局部最优可以推出全局最优，找不出反例，试试贪心！
    class Solution {
        //有用到暴力解法中的rest一定>=0的情况。
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curSum = 0;
            int total = 0;
            int resIndex = 0;
            for (int i = 0; i < gas.length; i++) {
                curSum += gas[i] - cost[i];
                total += gas[i] - cost[i];
                if (curSum < 0) {//违反每一个rest[i]都大于零的情况，重置resIndex
                    resIndex = i + 1;
                    curSum = 0;
                }
            }
            if (total < 0) return -1;
            return resIndex;
        }
    }
}
