package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-21-12:24
 * <p>
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
 */
@SuppressWarnings("all")
public class L860柠檬水找零 {
    public static void main(String[] args) {
        System.out.println(new L860柠檬水找零().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    /**
     * 使用计数器记录5块的张数和10块的张数 再根据条件分支语句判断情况 用掉那张收到那张
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 >= 1) {
                    count10++;
                    count5--;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (count5 >= 1 && count10 >= 1) {
                    count5--;
                    count10--;
                } else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
