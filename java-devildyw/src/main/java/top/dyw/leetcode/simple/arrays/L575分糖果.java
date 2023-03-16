package top.dyw.leetcode.simple.arrays;

import java.util.HashSet;

/**
 * @author Devil
 * @date 2022-05-20-13:42
 * <p>
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，
 * 所以前去拜访了一位医生。
 * <p>
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
 * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * <p>
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，
 * 可以吃到糖的 最多 种类数。
 */
@SuppressWarnings("all")
public class L575分糖果 {
    public static void main(String[] args) {

    }

    /**
     * 用hashset来存储糖的种类
     * 最后返回set.length和candyType.length/2中的最小值
     */
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> type = new HashSet<>();
        for (int i : candyType) {
            type.add(i);
        }
        return Math.min(type.size(), candyType.length / 2);
    }
}
