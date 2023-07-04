package com.feng.draft.垃;


/**
 * @auther xiaoqiang-ladidol
 * @date 2023/3/30
 */
public class testSecond {
    public static void main(String[] args) {

        String MAX = Integer.toBinaryString(0b1010101010101010101010101010101);
        String MAX_N = Integer.toBinaryString(0b1010101010101010101010101010101 - 11);
        System.out.println("MAX = " + MAX);
        System.out.println("MAX_N = " + MAX_N);
        System.out.println("MAX^MAX_N = " + Integer.toBinaryString(Integer.valueOf("0b" + MAX) ^ Integer.valueOf("0b" + MAX_N)));


//        System.out.println(
//                Integer.toBinaryString(
//                        0b1010101010101010101010101010101
//                                ^
//                                (0b1010101010101010101010101010101 - 11)
//                )
//        );
    }

    class Solution {
        private static final int MAX = 0b1010101010101010101010101010101;

        public String baseNeg2(int n) {
            return Integer.toBinaryString(MAX ^ MAX - n);
        }
    }

}