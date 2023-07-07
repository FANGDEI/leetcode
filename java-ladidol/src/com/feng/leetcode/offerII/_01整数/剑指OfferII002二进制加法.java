package com.feng.leetcode.offerII._01整数;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/1 18:02
 * @description: {}
 */
public class 剑指OfferII002二进制加法 {
    //双指针
    class Solution {
        /**
         * 注意处理进位，进位可以用val/2来表示
         *
         * @param a
         * @param b
         * @return
         */
        public String addBinary(String a, String b) {
            char[] numA = a.toCharArray();
            char[] numB = b.toCharArray();
            int idxA = numA.length - 1;//倒着来
            int idxB = numB.length - 1;
            int up = 0;
            StringBuilder res = new StringBuilder();
            while (idxA >= 0 && idxB >= 0) {
                int sum = numA[idxA] - '0' + numB[idxB] - '0' + up;
                res.append(sum % 2);
                up = sum / 2;//1的话除法不保留小数就变成零。
                idxA--;
                idxB--;
            }
            while (idxA >= -0) {
                int sum = numA[idxA] - '0' + up;
                res.append(sum % 2);
                up = sum / 2;
                idxA--;
            }
            while (idxB >= -0) {
                int sum = numB[idxB] - '0' + up;
                res.append(sum % 2);
                up = sum / 2;
                idxB--;
            }
            if (up > 0) res.append('1');//最后一个高位进位
            return res.reverse().toString();
        }
    }
}
