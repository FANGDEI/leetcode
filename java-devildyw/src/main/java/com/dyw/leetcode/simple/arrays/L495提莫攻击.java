package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-18-15:59
 * <p>
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * <p>
 * 当提莫攻击艾希，艾希的中毒状态正好持续duration 秒。
 * <p>
 * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。
 * 如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
 * <p>
 * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，
 * 以及一个表示中毒持续时间的整数 duration 。
 * <p>
 * 返回艾希处于中毒状态的 总 秒数。
 */
@SuppressWarnings("all")
public class L495提莫攻击 {
    public static void main(String[] args) {
        new L495提莫攻击().findPoisonedDuration01(new int[]{1, 4}, 2);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int length = timeSeries.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && timeSeries[i + 1] - timeSeries[i] >= duration) {
                res += duration;
            } else if (i + 1 < length && timeSeries[i + 1] - timeSeries[i] < duration) {
                res += timeSeries[i + 1] - timeSeries[i];
            }
        }
        res += duration;
        return res;
    }

    public int findPoisonedDuration01(int[] timeSeries, int duration) {
        int res = 0;
        int expired = 0; //上次中毒结束时间
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= expired) { //如果大于上次中毒结束时间 那么时间没有重叠
                res += duration;
            } else {//如果小于上次中毒事件, 那么中毒事件有重叠 那么计算出没有重叠部分相加即可.
                res += timeSeries[i] + duration - expired;
            }
            //更新中毒结束时间
            expired = timeSeries[i] + duration;
        }
        return res;
    }
}
