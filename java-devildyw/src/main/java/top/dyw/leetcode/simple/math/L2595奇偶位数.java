package top.dyw.leetcode.simple.math;

import org.springframework.security.core.parameters.P;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/02/20 10:03
 **/
@SuppressWarnings("all")
public class L2595奇偶位数 {

    public static void main(String[] args) {
        int[] ints = new L2595奇偶位数().evenOddBit(2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] evenOddBit(int n) {
        int count = 0;
        int even = 0;
        int odd = 0;
        while (n!=0){
            if ((n & 1) == 1){
                if (count % 2 == 0){
                    even++;
                }else {
                    odd++;
                }
            }
            n = n >> 1;
            count++;
        }
        return new int[]{even, odd};
    }
}
