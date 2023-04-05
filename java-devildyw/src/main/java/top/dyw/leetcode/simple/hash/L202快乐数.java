package top.dyw.leetcode.simple.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * @author Devil
 * @since 2022-09-08-11:20
 */
@SuppressWarnings("all")
public class L202快乐数 {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        //用 set 来避免无限循环的情况
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        //如果结果为1则返回true 如果是因为结果重复退出循环则返回false
        return n==1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n>0){
            int temp = n%10;
            res += temp*temp; //平方
            n /= 10;
        }
        return res;
    }


}
