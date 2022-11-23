package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-11-23-9:45
 */
@SuppressWarnings("all")
public class L1742盒子中小球的最大数量 {
    public static void main(String[] args) {
        System.out.println(new L1742盒子中小球的最大数量().countBalls(1, 10));
    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] box = new int[highLimit];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            if (num>=10){
                while (num!=0){
                    sum+=num%10;
                    num/=10;
                }
            }else{
                sum = num;
            }
            box[sum]++;
            max = Math.max(max,box[sum]);
        }
        return max;

    }
}
