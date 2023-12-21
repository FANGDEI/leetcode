package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/12/21 21:09
 **/
@SuppressWarnings("all")
public class L66加一 {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int[] newOne = new int[digits.length+1];

        int i = digits.length-1;
        int j = newOne.length-1;
        int carry = 1;

        while (i>=0||carry!=0){
            int temp = 0;
            if (i>=0){
                temp = digits[i--];
            }
            int result = temp + carry;
            newOne[j--] = result % 10;
            carry = result/10;
        }

        return newOne[0]>0? newOne:Arrays.copyOfRange(newOne,1,newOne.length);
    }
}
