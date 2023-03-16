package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-21-16:14
 * <p>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？
 * 能则返回 true ，不能则返回 false。
 * 1 1 1 0 1 1
 */
@SuppressWarnings("all")
public class L605种花问题 {
    public static void main(String[] args) {
        System.out.println(new L605种花问题().canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

    /**
     * 贪心 判断后面是否种花 如果没有就种
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            //如果当前位置没有种花 且该位置为边界或者后一个元素为0 那么该位置就种花
            if (flowerbed[i] == 0 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                //n-- 种花
                n--;
                //多跳一格
                i++;
            } else if (flowerbed[i] == 1) {
                //多跳一格
                i++;
            }

        }
        return n <= 0;
    }

    /**
     * 贪心:
     * 如果边界且相邻一格没有种花就种
     * 如果不是边界前后都没有种花就种
     */
    public boolean canPlaceFlowers01(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }
}
