package com.jirafa.leetcode.algorithm.贪心;

import java.util.Arrays;

public class L455 {

    //先从大的开始遍历
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);


        int index=s.length-1;
        int result=0;

        for (int i = g.length-1; i >= 0; i--) {
            if(index>=0&&s[index]>=g[i]){
                result++;
                index--;
            }
        }

        return result;
    }

    //从小的开始遍历
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index=0;

        for(int i: s){
            if(index<g.length&&i>=g[index]){
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(new L455().findContentChildren2(new int[]{10,9,8,7},new int[]{5,6,7,8}));
    }
}
