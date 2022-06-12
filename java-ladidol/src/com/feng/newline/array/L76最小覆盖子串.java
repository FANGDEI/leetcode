package com.feng.newline.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L76最小覆盖子串
 * @author: Ladidol
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * @date: 2022/6/12 11:38
 * @version: 1.0
 */
public class L76最小覆盖子串 {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf", t = "cae";
        System.out.println(new Solution1().minWindow(s,t));
        System.out.println(new L76().minWindow(s,t));
    }
}

class L76 {
    public String minWindow(String s, String t) {
        //因为对t中的每个字母的个数有限制所以要记录s中和t中的每个字符的个数
        //不可避免, hashmap写入慢可读性查
        Map<Character,Integer> windowS = new HashMap<>();//记录s中移动窗口字母计数
        Map<Character,Integer> hashT = new HashMap<>();//记录t中

        for (int i = 0; i < t.length(); i++) {
            //经常用到的getOrDefault
            hashT.put(t.charAt(i),hashT.getOrDefault(t.charAt(i),0)+1);
        }
        int front = 0;
        int end = front;
        Map map = new HashMap();
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        String res = "";
        for (end = 0; end < s.length(); end++) {
            //对s中的个数进行遍历的同时分类计数
            windowS.put(s.charAt(end), windowS.getOrDefault(s.charAt(end),0)+1);

            if (hashT.containsKey(s.charAt(end))){//t中有end值, 这里用hashT来判断
                //有的话就, 对应的map.get(end)++
                if (windowS.get(s.charAt(end))<=hashT.get(s.charAt(end))){//取等是为了让后面收缩的机会
                    count++;
                }
            }
            //开始收缩窗口, 不一定能一次收缩就满足结果, 所以这里用到了while循环
            //如果左边界的值不在hashT表中 或者 它在windowS表中的出现次数多于hashT表中的出现次数
            //收缩窗口主要是对左指针front
            while(front< end && (!hashT.containsKey(s.charAt(front))||windowS.get(s.charAt(front))> hashT.get(s.charAt(front)))){
                windowS.put(s.charAt(front),windowS.get(s.charAt(front))-1);
                front++;//窗口收缩;
            }
            //此时滑动窗口windowS中包含t中的全部字符
//            if (count == t.length()){
//                // String s = "cabwefgewcwaefgcf", t = "cae";, 走这个判断方法的话, 会失败的,
//                // 失败原因是, cwae已经确定最小长度的时候, 继续往后面走, 走到aefgc的时候, 发现也满足if条件, 但是, 截取的字符串并不是最短的
//                minLen = Math.min(end-front+1,minLen);/
//                res = s.substring(front,front+minLen);
//            }
            if (count == t.length()&&end - front + 1 < minLen){//当且仅当第一次到minlen, 这时候,是有必要的
                minLen = end - front + 1;
                res  = s.substring(front, end+1);//注意endIndex是不包括在子串中
            }

        }
        //返回最短字符串
        return res;
    }
}

class Solution1 {
    public String minWindow(String s, String t) {
        //维护s串中滑动窗口中各个字符出现次数
        Map<Character, Integer> hs = new HashMap<>();
        //维护t串中各个字符出现次数
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0)+1);
        }
        String ans="";
        //cnt维护s串[left,right]中满足t串的元素的个数，记录相对应字符的总数
        int len=Integer.MAX_VALUE,cnt=0;
        //区间[left,right]表示当前滑动窗口
        for (int left=0,right = 0; right < s.length(); right++) {
            hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0)+1);
            //如果ht表中也包含当前字符
            if (ht.containsKey(s.charAt(right))) {
                //并且hs表中的字符个数<=ht表中的字符个数,说明该字符是必须的，并且还未到达字符串t所要求的数量
                if (hs.get(s.charAt(right))<=ht.get(s.charAt(right))) {
                    cnt++;
                }
            }
            //收缩滑动窗口
            //如果左边界的值不在ht表中 或者 它在hs表中的出现次数多于ht表中的出现次数
            while(left < right && (!ht.containsKey(s.charAt(left)) || hs.get(s.charAt(left)) > ht.get(s.charAt(left)))){
                hs.put(s.charAt(left),hs.get(s.charAt(left)) - 1);
                left++;
            }
            //此时滑动窗口包含符串 t 的全部字符
            if (cnt==t.length()&&right-left+1<len) {
                len=right-left+1;
                ans=s.substring(left,right+1);
            }
        }
        return ans;
    }
}
