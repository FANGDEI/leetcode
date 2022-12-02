package com.jirafa.leetcode.algorithm.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-labels/
 */

public class L763 {
    public List<Integer> partitionLabels(String s) {
        LinkedList<Integer> ints = new LinkedList<>();
        int[] edge=new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i]-'a']=i;
        }

        int index = 0;
        int last=-1;
        for (int i = 0; i < chars.length; i++) {
            index=Math.max(index,edge[chars[i]-'a']);
            if(i==index){
                ints.add(i-last);
                last=i;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        L763 l763 = new L763();
        System.out.println(l763.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
