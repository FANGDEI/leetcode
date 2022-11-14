package com.dyw.leetcode.medium.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Devil
 * @since 2022-11-13-12:15
 */
@SuppressWarnings("all")
public class L791自定义字符串排序 {

    public static void main(String[] args) {

    }

    /**
     * 官方题解
     * @param order
     * @param s
     * @return
     */
    public String customSortString(String order, String s) {
        int[] val = new int[26];
        /**
         * 首先遍历 order 字符串，将第一个出现的字符赋值为 1，第二个出现的字符复制为 2 以此类推 未出现的字符默认权值未0；
         */
        for (int i = 0; i < order.length(); i++) {
            val[order.charAt(i)-'a'] = i+1;
        }
        //将字符串转换为 Character 数组 方便使用 Java 库中的sort方法
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        //自定义排序
        Arrays.sort(arr,(a,b)->{
            return val[a-'a']-val[b-'a'];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * 我自己的解法与官方题解的思路相似 只不过我使用的是 map 存储 order 中遍历的字符和下标
     * @param order
     * @param s
     * @return
     */
    public String customSortString01(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i+1);
        }

        //将字符串转换未字符数组
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        //自定义排序
        Arrays.sort(arr,(a,b)->{
            return map.getOrDefault(a,0) - map.getOrDefault(b,0);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
