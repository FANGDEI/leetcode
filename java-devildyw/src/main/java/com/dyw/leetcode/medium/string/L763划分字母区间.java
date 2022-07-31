package com.dyw.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-31-11:43
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 */
@SuppressWarnings("all")
public class L763划分字母区间 {
    public static void main(String[] args) {
        System.out.println(new L763划分字母区间().partitionLabels01("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //通过遍历记录每个字符在字符串中最后出现的位置
        for (int i = 0; i < length; i++) {
            last[s.charAt(i)-'a'] = i;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        //初始化start 和 end
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            //不断更新end 去出索引i对应的字符出现的最后位置 与当前end作比较取最大值 不断更新片段
            end = Math.max(end,last[s.charAt(i)-'a']);
            //直到更新end后索引i与end相等 说明此时end就会该片段的末尾了中途没有索引i将片段扩大 现在的索引i都是上一个片段中字符出现的最末尾位置了
            //所以将长度加入列表
            if (i==end){
                integers.add(end-start+1);
                //更新start
                start = end+1;
            }
        }

        return integers;
    }

    public List<Integer> partitionLabels01(String s) {
        int[] ints = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            ints[s.charAt(i)-'a'] = i;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end,ints[s.charAt(i)-'a']);
            if (end == i){
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }
}
