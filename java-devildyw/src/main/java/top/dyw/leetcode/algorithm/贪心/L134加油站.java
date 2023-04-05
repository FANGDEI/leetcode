package top.dyw.leetcode.algorithm.贪心;

/**
 * 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * @author Devil
 * @since 2022-10-22-13:35
 */
@SuppressWarnings("all")
public class L134加油站 {

    public static void main(String[] args) {
        System.out.println(new L134加油站().canCompleteCircuit02(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    /**
     * 暴力
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            int rest = gas[i] - cost[i]; //记录剩余油量
            int index = (i + 1) % cost.length;
            while (rest > 0 && index != i) { //模拟以i为起点行驶一圈
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            //如果以i为起点跑了一圈，剩余油量>=0，则返回该起始位置
            if (rest >= 0 && index == i) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 不算贪心的贪心
     * 直接从全局进行贪心选择，情况如下：
     * <p>
     * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
     * <p>
     * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
     * <p>
     * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能这个负数填平，能把这个负数填平的节点就是出发节点。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit01(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;

        for (int i = 0; i < gas.length; i++) {
            sum+=(gas[i]-cost[i]);
            min = Math.min(sum,min);
        }

        if (sum<0) return -1;
        if (min>=0) return 0;

        for (int i = gas.length-1; i>0;i--){
            min+=(gas[i]-cost[i]);
            if (min>=0) return i;
        }

        return -1;
    }

    /**
     * 贪心：
     * 当前累加rest[j]的和curSum一旦小于0，起始位置至少要是j+1，因为从j开始一定不行。全局最优：找到可以跑一圈的起始位置。
     * curSum 小于0说明从当前起始位置出发 会在一点的油量不满足消耗量 所以我们从起始位置的下一个位置作为新的起始位置 重新计算curSum 如果总消耗量小于总油量 那么一定存在某一个起始位置后面 一定curSum 是一直大于0的
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit02(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum +=gas[i]-cost[i];
            totalSum += gas[i]-cost[i];
            //如果curSum<0 就要将起始位置更新为 index+1 并从该起始位置开始重新计算curSum
            if (curSum<0){
                index = (i+1)%gas.length;
                curSum = 0;
            }
        }
        //如果消耗量大于油量肯定是不能跑完一周的
        if (totalSum<0)  return -1;
        //执行到这里说明一定可以跑完一圈 到最后会返回一个起始位置 该起始位置能使得curSum>0
        return index;

    }
}
