package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L69x的平方根
 * @author: Ladidol
 * @description: 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @date: 2022/5/20 10:50
 * @version: 1.0
 */
public class L69x的平方根 {
    public static void main(String[] args) {
        System.out.println(new L69().mySqrt(2147395599));
    }
}
class L69 {
    public int mySqrt(int x) {
        if (x==0) return 0;
        if (x==1) return 1;
        int left = 0;
        int right = x/2;//这里其实就可以用一半来排除, 前提是前面排除了x==1的情况, 后来发现其实没必要在这里单独列出来
        int ans = -1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if ((long)mid * mid <= x){//这里要注意强转为long类型
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
