package top.dyw.leetcode.simple.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Devil
 * @since 2022-06-23-13:20
 * <p>
 * 爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，aliceSizes[i]
 * 是爱丽丝拥有的第 i 盒糖果中的糖果数量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
 * <p>
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。
 * 一个人拥有的糖果总数量是他们每盒糖果数量的总和。
 * <p>
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
 * 如果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
 */
@SuppressWarnings("all")
public class L888公平的糖果交换 {
    public static void main(String[] args) {

    }


    /**
     * HashSet
     * <p>
     * alice交换的糖果数量记为x bob交换的糖果数量记为y 由题得到以下等式
     * aliceSum - x + y = bobSum + x - y;
     * 上面式子化简得到 x = y + (aliceSum - bobSum)/2
     * 所以我们通过计算得到aliceSum和bobSum 并将aliceSize的元素存入set中方便查找到符合条件的x
     * 遍历y 通过上述等式去查找set中的x 找到第一个满足条件的即可
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        int n = aliceSizes.length;
        int m = bobSizes.length;

        Set<Integer> rec = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            rec.add(aliceSizes[i]);
            aliceSum += aliceSizes[i];
        }

        for (int i = 0; i < m; i++) {
            bobSum += bobSizes[i];
        }

        int delta = (aliceSum - bobSum) / 2;

        int[] ans = new int[2];
        for (int y : bobSizes) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }

        return ans;
    }
}
