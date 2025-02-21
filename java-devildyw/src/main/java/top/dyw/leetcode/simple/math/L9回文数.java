package top.dyw.leetcode.simple.math;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/01/03 10:24
 **/
@SuppressWarnings("all")
public class L9回文数 {

    public static void main(String[] args) {
        System.out.println(new L9回文数().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int p = x, cur = 0;
        while (p != 0){
            cur = cur * 10 + p % 10;
            p /= 10;
        }
        return cur == x;
    }

}
