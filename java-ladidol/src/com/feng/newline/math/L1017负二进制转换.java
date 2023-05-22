package com.feng.newline.math;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/18 22:52
 * @description: {}
 */
public class L1017负二进制转换 {


    //通用方法
    class Solution {
        public String baseNeg2(int n) {
            // 适用于k进制，k为正数负数都可以,本题是负二进制
            int k = -2;

            StringBuilder ans = new StringBuilder();
            while(n != 0)
            {
                int remain= n % k;
                // 1.余数为负数时，需要变为正数
                ans.insert(0, remain < 0 ? -k + remain : remain );
                // 2.在步骤1中，余数为负数时，加上了-k，那么商的话需要加上k来抵消，因为商多增1就代表在后面的那位上多加了k，所以商加一即可达到加上k来抵消。
                n = remain < 0 ? n / k + 1 : n / k;
            }
            return ans.toString().isEmpty() ? "0" : ans.toString();
        }
    }

}
