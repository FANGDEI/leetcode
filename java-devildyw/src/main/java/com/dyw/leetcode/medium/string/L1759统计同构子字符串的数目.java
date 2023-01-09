package com.dyw.leetcode.medium.string;

import java.util.ArrayList;

/**
 * @author Devil
 * @since 2022-12-26-11:47
 */
@SuppressWarnings("all")
public class L1759统计同构子字符串的数目 {

    public static void main(String[] args) {
        System.out.println(new L1759统计同构子字符串的数目().countHomogenous("abbcccaa"));
    }

    /**
     * 先按照连续的相同的字符串将字符串进行分组
     * 再按照规律将次数计入 最后返回结果
     * @param s
     * @return
     */
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        long result = 0;
        int n = s.length();
        int start = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)==s.charAt(start)){
                continue;
            }else{
                list.add(s.substring(start,i));
                start = i;
            }
        }
        list.add(s.substring(start,n));

        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i).length();
            result+=(long)(1+m)*m/2;
        }
        return (int)(result%MOD);
    }


}
