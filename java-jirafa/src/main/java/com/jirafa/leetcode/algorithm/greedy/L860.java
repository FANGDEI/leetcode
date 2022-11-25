package com.jirafa.leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/lemonade-change/
 */
public class L860 {
    int five=0,ten=0,twenty=0;
    public boolean lemonadeChange(int[] bills) {
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five!=0){
                    ten++;
                    five--;
                    continue;
                }
                return false;
            }else if(bills[i]==20){
                if(five>0&&ten>0){
                    twenty++;
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                    twenty++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L860().lemonadeChange(new int[]{5,5,5,10,20}));
    }
}
