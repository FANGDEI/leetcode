package com.dyw.leetcode.algorithm.贪心;

/**
 * 当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
 * <p>
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 * @author Devil
 * @since 2022-10-26-12:55
 */
@SuppressWarnings("all")
public class L738单调递增的数字 {

    public static void main(String[] args) {
        System.out.println(new L738单调递增的数字().monotoneIncreasingDigits(332));
    }

    /**
     * 贪心：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，然后strNum[i]给为9，可以保证这两位变成最大单调递增整数。
     * <p>
     * 同时从右往前遍历strNum[i-1]--也能保证值小于等于原来的数
     * <p>
     * 之所以从前往后遍历是为了防止 从前向后遍历，遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]减一，但此时如果strNum[i - 1]减一了，可能又小于strNum[i - 2]。 例如 332 从前往后遍历变为 329 不符题意
     * <p>
     * 所以从前后向遍历会改变已经遍历过的结果！
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        //将数字转换为字符数组
        char[] chars = String.valueOf(n).toCharArray();

        //指针 决定从那个下标开始将后续下标对应的字符全部换为'9' 因为高位即char[i-1]已经-1 i-1下标后的所有数无论这么变都不会突破n了 所以为了尽可能大于等于n所以借助start指针记录 需要转换字符的下标位置
        int start = chars.length;

        //从后往前遍历 如果 chars[i-1]>chars[i] 就将char[i-1]-- 并且更新start
        for (int i = chars.length-1; i>0; i--){
            if (chars[i]<chars[i-1]){
                chars[i-1]--;
                start = i;
            }
        }

        for (int i = start;i<chars.length;i++){
            chars[i] = '9';
        }

        return Integer.parseInt(String.valueOf(chars));

    }
}
