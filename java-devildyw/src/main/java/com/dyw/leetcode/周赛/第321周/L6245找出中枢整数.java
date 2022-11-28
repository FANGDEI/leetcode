package com.dyw.leetcode.周赛.第321周;

/**
 * @author Devil
 * @since 2022-11-27-10:39
 */
@SuppressWarnings("all")
public class L6245找出中枢整数 {
    public static void main(String[] args) {
        System.out.println(new L6245找出中枢整数().pivotInteger(4));
    }

    public int pivotInteger(int n) {
        if (n<=0){
            return -1;
        }

        int i = 1;
        int ans = 0;
        while (i<=n){
            int sum1 = 0;
            int j = 1;
            while (j<=i){
                sum1+=j++;
            }
            int k = i;
            int sum2 = 0;
            while (k<=n){
                sum2+=k++;
            }
            if (sum1==sum2){
                return i;
            }

            i++;
        }
        return -1;
    }
}
