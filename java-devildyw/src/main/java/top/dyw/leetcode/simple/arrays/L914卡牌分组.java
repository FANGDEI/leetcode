package top.dyw.leetcode.simple.arrays;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-06-30-11:27
 * <p>
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有X张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回true。
 */
@SuppressWarnings("all")
public class L914卡牌分组 {
    public static void main(String[] args) {
        System.out.println(new L914卡牌分组().hasGroupsSizeX01(new int[]{1, 2, 2, 3, 3, 4, 4, 4, 3, 2, 1, 1}));
    }

    /**
     * 暴力
     * 考虑: 1. 按X张分成1组或多组 那么数组的长度必然是X的倍数
     * 2. 可能会出现整个数组只有一种数组的情况 所以X可能就会N
     * 3. 可能会出现某个或多个数字可以在满足一组X个的情况下分成多组
     * 4. 只要有一种情况满足即可
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        //根据题目要求初始化一个10的四次方大小的数组
        int[] count = new int[10000];
        //该数组用于存储每个数字在原数组中出现的次数
        for (int i : deck) {
            count[i]++;
        }

        //创建一个ArrayList用于存储刚刚数组存储的每个数组在原数组中出现的次数主要的目的是为了去掉那些出现次数为0的数字
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }
        //我们从 2 开始，从小到大枚举 X。 枚举到n是为了应对整个数组只有一种数字
        //之所以从2开始是因为 题目要求每组至少2个
        for (int X = 2; X <= n; X++) {
            //由于每一组都有 X 张牌，那么 N 必须是卡牌总数 X 的倍数
            if (n % X == 0) {
                //满足倍数条件 进入下一步判断
                boolean flag = true;
                //遍历values线性表
                for (Integer value : values) {
                    //由题可知 每组都有X张牌 如果满足条件 但是会有相同的数字可以分多个组的时候 所以判断条件就为value%X = 0  符合要求
                    if (value % X != 0) {
                        //如果有一个不满足 那么flag就为false
                        flag = false;
                        break;
                    }
                }
                //遍历结束判断flag是否为true 如果为true则返回 说明有一种X的情况可以满足 如果是false则继续寻找 直到找不到才返回false
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 最大公约数法
     * <p>
     * 由上述方法我们可以知道 X一定是每个数字出现次数的因数
     * 所以只要能够找到所有存在数组中每个数字出现次数的公约数且这个公约数的值是>=2的即可
     * <p>
     * <p>
     * 因此我们只要求出所有 counti 最大公约数 g，判断 g 是否大于等于 2 即可，如果大于等于 2，则满足条件，否则不满足。
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX01(int[] deck) {
        //老样子先初始化一个数组记录所有存在数字的出现次数
        int[] count = new int[10000];

        for (int i : deck) {
            count[i]++;
        }

        //初始化最大公约数
        int g = -1;

        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                //初始化g
                if (g == -1) {
                    g = count[i];
                } else {
                    //找到两个数的最大公约数
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    /**
     * 找出两个数的最大公约数
     *
     * @param g
     * @param i
     * @return
     */
    private int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
