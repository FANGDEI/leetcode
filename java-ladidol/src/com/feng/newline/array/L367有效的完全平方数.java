package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L367有效的完全平方数
 * @author: Ladidol
 * @description: 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * @date: 2022/5/20 11:46
 * @version: 1.0
 */
public class L367有效的完全平方数 {
    public static void main(String[] args) {
        System.out.println(new L367().isPerfectSquare(808201));
    }
}

class L367 {
    //就是一个普通的二分查找法哦
    public boolean isPerfectSquare(int num) {
        if(num == 0)return false;
        if(num == 1)return true;
        int l = 0;
        int r = num/2;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((long)mid * mid == num) {//注意两个地方都需要强转
                return true;
            } else if ((long)mid * mid < num) {//这里
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}