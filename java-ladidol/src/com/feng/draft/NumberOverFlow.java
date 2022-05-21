package com.feng.draft;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: NumberOverFlow
 * @author: Ladidol
 * @description:
 * long（长整型）的数据范围：-9223372036854775808——9223372036854775807；
 * int（整型）的数据范围：-2147483648——2147483647；
 * short（短整型）：-32768——32767；
 * byte（位）：-128——127；
 * char（字符型）：0——65536；
 * float（单精度浮点型）：-3.4E38（-3.4X10的38次方）——3.4E38（3.4X10的38次方）；
 * double（双精度浮点型）：-1.7E38——1.7E38；
 * @date: 2022/5/20 11:43
 * @version: 1.0
 */
public class NumberOverFlow {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(x*x);//-837308191
        System.out.println((long)x*x);//4611307858604568801

    }
}
