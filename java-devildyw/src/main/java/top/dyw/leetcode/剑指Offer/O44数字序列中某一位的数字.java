package top.dyw.leetcode.剑指Offer;

import top.dyw.leetcode.simple.string.L657机器人能否返回原点;

/**
 * @author Devildyw
 * @date 2023/05/27 17:44
 **/
@SuppressWarnings("all")
public class O44数字序列中某一位的数字 {

    public static void main(String[] args) {
        System.out.println(new O44数字序列中某一位的数字().findNthDigit(11));
    }

    /**
     * 数学
     * <img src="https://pic.leetcode-cn.com/2cd7d8a6a881b697a43f153d6c10e0e991817d78f92b9201b6ab71e44cb619de-Picture1.png"/>
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1; //位数 这里的位数指的是 1-9 这个位数
        long start = 1; //用于计算当前最高位
        long count = 9; //位数数量
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9; //递推公式计算位数
        }
        long num = start + (n - 1) / digit; //得出最终数字
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
